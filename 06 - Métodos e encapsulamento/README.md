<h1>Aula 01 - Crie métodos com argumento e valores de retorno</h1>

* Classes, enums e interfaces podem ter métodos definidos em seus corpos.

* Todo método tem uma assinatura (também chamada de interface) e um corpo (somente no caso de métodos não abstratos).

* A assinatura do método sempre tem:

* um nome seguindo as regras de identificadores;
* um tipo de retorno;
* um conjunto de parâmetros (pode ser vazio), cada um com seu nome e seu tipo;
* um modificador de visibilidade (nem que seja implícito, package-private).
* E, ainda na assinatura, podemos ter:

* final - em caso de herança, o método não pode ser sobrescrito nas classes filhas;
* abstract - obriga as classes filhas a implementarem o método. O método abstrato não pode ter corpo definido;
* static - atributos acessados direto na classe, sem instâncias;
* synchronized - lock da instância;
* native - não cai nesta prova. Permite a implementação do método em código nativo (JNI);
* strictfp - não cai nesta prova. Ativa o modo de portabilidade matemática para contas de ponto flutuante.
* throws <EXCEPTIONS> - após a lista de parâmetros, podemos indicar quantas exceptions quisermos para o throws.
* A ordem dos elementos na assinatura dos métodos é sempre a seguinte, sendo que os modificadores podem aparecer em qualquer ordem: <MODIFICADORES> <TIPO_RETORNO> <NOME> (<PARÂMETROS>) <THROWS_EXCEPTIONS>

* Parâmetros
* Em Java, usamos parâmetros em métodos e construtores. Definimos uma lista de parâmetros sempre declarando seus tipos e nomes e separando por vírgula:


```java
class Param {
    void teste(int a, int b) {

    }
}
```

* // chamada
* p.teste(1, 2);
* A declaração das variáveis é feita na declaração dos métodos. A inicialização dos valores é feita por quem chama o método. (Note que, em Java, não é possível ter valores default para parâmetros e todos são obrigatórios, não podemos deixar de passar nenhum).

* O único modificador possível de ser marcado em parâmetros é final, para indicar que aquele parâmetro não pode ter seu valor modificado depois da chamada do método (considerado boa prática):

```java
class Param {
    void teste (final int a) {
        a = 10; // não compila
    }
}
```

* Promoção em parâmetros
* Temos que saber que nossos parâmetros também estão sujeitos à promoção de primitivos e ao polimorfismo. Por exemplo, a classe a seguir ilustra as duas situações:

```java
class Param {
    void primitivo (double d) {

    }

    void referencia (Object o) {

    }
}
```

* O primeiro método espera um double. Mas se chamarmos passando um int, um float ou qualquer outro tipo compatível, este será promovido a double e a chamada funciona:

```java
    Param p = new Param();
    p.primitivo(10);
    p.primitivo(10L);
    p.primitivo(10F);
    p.primitivo((short) 10);
    p.primitivo((byte) 10);
    p.primitivo('Z');
```

* A mesma coisa ocorre com o método que recebe Object: podemos passar qualquer um que é um Object, ou seja, qualquer objeto:

```java
    Param p = new Param();
    p.referencia(new Carro());
    p.referencia(new Moto());
```

* Retornando valores
* Todo método pode retornar um valor ou ser definido como void, quando não devolve nada:

```java
class A {
    int numero() {
        return 5;
    }
    void nada() {
        return;
    }
}
```

* No caso de métodos de tipo de retorno void (nada), podemos omitir a última instrução:

```java
class A {
    void nada() {
        // return; // pois esta linha é opcional
    }
}
```

* Um método desse tipo também pode ter um retorno antecipado:

```java
class A {
    void nada(int i) {
        if(i >= 0) return;
        System.out.println("negativo");
    }
}
```

* Não podemos ter nenhum código que seria executado após um retorno:

```java
class A {
    void nada(int i) {
        if(i >= 0) {
            return;

            // não compila, pois nunca chegará aqui
            System.out.println("era positivo ou zero"); 
        }
        System.out.println("negativo");
    }
}
```

* Todo método que possui um tipo de retorno definido (isto é, diferente de void), deve retornar algo ou jogar uma Exception em cada um dos caminhos de saída possíveis do método, caso contrário o código não compila:

