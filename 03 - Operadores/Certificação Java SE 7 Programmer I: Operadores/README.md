<h1>Aula 01 - Use operadores Java</h1>

* Use Java Operators
* SE a expressão do lado direito for menos abrangente do que do lado esquerdo.
* Objetos trabalhamos com referencia, e tipos primitivos trabalhamos com valores.
* Operador de atribuição com referência está copiando a referência

* Para manipular os valores armazenados das variáveis, tanto as primitivas quanto as não primitivas, a linguagem de programação deve oferecer operadores. Um dos operadores mais importantes é o que permite guardar um valor em uma variável. Esse operador é denominado operador de atribuição.

* No Java, o símbolo = representa o operador de atribuição. Para atribuir um valor precisamos de uma variável à qual será atribuído o valor, e do valor:

```java
long idade = ; // não compila, onde está o valor?
long = 15; // não compila, onde está o nome da variável?
long idade = 15; // compila
idade = 15; 
// compila desde que a variável tenha sido declarada 
// anteriormente
```

* Para um valor ser atribuído a uma variável, ambos devem ser compatíveis. Um valor é compatível com uma variável se ele for do mesmo tipo dela ou de um tipo menos abrangente.

```java
// Iniciando uma variável com o operador de atribuição "=".
int idade = 10;

// O valor literal 10 é do tipo int e a variável é do tipo long.
// Como int é menos abrangente que long essa atribuição está 
// correta.
long idade = 10;
```

* Procure sempre se lembrar dos tamanhos dos primitivos quando estiver fazendo a prova. int é um número médio, será que ele "cabe" em uma variável do tipo long (número grande)? Sim, logo o código compila. Mais exemplos:

```java
    int a = 10;      // tipos iguais
    long b = 20;     // int cabe em um long
    float c = 10f;  // tipos iguais
    double d = 20.0f; // float cabe em um double
    double e = 30.0; // tipos iguais
    float f = 40.0; // erro, double não cabe em um float.
    int g = 10l; // erro, long não cabe em int
    float h = 10l; // inteiros cabem em decimais        
    double i = 20; // inteiros cabem em decimais
    long j = 20f; // decimais não cabem em inteiros
```
* A exceção a essa regra ocorre quando trabalhamos com tipos inteiros menos abrangentes que int (byte, short e char). Nesses casos, o compilador permite que atribuamos um valor inteiro, desde que compatível com o tipo:

```java
        byte b1 = 10;
        byte b2 = 200; // não compila, estoura byte

        char c1 = 10;
        char c2 = -3; // não compila, char não pode ser negativo
```

* Atribuição e referência
* Quando trabalhamos com referências, temos que lembrar do polimorfismo:

```java
    List<String> lista = new ArrayList<String>();
```

* E no caso do Java 7, quando atribuímos com ::generics:: podemos usar o operador diamante:

```java
    // operador diamante na atribuição e inicialização:
    ArrayList<String> lista = new ArrayList<>();

    // operador diamante e polimorfismo junto:
    List<String> lista = new ArrayList<>();
```
* Lembre que as atribuições em Java são por cópia de valor, sempre. No tipo primitivo, copiamos o valor, em referências a objetos, copiamos o valor da referência (não duplicamos o objeto):

```java
    List<String> lista = new ArrayList<>();

    // copia o valor da referência, o objeto é o mesmo
    List<String> lista2 = lista; 
    lista2.add("Guilherme");

    // verdadeiro
    System.out.println(lista.size() == lista2.size());

    int idade = 15;

    int idade2 = idade; // copia o valor
    idade2 = 20;

    System.out.println(idade == idade2); // falso
```

<h1>Aula 02 - Operadores Aritiméticos</h1>

* Operadores aritméticos

* Os cálculos sobre os valores das variáveis primitivas numéricas são feitos com os operadores aritméticos. A linguagem Java define operadores para as principais operações aritméticas (soma, subtração, multiplicação e divisão).

```java
int dois = 2;
int dez = 10;

// Fazendo uma soma com o operador "+".
int doze = dois + dez;

// Fazendo uma subtração com o operador "-".
int oito = dez - dois;

// Fazendo uma multiplicação com o operador "*".
int vinte = dois * dez;

// Fazendo uma divisão com o operador "/".
int cinco = dez / dois;
```
* Além desses, há um operador para a operação aritmética "resto da divisão".

