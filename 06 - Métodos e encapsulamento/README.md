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