```java
String metodo(int a) {
    if(a > 0) {
        return "positivo";
    } else if(a < 0) {
        return "negativo";
    }
    //não compila, o que acontece se não for nem if nem else if?
}
```

* Lembre-se que isso é feito pelo compilador, então ele não sabe os valores da variável a e se todos os casos foram cobertos:

```java
String metodo(int a) {
    if(a > 0) {
        return "positivo";
    } else if(a <= 0) {
        return "negativo ou zero";
    }
    //não compila, o que acontece se não for nem if nem else if?
    //o compilador não consegue analisar os dois casos
}
```

* Podemos jogar uma exception ou colocar um return:

```java
String metodo(int a) {
    if(a > 0) {
        return "positivo";
    } else if(a < 0) {
        return "negativo";
    }
    return "zero";
}


String metodo2(int a) {
    if(a > 0) {
        return "positivo";
    } else if(a < 0) {
        return "negativo";
    }
    throw new RuntimeException("não quero zero!");
}
```

* Métodos que não retornam nada não podem ter seu resultado atribuído a uma variável:

```java
void metodo() {
    System.out.println("oi");
}
void metodo2() {
    // não compila, o método acima não retorna nada
    int i = metodo(); 
}
```

* Pelo outro lado, mesmo que um método retorne algo, seu retorno pode ser ignorado:

```java
int metodo() {
    System.out.println("oi");
    return 5;
}
void metodo2() {
    int i = metodo(); // i = 5
    // chamei novamente e não retornei nada, sem problemas
    metodo(); 
}
```

<h1>Aula 02 - Aplique a palavra chave static a métodos e campos</h1>

* O modificador estático diz que determinado atributo ou método pertence à classe, e não a cada objeto. Com isso, você não precisa de uma instância para acessar o atributo, basta o nome da classe.

```java
public class Carro {
    public static int totalDeCarros;
}
```

* E depois, para acessar:


* Carro.totalDeCarros = 5;

* Um método estático é um método da classe, podendo ser chamado sem uma instância:

```java
public class Carro{
    private static int totalDeCarros;


    public static int getTotalDeCarros() [
        return totalDeCarros;
    }
}

int i = Carro.getTotalDeCarros();
```

* O que não podemos fazer é usar um método/atributo de instância de dentro de um método estático:

```java
public class Carro{
    private static int totalDeCarros;
    private int peso;

    public static int getPeso() {
        return peso;
    }
}
```

* Esse código não compila, pois peso é um atributo de instância. Se alguém chamar esse método, que valor ele retornaria, já que não estamos trabalhando com nenhuma instância de carro em específico?

* Repare que a variável estática pode acessar um método estático, e esse método acessar algo ainda não definido e ter um resultado inesperado à primeira vista:

```java
    static int b = getMetodo();
    public static int getMetodo() {
        return a;
    }
    static int a = 15;
```

* O valor de b será 0, e não 15, uma vez que a variável a ainda não foi inicializada e possui seu valor padrão quando da execução do método getMetodo.

* Outro caso interessante é que o atributo estático for de um tipo não primitivo, que começa com valores null, pode gerar um comportamento não esperado.

```java
static Integer inicial = 10;
static Integer segunda = inicial + 5; // compila

static Integer outra;
static void inicializa() {
   outra = 10;
}
static Integer naoExecuta = outra + 1;
// compila mas dá exception em runtime, NullPointerException durante a inicializacao dessa linha
```

* Um detalhe importante é que membros estáticos podem ser acessados através de instâncias da classe (além do acesso direto pelo nome da classe).

```java
    Carro c = new Carro();
    int i = c.getTotalDeCarros();
```

* Cuidado com essa sintaxe, que pode levar a acreditar que é um método de instância. É uma sintaxe estranha mas que compila e acessa o método estático normalmente.

* Além disso, esteja atento pois, caso uma classe possua um método estático, ela não pode possuir outro método não estático com assinatura que a sobrescreveria (mesmo que em classe mãe/filha):

```java
class A {
    static void a() { // não compila
    }
    void a() { // não compila
    }
}

class B {
    static void a() {
    }
}
class C extends B {
    void a() { // não compila
    }
}
```