```java
int dois = 2;
int dez = 10;

// Calculando o resto da divisão de 10 por 2.
int zero = dez % dois;
```
* O resultado de uma operação aritmética é um valor. A dúvida que surge é qual será o tipo dele. Para descobrir o tipo do valor resultante de uma operação aritmética, devem-se considerar os tipos das variáveis envolvidas.

* A regra é a seguinte: o resultado é do tipo mais abrangente entre os valores das variáveis envolvidas ou, no mínimo, o int.

```java
int idade = 15;
long anos = 5;

// ok, o maior tipo era long
long daquiCincoAnos = idade + anos; 

// não compila, o maior tipo era long, devolve long
int daquiCincoAnos2 = idade + anos; 
```

* Mas devemos lembrar da exceção: o mínimo é um int:

```java
byte b = 1;
short s = 2;

// devolve no mínimo int, compila
int i = b + s; 

// não compila, ele devolve no mínimo int
byte b2 = i + s; 

// compila forçando o casting, correndo risco de perder 
// informação
byte b2 = (byte) (i + s); 
```

* Divisão por zero
* Dividir (ou usar mod) um inteiro por zero lança uma ArithmeticException. Se o operando for um float ou double, isso gera infinito positivo ou negativo (depende do sinal do operador). As classes Float e Double possuem constantes para esses valores.

```java
int i = 200;
int v = 0;

// compila, mas exception
System.out.println(i / v); 

// compila e roda, infinito positivo
System.out.println(i / 0.0); 
```

* Ainda existe o valor NaN (Not a Number), gerado pela radiciação de um número negativo e por algumas contas com números infinitos.

```java
double positivoInfinito = 100 / 0.0;
double negativoInfinito = -100 / 0.0;

// número não definido (NaN)
System.out.println(positivoInfinito + negativoInfinito); 
```

<h1>Aula 03 - Operadores de comparação</h1>

* Comparadores
* A comparação entre os valores de duas variáveis é feita através dos operadores de comparação. O mais comum é comparar a igualdade e a desigualdade dos valores. Existem operadores para essas duas formas de comparação.

* == - igual
* != - diferente

* Além disso, os valores numéricos ainda podem ser comparados em relação à ordem.

* > - maior
* < - menor
* >= - maior ou igual
* <= - menor ou igual
* Uma comparação pode devolver dois valores possíveis: verdadeiro ou falso. No Java, uma comparação sempre devolve um valor boolean.

```java
System.out.println(1 == 1);        // true.
System.out.println(1 != 1);        // false.
System.out.println(2 < 1);        // false.
System.out.println(2 > 1);        // true.
System.out.println(1 >= 1);        // true.
System.out.println(2 <= 1);        // false.
```
* Toda comparação envolvendo valores numéricos não considera o tipo do valor. Confira somente se eles têm o mesmo valor ou não, independente de seu tipo:

```java
// true.
System.out.println(1 == 1.0);    

// true.
System.out.println(1 == 1);        

// true. 1.0 float é 1.0 double
System.out.println(1.0f == 1.0d);    

// true. 1.0 float é 1 long
System.out.println(1.0f == 1l);
```
* Os valores não primitivos (referências) e os valores ::boolean:: devem ser comparados somente com dois comparadores, o de igualdade (==) e o de desigualdade (!=).

```java
// não compila, tipo não primitivo só aceita != e ==
System.out.println("Mario" > "Guilherme"); 

// não compila, boolean só aceita != e ==
System.out.println(true < false);
```
* Não podemos comparar tipos incomparáveis, como um boolean com um valor numérico. Mas podemos comparar chars com numéricos.

```java
// não compila, boolean é boolean
System.out.println(true == 1); 

// compila, 'a' tem valor numérico também
System.out.println('a' > 1);
```
* Cuidado, é muito fácil comparar atribuição com comparação e uma pegadinha aqui pode passar despercebida, como no exemplo a seguir:

```java
int a = 5;
System.out.println(a = 5); // não imprime true, imprime 5
```
* Precisão
* Ao fazer comparações entre números de ponto flutuante, devemos tomar cuidado com possíveis problemas de precisão. Qualquer conta com estes números pode causar um estouro de precisão, fazendo com que ele fique ligeiramente diferente do esperado. Por exemplo, 1 == (100.0 / 100) pode não ser verdadeiro caso a divisão tenha uma precisão não exata.

