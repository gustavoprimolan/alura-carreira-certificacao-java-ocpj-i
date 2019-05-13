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