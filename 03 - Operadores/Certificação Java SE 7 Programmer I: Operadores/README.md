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