<h1>Aula 04 - Operadores lógicos</h1>

* Operadores lógicos
* Muitas vezes precisamos combinar os valores booleans obtidos, por exemplo, com comparações ou diretamente de uma variável. Isso é feito utilizando os operadores lógicos.

* Em lógica, as operações mais importantes são: e, ou, ou exclusivo e negação.

```java
System.out.println(1 == 1 & 1 > 2);    // false.
System.out.println(1 == 1 | 2 > 1);    // true.
System.out.println(1 == 1 ^ 2 > 1);    // false.
System.out.println(!(1 == 1));        // false.
```

* Antes de terminar a avaliação de uma expressão, eventualmente, o resultado já pode ser descoberto. Por exemplo, quando aplicamos a operação lógica e, ao achar o primeiro termo falso não precisamos avaliar o restante da expressão.

* Quando usamos esses operadores, sempre os dois lados da expressão são avaliados mesmo nesses casos em que não precisariam.

* Para melhorar isso, existem os operadores de curto circuito && e ||. Quando já for possível determinar a resposta final olhando apenas para a primeira parte da expressão, a segunda não é avaliada:

```java
System.out.println(1 != 1 && 1 > 2);  
// false, o segundo termo não é avaliado.

System.out.println(1 == 1 || 2 > 1);  
// true, o segundo termo não é avaliado.
```

* A maior dificuldade com operadores de curto circuito é se a segunda parte causa efeitos colaterais (um incremento, uma chamada de método). Avaliar ou não (independente da resposta) pode influenciar no resultado final do programa.

```java
public static boolean metodo(String msg) {
    System.out.println(msg);
    return true;
}

public static void main(String[] args) {
    System.out.println(1 == 2 & metodo("oi")); 
    // imprime oi, depois false
    System.out.println(1 == 2 && metodo("tchau")); 
    // não imprime tchau, imprime false

    int i = 10;
    System.out.println(i == 2 & i++ == 0); 
    // imprime false, soma mesmo assim
    System.out.println(i); 
    // imprime 11

    int j = 10;
    System.out.println(j == 2 && j++ == 0); 
    // imprime false, não soma
    System.out.println(j); 
    // imprime 10
}
```

<h1>Operadores de incremento e decremento</h1>

* Incrementos e decrementos
* Para facilitar a codificação, ainda podemos ter operadores que fazem cálculos (aritméticos) e atribuição em uma única operação. Para somar ou subtrair um valor em 1, podemos usar os operadores de incremento/decremento:

```java
    int i = 5;

    // 5 - pós-incremento, i agora vale 6
    System.out.println(i++);    

    // 6 - pós-decremento, i agora vale 5
    System.out.println(i--);

    // 5
    System.out.println(i);
```
* E incrementos e decrementos antecipados:

```java
    int i = 5;

    System.out.println(++i);    // 6 - pré-incremento
    System.out.println(--i);    // 5 - pré-decremento
    System.out.println(i);        // 5
```
* Cuidado com os incrementos e decrementos em relação a pré e pós. Quando usamos pós-incremento, essa é a última coisa a ser executada. E quando usamos o pré-incremento, é sempre a primeira.

```java
    int i = 10;

    // 10, primeiro imprime, depois incrementa
    System.out.println(i++); 

    // 11, valor já incrementado.
    System.out.println(i);   

    // 12, incrementa primeiro, depois imprime
    System.out.println(++i); 

    // 12, valor incrementado.
    System.out.println(i);
```
* Existem ainda operadores para realizar operações e atribuições de uma só vez:


```java
    int a = 10;

    // para somar 2 em a
    a = a + 2;

    //podemos obter o mesmo resultado com:
    a += 2;

    //exemplos de operadores:
    int i = 5;

    i += 10; //soma e atribui
    System.out.println(i);        // 15

    i -= 10; //subtrai e atribui
    System.out.println(i);        // 5

    i *= 3; // multiplica e atribui
    System.out.println(i);        // 15

    i /= 3; // divide a atribui
    System.out.println(i);        // 5

    i %= 2; // divide por 2, e atribui o resto
    System.out.println(i);        // 1

    System.out.println(i+=3); // soma 3 e retorna o resultado: 4
```
* Nesses casos, o compilador ainda dá um desconto para operações com tipos teoricamente incompatíveis. Veja:

```java
    byte b1 = 3; // compila, dá um desconto
    b1 = b1 + 4; // não compila, conta com int devolve int

    byte b2 = 3; // compila, dá um desconto
    b2 += 4; // compila também, compilador gente boa!
```
* Esse último caso compila inclusive se passar valores absurdamente altos: b2+=400 é diferente de b2 = b2 + 400. Ele faz o ::casting:: e roda normalmente.

* Cuidado também com o caso de atribuição com o próprio autoincremento:

```java
int a = 10;
a += ++a + a + ++a;
```
* Como a execução é do primeiro para o último elemento das somas, temos as reduções:

```java
a += ++a + a + ++a;
a = a + ++a + a + ++a;
a = 10 +11 + a + ++a;
a = 10 + 11 + 11 + ++a;
a = 10 + 11 + 11 + 12;
a = 44; // a passa a valer 44
```
* Um outro exemplo de operador pós-incremento, cujo resultado é 1 e 2:

```java
int j = 0;
int i = (j++ * j + j++);
System.out.println(i);
System.out.println(j);
```
* Pois:

```java
i = (0 * j + j++); // j vale 1
i = (0 * 1 + j++); // j vale 1
i = (0 * 1 + 1); // j vale 2
i = 1; // j vale 2
```
* Podemos fazer diversas atribuições em sequência, que serão executadas da direita para a esquerda. O resultado de uma atribuição é sempre o valor da atribuição:

```java
int a = 15, b = 20, c = 30;
a = b = c; // b = 30, portanto a = 30
```
* Outro exemplo mais complexo:

```java
int a = 15, b = 20, c = 30;
a = (b = c + 5) + 5; // c = 30, portanto b = 35, portanto a = 40
```

<h1>Aula 06 - Operador ternário, de referência e de concatenação</h1>

* Operador ternário - Condicional
* Há também um operador para controle de fluxo do programa, como um if. É chamado de operador ternário. Se determinada condição acontecer, ele vai por um caminho, caso contrário vai por outro.

* A estrutura do operador ternário é a seguinte:

* variável = teste_booleano ? valor_se_verdadeiro : valor_se_falso;

```java
int i = 5;
System.out.println(i == 5 ? "verdadeiro": "falso");// verdadeiro
System.out.println(i != 5 ? 1: 2);                   // 2

String mensagem = i % 2 == 0 ? "é par" : "é ímpar";
```
* O operador condicional sempre tem que retornar valores que podemos usar para atribuir, imprimir etc.

* Operador de referência
* Para acessar os atributos ou métodos de um objeto precisamos aplicar o operador . (ponto) em uma referência. Você pode imaginar que esse operador navega na referência até chegar no objeto.

```java
String s = new String("Caelum");

// Utilizando o operador "." para acessar um 
// objeto String e invocar um método.
int length = s.length();
```
* Concatenação de Strings
* Quando usamos Strings, podemos usar o + para denotar concatenação. É a única classe que aceita algum operador fora o ponto.

* Em Java, não há sobrecarga de operadores como em outras linguagens. Portanto, não podemos escrever nossas próprias classes com operadores diversos.

* StringBuilder
* A concatenação de Strings é um syntax sugar que o próprio compilador resolve. No código compilado, na verdade, é usado um StringBuilder.

* Precedência
* Não é necessário decorar a precedência de todos operadores do Java, basta saber o básico, que primeiro são executados pré-incrementos/decrementos, depois multiplicação/divisão/mod, passando para soma/subtração, depois os shifts (<<, >>, >>>) e, por último, os pós-incrementos/decrementos.

* As questões da certificação não entram em mais detalhes que isto.

* Pontos importantes
* Na atribuição de um valor para uma variável primitiva, o valor deve ser do mesmo tipo da variável ou de um menos abrangente.
* EXCEÇÃO À REGRA: Para os tipos byte, short e char, em atribuições com literais do tipo int, o compilador verifica se o valor a ser atribuído está no range do tipo da variável. Toda variável não primitiva está preparada somente para armazenar referências para objetos que sejam do mesmo tipo dela. Toda comparação e toda operação lógica devolve boolean. O resultado de toda operação aritmética é no mínimo int ou do tipo da variável mais abrangente que participou da operação. A comparação de valores numéricos não considera os tipos dos valores. As referências e os valores boolean só podem ser comparados com == ou !=. Toda atribuição é por cópia de valor.