* Outro ponto importante a tomar nota é que o ::binding:: do método é feito em compilação, portanto, o método invocado não é detectado em tempo de execução. Leve em consideração:

```java
class A {
    static void metodo() {
        System.out.println("a");
    }
}

class B extends A {
    static void metodo() {
        System.out.println("b");
    }
}
```

* Caso o tipo referenciado de uma variável seja A em tempo de compilação, o método será o da classe A. Se for referenciado como B, será o método da classe B:

```java
        A a= new A();
        a.metodo(); // a

        B b= new B();
        b.metodo(); // b

        A a2 = b;
        a2.metodo(); // a
    }
}
```

* A definição de uma variável estática pode invocar métodos e variáveis estáticas:

```java
class A {
    static int idade = calculaIdade();
    static int calculaIdade() {
        return 18;
    }
}
```

* A palavra-chave static pode ser aplicada a classes aninhadas, mas este tópico não é cobrado nesta primeira certificação.


<h1>Aula 03 - Crie métodos sobrecarregados</h1>

* Um método pode ter o mesmo nome que outro, desde que a chamada não fique ambígua: os argumentos que são recebidos têm de ser obrigatoriamente diferentes, seja em quantidade ou em tipos.

```java
class Teste {
    public void metodo(int i) {
    }

    protected void metodo(double x) {
    }
}
```

* Já o código a seguir não compila:

```java
class Teste {
    public int metodo() {}
    protected double metodo() {}
}
```

* Nesse exemplo, temos ambiguidade porque o tipo de retorno não é suficiente para distinguir os métodos durante a chamada.

* O Java decide qual das assinaturas de método sobrecarregado (overloaded) será utilizada em tempo de compilação.

* Métodos sobrecarregados podem ter ou não um retorno diferente e uma visibilidade diferente. Mas eles não podem ter exatamente os mesmos tipos e quantidade de parâmetros. Nesse caso, seria uma sobrescrita de método.

* No caso de sobrecarga com tipos que possuem polimorfismo, como em Object ou String, o compilador sempre invoca o método com o tipo mais específico (menos genérico):

```java
public class Teste {
    void metodo(Object o) {
        System.out.println("object");
    }
    void metodo(String s) {
        System.out.println("string");
    }

    public static void main(String[] args) {
        new Teste().metodo("string"); // imprime string
    }
}
```

* Se quisermos forçar a invocação ao método mais genérico, devemos fazer o casting forçado:

```java
public class Teste {
    void metodo(Object o) {
        System.out.println("object");
    }
    void metodo(String s) {
        System.out.println("string");
    }

    public static void main(String[] args) {
        new Teste().metodo((Object)"string"); // imprime object
    }
}
```

* Um exemplo clássico é a troca de ordem, que é vista como sobrecarga, afinal são dois métodos totalmente distintos:

```java
void metodo(String i, double x) {
}
void metodo(double x, String i) {
}
```

* Porém, apesar de compiláveis, às vezes o compilador não sabe qual método deverá chamar. No caso a seguir, os números 2 e 3 podem ser considerados tanto int quanto double, portanto, o compilador fica perdido em qual dos dois métodos invocar, e decide não compilar:

```java
public class Teste {
    void metodo(int i, double x) {
    }
    void metodo(double x, int i) {
    }

    public static void main(String[] args) {
        new Teste().metodo(2, 3);
    }
}
```

* Isso também ocorre com referências, que é diferente do caso com tipo mais específico. Aqui não há tipo mais específico, pois onde um é mais específico, o outro é mais genérico:

```java
public class Xpto {
    void metodo(Object o, String s) {
        System.out.println("object");
    }
    void metodo(String s, Object o) {
        System.out.println("string");
    }

    public static void main(String[] args) {
        new Xpto().metodo("string", "string");
    }
}
```

* Diferente do caso em que o segundo método é mais específico:

```java
class Xpto2 {
    void metodo(Object o, Object o2) {
        System.out.println("object");
    }
    void metodo(String s, String s2) {
        System.out.println("string");
    }

    public static void main(String[] args) {
        new Xpto2().metodo("string", "string"); // imprime string
    }
}
```