* Observação: O recurso do autoboxing permite fazer algumas operações diferentes envolvendo variáveis não primitivas. Discutiremos sobre autoboxing adiante.

<h1>Aula 07 - Casting</h1>

* Casting de tipos primitivos
* Não podemos atribuir a uma variável de um tipo um valor que não é compatível com ela:

```java
double d = 3.14;
int i = d;
```

* Só podemos fazer essas atribuições se os valores forem ::compatíveis::. Compatível é quando um tipo cabe em outros, ou seja, ele só cabe se o ::range:: (alcance) dele for mais amplo que o do outro.

* byte -> short -> int -> long -> float -> double

* char -> int

* Se estivermos convertendo de um tipo que vai da esquerda para a direita nessa tabelinha, não precisamos de casting, a autopromoção fará o serviço por nós.

* Se estamos indo da direita para a esquerda, precisamos do ::casting:: e não importam os valores que estão dentro. Exemplo:

```java
    double d = 0;
    float  f = d;
```

* Esse código não compila sem um casting! O casting é a maneira que usamos para moldar uma variável de um tipo em outro. Nós estamos avisando o compilador que sabemos da possibilidade de perda de precisão ou truncamento, mas nós realmente queremos fazer isso:

```java
    float  f = (float) d;
```

* Podemos fazer casting entre ponto flutuante e inteiro, o resultado será o número truncado, sem as casas decimais:

```java
    double d = 3.1415;
    int i = (int) d; // 3
```
* Dica
* Não é preciso decorar a sequência int->long->float etc. Basta lembrar os alcances das variáveis. Por exemplo, o char tem dois bytes e guarda um número positivo. Será então que posso atribuir um char a um short? Não, pois um short tem 2 bytes, e usa meio a meio entre os números positivos e negativos.

<h1>Aula 08 - Use parentêses para sobrescrever a precedência de operadores</h1>

* Às vezes desejamos alterar a ordem de precedência de uma linha, e nesses instantes usamos os parênteses:

```java
int a = 15 * 4 + 1; // 15 * 4 = 60, depois 60 + 1 = 61
int b = 15 * (4 + 1); // 4 + 1 = 5, depois 15 * 5 = 75
```

* Devemos tomar muito cuidado na concatenação de String e precedência:

```java
System.out.println(15 + 0 + " é cento e cinquenta"); 
// 15 é cento e cinquenta
System.out.println(15 + (0 + " é cento e cinquenta")); 
// 150 é cento e cinquenta

System.out.println(("guilherme" + " silveira").length()); 
// 18
```

<h1>Aula 09 - Teste a igualdade entre Strings e outros objetos usando == e equals() - Parte 1</h1>

* Observe o seguinte código que cria duas Strings:

```java
String nome1 = new String("Mario");
String nome2 = new String("Mario");
```

* Como já estudamos anteriormente, o operador == é utilizado para comparação. Neste caso, como se tratam de objetos, irá comparar as duas referências e ver se apontam para o mesmo objeto:

```java
String nome1 = new String("Mario");
String nome2 = new String("Mario");

System.out.println(nome1 == nome2); // imprime false
```

* Até aqui tudo bem. Mas vamos alterar um pouco nosso código, mudando a maneira de criar nossas Strings, e rodar novamente:

```java
String nome1 = "Mario";
String nome2 = "Mario";


System.out.println(nome1 == nome2); // o que imprime?
```

* Ao executar o código, vemos que ele imprime true. O que aconteceu?

* Pool de Strings
* O Java mantém um ::pool:: de objetos do tipo String. Antes de criar uma nova String, primeiro o Java verifica neste pool se uma String com o mesmo conteúdo já existe; caso sim, ele a reutiliza, evitando criar dois objetos exatamente iguais na memória. Como as duas referências estão apontando para o mesmo objeto do pool, o == retorna true.

* Mas por que isso não aconteceu antes, com nosso primeiro exemplo? O Java só coloca no pool as Strings criadas usando literais. Strings criadas com o operador new não são colocadas no pool automaticamente.

```java
String nome1 = "Mario"; //será colocada no pool
String nome2 = new String("Mario"); 
/*  
"Mario" é colocado, mas nome2 é outra 
referência, não colocada no pool
*/
```
* Sabendo disso, temos que ter cuidado redobrado quando comparando Strings usando o operador ==:

```java
String s1 = "string";
String s2 = "string";
String s3 = new String("string");

System.out.println(s1 == s2); // true, mesma referencia
System.out.println(s1 == s3); // false, referências diferentes
System.out.println(s1.equals(s3)); // true, mesmo conteúdo
```
* Repare que, mesmo sendo instâncias diferentes, quando comparadas usando o método equals, o retorno é true, caso o conteúdo das Strings seja o mesmo.

<h1>Teste a igualdade entre Strings e outros objetos usando == e equals() - Parte 2</h1>\

* Quando concatenamos literais, a String resultante também será colocada no pool.

```java
String ab = "a" + "b";
System.out.println("ab" == ab); // true
```

* Mas isso é verdade apenas usando literais em ambos os lados da concatenação. Se algum dos objetos não for um literal, o resultado será um novo objeto, que não estará no pool:

```java
String a = "a";
String ab = a + "b"; //usando uma referência e um literal
System.out.println("ab" == ab); // false
```

* Sabemos que Strings são imutáveis, e que cada método chamado em uma String retorna uma nova String, sem alterar o conteúdo do objeto original. Esses objetos resultantes de retornos de métodos não são buscados no pool, são novos objetos:

```java
String str = "um texto qualquer";
String txt1 = "texto";
String txt2 = str.substring(3, 8); //cria uma nova string
System.out.println(txt1 == txt2); // false
System.out.println(txt1.equals(str.substring(3, 8))); // true
```
* os métodos de String sempre criam novos objetos?
* Nem sempre. Se o retorno do método for exatamente o conteúdo atual do objeto, nenhum objeto novo é criado:

```java
String str = "HELLO WORLD";
String upper = str.toUpperCase();          // já está maiúscula
String subs = str.substring(0,11);         // string completa
System.out.println(str == upper);          // true
System.out.println(str == subs);           // true
System.out.println(str == str.toString()); // true
```

* Contando Strings
* Uma questão recorrente na prova é contar quantos objetos do tipo String são criados em um certo trecho de código. Veja o código a seguir e tente descobrir quantos objetos String são criados:

```java
String h = new String ("hello ");
String h1 = "hello ";
String w = "world";

System.out.println("hello ");        
System.out.println(h1 + "world");    
System.out.println("Hello " == h1);
```

* E então? Vamos ver passo a passo:

```java
//Cria 2 objetos, um literal (que vai para o pool) e o outro 
//com o new
String h = new String ("hello ");

//nenhum objeto criado, usa o mesmo do pool
String h1 = "hello ";
//novo objeto criado e inserido no pool
String w = "world"; 

//nenhum  objeto criado, usa do pool
System.out.println("hello ");

//criado um novo objeto resultante da concatenação,
// mas este não vai para o pool
System.out.println(h1 + "world");

//Novo objeto criado e colocado no pool (Hello com H maiúsculo).
System.out.println("Hello " == h1);     // 1
```

* Logo temos 5 Strings criadas.

* Cuidado com String já colocadas no pool
* Para descobrir se uma String foi criada e colocada no pool é necessário prestar muita atenção ao contexto do código e ao enunciado da questão. A String só é colocada no pool na primeira execução do trecho de código. Cuidado com questões que criam Strings dentro de métodos, ou que dizem em seu enunciado que o método já foi executado pelo menos uma vez:

```java
public class Testes {
    public static void main(String[] args) {
        for(int i = 0; i< 10; i++)
            System.out.println(metodo());
    }

    private static String metodo() {
        String x = "x";
        return x.toString();
    }
}
```

* Ao executar essa classe, apenas um objeto String será criado. O único lugar onde a String é criada é na linha 8 do código.


<h1>Aula 11 - Teste a igualdade entre Strings e outros objetos usando == e equals() - Parte 3</h1>

* O método equals
* Para comparar duas referências, podemos sempre usar o operador ==. Dada a classe Cliente:

```java
class Cliente {
    private String nome;
    Cliente(String nome) {
        this.nome = nome;
    }
}

Cliente c1 = new Cliente("guilherme");
Cliente c2 = new Cliente("mario");
System.out.println(c1==c2); // false
System.out.println(c1==c1); // true

Cliente c3 = new Cliente("guilherme");
System.out.println(c1==c3); 
// false, pois não é a mesma 
// referência: são objetos diferentes na memória
```

* Para comparar os objetos de uma outra maneira, que não através da referência, podemos utilizar o método equals, cujo comportamento padrão é fazer a simples comparação com o ==:

```java
Cliente c1 = new Cliente("guilherme");
Cliente c2 = new Cliente("mario");
System.out.println(c1.equals(c2)); // false
System.out.println(c1.equals(c1)); // true

Cliente c3 = new Cliente("guilherme");
System.out.println(c1.equals(c3)); 
// false, pois não é a mesma 
// referência: são objetos diferentes na memória
```

* Isso é, existe um método em Object que você pode reescrever para definir um critério de comparação de igualdade. Classes como String, Integer e muitas outras possuem esse método reescrito, assim new Integer(10) == new Integer(10) dá false, mas new Integer(10).equals(new Integer(10)) dá true.

* É interessante reescrever esse método quando você julgar necessário um critério de igualdade diferente que o == retorna. Imagine o caso de nosso Cliente:

```java
class Cliente {
    private String nome;
    Cliente(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object o) {
        if (! (o instanceof Cliente)) {
            return false;
        }
        Cliente outro = (Cliente) o;
        return this.nome.equals(outro.nome);
    }
}
```

* O método equals não consegue tirar proveito do generics, então precisamos receber Object e ainda verificar se o tipo do objeto passado como argumento é realmente uma Cliente (o contrato do método diz que você deve retornar false, e não deixar lançar exception em um caso desses). Agora sim, podemos usar o método equals como esperamos:

```java
Cliente c1 = new Cliente("guilherme");
Cliente c2 = new Cliente("mario");
System.out.println(c1.equals(c2)); // false
System.out.println(c1.equals(c1)); // true

Cliente c3 = new Cliente("guilherme");
System.out.println(c1.equals(c3)); // true
```

* Cuidado ao sobrescrever o método equals: ele deve ser público, e deve receber Object. Caso você receba uma referência a um objeto do tipo Cliente, seu método não está sobrescrevendo aquele método padrão da classe Object, mas sim criando um novo método (overload). Por polimorfismo o compilador fará funcionar neste caso pois o compilador fará a conexão ao método mais específico, entre Object e Cliente, ele escolherá o método que recebe Cliente:

```java
class Cliente {
    private String nome;
    Cliente(String nome) {
        this.nome = nome;
    }

    public boolean equals(Cliente outro) {
        return this.nome.equals(outro.nome);
    }
}

Cliente c1 = new Cliente("guilherme");
Cliente c2 = new Cliente("mario");
System.out.println(c1.equals(c2)); // false
System.out.println(c1.equals(c1)); // true

Cliente c3 = new Cliente("guilherme");
System.out.println(c1.equals(c3)); // true
System.out.println(c1.equals((Object) c3)); 
// false, o compilador não sabe que Object é cliente, 
// invoca o equals tradicional, e azar do desenvolvedor
```

* Mas caso você use alguma biblioteca (como a API de coleções e de ArrayList do Java), o resultado não será o esperado.

<h1>Aula 12 - Utilize o if e if/else</h1>

* Imagine um programa que aceita comandos do usuário, ou seja, um sistema interativo. De acordo com os dados que o usuário passar, o programa se comporta de maneiras diferentes e, consequentemente, pode dar respostas diferentes.

* O programador, ao escrever esse programa, deve ter recursos para definir o comportamento para cada possível comando do usuário, em outras palavras, para cada situação. Com isso, o programa será capaz de tomar decisões durante a execução com o intuito de mudar o fluxo de execução.

* As linguagens de programação devem oferecer aos programadores maneiras para ::controlar o fluxo de execução dos programas::. Dessa forma, os programas podem tomar decisões que afetam a sequência de comandos que serão executados.

* if / else
* A maneira mais simples de controlar o fluxo de execução é definir que um determinado trecho de código deve ser executado quando uma condição for verdadeira.

* Por exemplo, suponha um sistema de login. Ele deve verificar a autenticidade do usuário para permitir ou não o acesso. Isso pode ser implementado com um if/else do Java.

```java
boolean autentico = true;
if (autentico) {
    System.out.println("Usuario aceito");
} else {
    System.out.println("Usuario incorreto");
}
A sintaxe do if é a seguinte:


if (CONDICAO) {
    // CODIGO 1
} else {
    // CODIGO 2
}
```