<h1>Aula 04 - Diferença entre o construtor padrão e construtores definidos pelo usuário</h1>

* Quando não escrevemos um construtor na nossa classe, o compilador nos dá um construtor padrão. Esse construtor, chamado de default não recebe argumentos, tem a mesma visibilidade da classe e tem a chamada a super().

* A classe a seguir:

```java
class A {
}
```

* ... na verdade, acaba sendo:

```java
class A {
    A() {
        super();
    }
}
```

* Caso você adicione um construtor qualquer, o construtor default deixa de existir:

```java
class A {}
class B {
    B(String s) {}
}
class Teste {
    public static void main(String[] args) {
        new A(); // construtor padrão, compila
        new B(); // não existe mais construtor padrão
        new B("CDC"); // construtor existente
    }
}
```

* Dentro de um construtor você pode acessar e atribuir valores aos atributos, suas variáveis membro:

```java
class Teste {
    int i;
    Teste() {
        i = 15; // agora i vale 15
        System.out.println(i); // 15
    }

    public static void main(String[] args) {
        new Teste();
    }
}
```

* Os valores inicializados com a declaração das variáveis são inicializados antes do construtor, justamente por isso o valor inicial de i é 0, o valor padrão de uma variável int membro:

```java
class Teste {
    int i;
    Teste() {
        System.out.println(i); // vale 0 por padrão
        i = 15; // agora i vale 15
        System.out.println(i); // 15
    }

    public static void main(String[] args) {
        new Teste();
    }
}
```

* Vale lembrar que variáveis membro são inicializadas automaticamente para: numéricas 0, boolean false, referências null.

* Cuidado ao acessar métodos cujas variáveis ainda não foram inicializadas no construtor. O exemplo a seguir mostra um caso em que o método de inicialização é invocado antes de setar o valor da variável no construtor, o que causa um NullPointerException.

```java
class A {

    int i = 15;
    String nome;
    int tamanho = tamanhoDoNome();

    A(String nome) {
        this.nome = nome;
    }

    int tamanhoDoNome() {
        return nome.length();
    }

    A() {
    }

}
```


* Mesmo que inicializemos a variável fora do construtor, após a chamada do método pode ocorrer um erro, como no caso a seguir, de um outro NullPointerException:

```java
class A {

    int i = 15;
    String nome;
    int tamanho = tamanhoDoSobrenome();
    String sobrenome = "Silveira";

    A(String nome) {
        this.nome = nome;
    }

    int tamanhoDoSobrenome() {
        return sobrenome.length();
    }

    A() {
    }

}
```

* Mudar a ordem da declaração das variáveis resolve o problema, uma vez que o método é agora invocado após a inicialização da variável sobrenome:

```java
class A {

    int i = 15;
    String nome;
    String sobrenome = "Silveira";
    int tamanho = tamanhoDoSobrenome();

    A(String nome) {
        this.nome = nome;
    }

    int tamanhoDoSobrenome() {
        return sobrenome.length();
    }

    A() {
    }

}
```

* Cuidado ao invocar métodos no construtor e variáveis estarem nulas:

```java
class Teste {
    String nome;
    Teste() {
        testaTamanho(); // NullPointerException
        nome = "aprendendo";
    }

    private void testaTamanho() {
        System.out.println(nome.length());
    }

    public static void main(String[] args) {
        new Teste();
    }
}
```

* E mais cuidado ainda caso isso ocorra por causa de sobrescrita de método, em que também poderemos ter essa Exception:

```java
class Base {
    String nome;
    Base() {
        testa();
        nome = "aprendendo";
    }

    void testa() {
        System.out.println("testa");
    }

}
class Teste extends Base {
    void testa() {
        System.out.println(nome.length());
    }
    public static void main(String[] args) {
        new Teste();
    }
}
```

* Já se o método testa for privado, como o binding da chamada ao método é feito em compilação, o método invocado pelo construtor é o da classe mãe, sem dar a Exception:

```java
class Base {
    String nome;
    Base() {
        testa();
        nome = "aprendendo";
    }

    private void testa() {
        System.out.println("testa");
    }

}
class Teste extends Base {
    void testa() {
        System.out.println(nome.length());
    }
    public static void main(String[] args) {
        new Teste();
    }
}
```