* A condição de um if sempre tem que ser um valor booleano:

```java
if(1 - 2) { } // erro, numero inteiro

if(1 < 2) {} //ok, resulta em true

boolean valor = true;
if (valor == false) {} // ok, mas resulta em false

if (valor) {} // ok, valor é boolean
```

* Atenção dobrada ao código a seguir:

```java
int a = 0, b = 1;

if(a = b) {
    System.out.println("iguais");
}
```

* Esta é uma pegadinha bem comum. Repare que não estamos fazendo uma comparação aqui, e sim, uma atribuição (um único =). O resultado de uma atribuição é sempre o valor atribuído, no caso, um inteiro. Logo, este código não compila, pois passamos um inteiro para a condição do if.

* A única situação em que um código assim poderia funcionar é caso a variável atribuída seja do tipo boolean, pois o resultado da atribuição será boolean:

```java
boolean a = true;

if(a = false) {
    System.out.println("Falso!");
}
```

* Neste caso, o código compila, mas não imprime nada. Após a atribuição, o valor da variável a é false, e o if não é executado.

* Caso só tenhamos um comando dentro do if ou else, as chaves são opcionais:

```java
if(!resultado)
    System.out.println("Falso!");
else
    System.out.println("Verdadeiro!");
```

* Caso não tenhamos nada para ser executado em caso de condição false, não precisamos declarar o else:

```java
boolean autentico = true;
if (autentico)
    System.out.println("Usuario aceito");
```

* Mas sempre temos que ter algum código dentro do if, se não o código não compila:

```java
boolean autentico = true;
if (autentico)
else // erro
    System.out.println("Acesso negado");
```

* Na linguagem Java, não existe o comando elseif. Para conseguir o efeito do "elseif", os ifs são colocados dentro dos else.

```java
if (CONDICAO1) {
    // CODIGO 1    
} else if (CONDICAO2) {
    // CODIGO 2    
} else {
    // CODIGO 3
}
```

* Grande parte das perguntas sobre estruturas de if/else são pegadinhas, usando a indentação como forma de distração:

```java
boolean autentico = true;
if (autentico)
    System.out.println("Usuario aceito");
else
    System.out.println("Usuario incorreto");
    System.out.println("Tente novamente");
```

* A mensagem "Tente novamente" sempre é impressa, independente do valor da variável autentico.

* Esse foi um exemplo bem simples, vamos tentar algo mais complicado. Tente determinar o que é impresso:

```java
int valor = 100;
if (valor > 200)
if (valor <400)
if (valor > 300)
    System.out.println("a");
else
    System.out.println("b");
else
    System.out.println("c");
```

* E então? "c"? Vamos reindentar o código para ver se fica mais fácil:

```java
int valor = 100;
if (valor > 200)
    if (valor <400)
        if (valor > 300)
            System.out.println("a");
        else
            System.out.println("b");
    else
        System.out.println("c");
```

* É sempre complicado analisar código não indentado ou mal indentado, e esse recurso é usado extensivamente em várias questões durante a prova, fique esperto!

* Unreachable Code e Missing return
* Um código Java não compila se o compilador perceber que aquele código não será executado sob hipótese alguma:

```java
class Teste {
    public int metodo() {
        return 5;
        System.out.println("Quando isso será executado?");
    }
}

Teste.java:10: unreachable statement
        System.out.println("Quando isso será executado?");
                ^
```

* O código após o return não será nunca executado. Esse código não compila. Vamos ver alguns outros exemplos:

```java
class Teste {
    public int metodo(int x) {
        if(x > 200) {
            return 5;
        }
    }
}
```

* Este também não compila. O que será retornado se x for <= 200?

```java
Teste.java:12: missing return statement
    }
        ^
1 error
```

* Vamos modificar o código para que ele compile:

```java
class Teste {
    public int metodo(int x) {
        if(x > 200) {
            return 5;
        }
        throw new RuntimeException();
    }
}
```

* Apesar de não estarmos retornando nada caso o if seja falso, o Java percebe que nesse caso uma exceção será disparada. A regra é: todos os caminhos possíveis devem retornar o tipo indicado pelo método, ou lançar exceção.

* Em um if, essa expressão compila normalmente:

```java
    if(false) {.... } //compila, apesar de ser unreachable code
```

* São pequenos detalhes, tome cuidado para não cair nessas pegadinhas.