* Você pode entrar em loop infinito, cuidado, StackOverflow:

```java
class Teste {
    Teste() {
        new Teste();
    }
    public static void main(String[] args) {
        new Teste();
    }
}
```

* Construtores podem ser de todos os tipos de modificadores de acesso: private, protected, default e public.

* É comum criar um construtor privado e um método estático para criar seu objeto:

```java
class Teste {
    private Teste() {
    }

    public static Teste cria() {
        return new Teste();
    }
}
```

* Tenha muito cuidado com um método com nome do construtor. Se colocar um void na frente, vira um método:

```java
class Teste {
  void Teste() {
    System.out.println("Construindo");
  }

  public static void main(String[] args) {

    new Teste(); 
    // não imprime nada, definimos um método e não o construtor
    new Teste().Teste(); 
    // agora imprime Construindo
  }
}
```

* Existem também blocos de inicialização que não são cobrados na prova.

<h1>Aula 05 - Crie e sobrecarregue construtores</h1>

* Construtores também podem ser sobrecarregados:

```java
class Teste {
    public Teste() {
    }
    public Teste(int i) {
    }
}
```

* Cuidado com os exemplos de sobrecarga com varargs, como vimos antes, e no caso de herança.

* Quando existem dois construtores na mesma classe, um construtor pode chamar o outro através da chamada this. Note que loops não compilam:

```java
class Teste {
    public Teste() {
        System.out.println("construtor simples");
    }
    public Teste(int i) {
        this();
    }
    public Teste(String s) {
        this(s, s);  // não compila, loop
    }
    public Teste(String s, String s2) {
        this(s); // não compila, loop
    }
}
```

* Temos que tomar cuidado com sobrecarga da mesma maneira que tomamos cuidado com sobrecarga de métodos: os construtores invocados seguem as mesmas regras que as de métodos.

* Quando um método utiliza varargs, se ele possui uma variação do método sem nenhum argumento e invocarmos sem argumento, ele chamará o método sem argumentos (para manter compatibilidade com versões anteriores do Java):

```java
void desativa(Cliente... clientes) {
    System.out.println("varargs");
}
void desativa() {
    System.out.println("sem argumento");
}
void metodo() {
    desativa(); // imprime sem argumento
}
```

* A instrução this do construtor deve ser sempre a primeira dentro do construtor:

```java
class Teste {
    Teste() {
        String valor = "valor...";
        this(valor); // não compila
    }

    Teste(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new Teste();
    }
}
```

* Justo por isso não é possível ter duas chamadas a this:

```java
class Teste {
    Teste() {
        this(valor);
        this(valor); // não compila
    }

    Teste(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new Teste();
    }
}
```

* A instrução this pode envolver instruções:

```java
class Teste {
    Teste() {
        this(valor());
    }

    private static String valor() {
        return "valor...";
    }

    Teste(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new Teste();
    }
}
```

* A instrução não pode ser um método da própria classe, pois o objeto não foi construído ainda:

```java
class Teste {
    Teste() {
        this(valor()); // valor não é estático, não compila
    }

    private String valor() {
        return "valor...";
    }

    Teste(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new Teste();
    }
}
```

<h1>Aula 06 - Aplique modificadores de acesso</h1>

* Os modificadores de acesso, ou modificadores de visibilidade, servem para definir quais partes de cada classe (ou se uma classe inteira) estão visíveis para serem utilizadas por outras classes do sistema. Só é permitido usar um único modificador de acesso por vez:

```java
private public int x; // não compila
```

* O Java possui os seguintes modificadores de acesso:

```java
public
protected
```

* Nenhum modificador, chamado de default

```java
private
```

* Classes e interfaces só aceitam os modificadores public ou default.

* Membros (construtores, métodos e variáveis) podem receber qualquer um dos quatro modificadores.

* Variáveis locais (declaradas dentro do corpo de um método ou construtor) e parâmetros não podem receber nenhum modificador de acesso, mas podem receber outros modificadores.

* Top Level Classes e Inner Classes

* Classes internas (nested classes ou inner classes) são classes que são declaradas dentro de outras classes. Esse tipo de classe pode receber qualquer modificador de acesso, já que são consideradas membros da classe onde foram declaradas (top level class).

* Nesta certificação não são cobradas classes internas, apenas top level classes.

* Para entender como os modificadores funcionam, vamos imaginar as seguintes classes:

```java
package forma;

class Forma{
    double lado;
    double getArea(){
        return 0;
    }
}

package forma;

class Quadrado extends Forma{}

package forma.outro;
import forma.*;

class Triangulo extends Forma{}
Public
```

* O modificador public é o menos restritivo de todos. Classes, interfaces e membros marcados com esse modificador podem ser acessados de qualquer componente, em qualquer pacote. Vamos alterar nossa classe Forma, marcando-a e todos seus membros com o modificador public:

```java
package forma;

public class Forma{
    public double lado;
    public double getArea(){
        return 0;
    }
}
```

* Agora vamos fazer um teste:

```java
package forma.outro;
import forma.*;

public class TesteOutroPacote{

    public static void main(String... args){
        Forma f = new Forma(); //acesso a classe forma
        f.lado = 5.5; //acesso ao atributo lado
        f.getArea(); //acesso ao método getArea()
    }
}
```

* Repare que, mesmo nossa classe TesteOutroPacote estando em um pacote diferente da classe Forma, é possível acessar a classe e todos os membros declarados como public.

```java
Protected
```

* Membros definidos com o modificador protected podem ser acessados por classes e interfaces no mesmo pacote, e por qualquer classe que estenda aquela onde o membro foi definido, independente do pacote.

* Vamos modificar nossa classe Forma para entendermos melhor:

```java
package forma;

public class Forma{
    protected double lado; // agora protected
    public double getArea(){}
}
```

* Com o modificador protected, nossa classe de testes em outro pacote não compila mais:

```java
package forma.outro;
import forma.*;

public class TesteOutroPacote{

    public static void main(String... args){
        Forma f = new Forma(); 
        f.lado = 5.5; // erro de compilação
        f.getArea(); 
    }
}
```

* Se criarmos uma nova classe de teste no pacote forma, conseguimos acessar novamente o atributo:

```java
package forma;

public class Teste{

    public static void main(String... args){
        Forma f = new Forma(); 
        f.lado = 5.5; // compila normal, mesmo pacote
    }
}
```

* Embora esteja em um pacote diferente, a classe Triangulo consegue acessar o atributo lado, já que ela estende da classe Forma:

```java
package forma.outro;
import forma.*;

class Triangulo extends Forma{

    public void imprimeLado(){
        //Como é uma classe filha, acessa 
        //normalmente os membros protected da classe mãe.
        System.out.println("O Lado é " + lado);
    }
}
```

* Agora repare que, se efetuarmos o casting do objeto atual para uma Forma, não podemos acessar seu lado:

```java
package outro;
import forma.*;

class Triangulo extends Forma{

    public void imprimeLado(){
        // compila
        System.out.println("O Lado é " + lado); 

        // não compila
        System.out.println("O Lado é " + ((Forma) this).lado); 
    }
}
```

* Isso ocorre porque estamos dizendo que queremos acessar a variável membro lado de um objeto através de uma referência para este objeto, e não diretamente. Diretamente seria o uso puro do this ou nada. Nesse caso, após usar o this, usamos um casting, o que deixa o compilador perdido.

```java
Default
```

* Se não definirmos explicitamente qual o modificador de acesso, podemos dizer que aquele membro está usando o modificador default, também chamado de package private. Neste caso, os membros da classe só serão visíveis dentro do mesmo pacote:

```java
package forma;

public class Forma{
    protected double lado; 
    public double getArea(){
        return 0;
    }
    double getPerimetro(){ //default access 
        return 0;
    }
}
```

* O método getPerimetro() só será visível para todas as classes do pacote forma. Nem mesmo a classe Triangulo - que, apesar de herdar de Forma, está em outro pacote - consegue ver o método.

```java
package outro;
import forma.*;

class Triangulo extends Forma{

    public void imprimePerimetro(){
        //Erro de compilação na linha abaixo
        System.out.println("O Perímetro é " + getPerimetro());
    }
}
```

* Palavra-chave %%default%%
* Lembre-se! A palavra-chave default é usada para definir a opção padrão em um bloco switch, ou para definir um valor inicial em uma Annotation. Usá-la em uma declaração de classe ou membro é inválido e causa um erro de compilação:

```java
default class Bola{ //ERRO
    default String cor; // ERRO
}
```

* A partir do Java 8, a palavra default também pode ser usada para definir uma implementação inicial de um método.

* Mas e se declararmos uma classe com o modificador default? Isso vai fazer com que aquela classe só seja visível dentro do pacote onde foi declarada. Não importa quais modificadores os membros dessa classe tenham, se a própria classe não é visível fora de seu pacote, nenhum de seus membros é visível também.

* Veja a classe Quadrado, que está definida com o modificador default:

```java
package forma;

class Quadrado extends Forma{}
```

* Veja o seguinte código, usando a classe TesteOutroPacote. Perceba que não é possível usar a classe Quadrado, mesmo importando todas as classes do pacote forma:

```java
package outro;
import forma.*;

public class TesteOutroPacote{

    public static void main(String... args){
        Quadrado q = new Quadrado(); // erro, esta classe não é
                                     //visível
    }
}
```

* Linha com erro de compilação

* Eventualmente, na prova, é perguntado em quais linhas ocorreram os erros de compilação. É bem importante prestar atenção nesse detalhe.

* Por exemplo, neste caso, o erro sempre acontecerá quando tentarmos acessar a classe Quadrado, que não é visível fora de seu pacote:

```java
package outro;

//import de todas as classes PÚBLICAS do pacote, nenhum erro
import forma.*; 


public class TesteOutroPacote{

    public static void main(String... args){
        // erro na linha 8, Quadrado não é visível, pois não 
        // é pública
        Quadrado q = new Quadrado(); 
    }
}
```

* O mesmo código pode apresentar erro em uma linha diferente, apenas mudando o import. Repare que o código a seguir dá erro nas duas linhas, tanto do import quanto na tentativa de uso:

```java
package outro;
// erro na linha 3, não podemos importar classes não públicas 
import forma.Quadrado;

public class TesteOutroPacote{

    public static void main(String... args){

        //Erro, pois Quadrado não é acessível.
        Quadrado q = new Quadrado(); 
    }
}
```

* É muito importante testar vários trechos de código, para ver exatamente em quais linhas de código o erro de compilação aparecerá.

```java
Private
```

* private é o mais restritivo de todos os modificadores de acesso. Membros definidos como private só podem ser acessados de dentro da classe e de nenhum outro lugar, independente de pacote ou herança:

```java
package forma;

public class Forma{
    protected double lado;
    public double getArea(){}

    //cor só pode ser acessada dentro da classe Forma,
    //nem as classe Quadrado e Triangulo conseguem acessar
    private String cor;

}
```

* Private e classes aninhadas ou anônimas

* Classes aninhadas ou anônimas podem acessar membros privados da classe onde estão contidas. Na certificação tais classes não são cobradas.

* Métodos privados e padrão não podem ser sobrescritos. Se uma classe o "sobrescreve", ele simplesmente é um método novo, portanto não podemos dizer que é sobrescrita. Veremos isso mais a fundo na seção sobre sobrescrita.

* Resumo das regras de visibilidade

* Todos os membros da classe com o modificador de private só podem ser acessados de dentro dela mesma.

* Todos os membros da classe sem nenhum modificador de visibilidade, ou seja, com visibilidade package-private, podem ser acessados de dentro da própria classe ou de dentro de qualquer outra classe, interface ou enum do mesmo pacote.

* Todos os membros da classe com o modificador protected podem ser acessados:

* de dentro da classe, ou de dentro de qualquer outra classe, interface ou enum do mesmo pacote;

* de dentro de alguma classe que deriva direta ou indiretamente da classe, independente do pacote. O membro protected só pode ser chamado através da referência this, ou por uma referência que seja dessa classe filha.
* Todos os membros da classe com o modificador public podem ser acessados de qualquer lugar da aplicação.

* E não podemos ter classes/interfaces/enums top-level como private ou protected.

* Uma classe é dita top-level se ela não foi definida dentro de outra classe, interface ou enum. Analogamente, são definidas as interfaces top-level e os enums top-level.

