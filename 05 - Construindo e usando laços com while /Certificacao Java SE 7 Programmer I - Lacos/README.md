<h1>Crie e use laços do tipo while</h1>

* Outra maneira de controlar o fluxo de execução de um programa é definir que um determinado trecho de código deve executar várias vezes, como uma repetição ou um laço.

* Uma linguagem como o Java oferece alguns tipos de laços para o programador escolher. O comando while é um deles.

```java
int i = 1;
while (i < 10) {
    System.out.println(i);
    i++;
}
```

* A sintaxe do while é a seguinte:

```java
while (CONDICAO) {
    // CODIGO
}
```

* Assim como no if, a condição de um bloco while deve ser um booleano. Da mesma maneira, se o bloco de código tiver apenas uma linha, podemos omitir as chaves:

```java
int i = 0;
while( i < 10)
    System.out.println(i++);
```

* O corpo do while é executado repetidamente até que a condição se torne falsa. Em outras palavras, enquanto a condição for verdadeira.

* É necessário tomar cuidado para não escrever um while infinito, ou seja, um laço que não terminaria se fosse executado.

```java
int i = 1;
//Quando fica false?
while(i < 10){
    System.out.println(i);
}
```

* Em casos em que é explícito que o loop será infinito, o compilador é esperto e não deixa compilar caso tenha algum código após o laço:

```java
class A {
    int a() {
        while(true) { //nunca fica false
            System.out.println("Faz algo");
        }
        return 1; // não compila, nunca chegará aqui
    }
}
```

* Mesmo que a condição use uma variável, pode ocorrer um erro de compilação, caso a variável seja final:

```java
class A {
    int a() {
        final boolean RODANDO = true;
        while(RODANDO) {
            System.out.println("Faz algo");
        }
        return 1; // não compila, nunca chegará aqui
    }
}
```

* Agora, caso a variável não seja final, o compilador não tem como saber se o valor irá mudar ou não, por mais explícito que possa parecer, e o código compila normalmente:

```java
class A {
    int a() {
        boolean rodando = true; // não final
        while(rodando) {
            System.out.println("Faz algo");
        }
        return 1; 
        // compila, não tem como saber se o valor de rodando
        // vai mudar
    }
}
```

* Caso um laço nunca seja executado, também teremos um erro de compilação:

```java
    //unreachable statement, não compila.
    while(false) { //código aqui } 

    //unreachable statement, não compila.
    while(1 > 2) { //código aqui }
```

* Lembre-se que o compilador só consegue analisar operações com literais ou com constantes. No caso a seguir, o código compila, mesmo nunca sendo executado:

```java
int a = 1;
int b = 2;
while(a > b){ //compila, mas nunca executa
    System.out.println("OI");
}
```

<h1>Aula 02 - Crie e use laços do tipo for, incluindo o enhanced for</h1>

* Observando um pouco os códigos que utilizam while, dá para perceber que eles são formados por quatro partes: inicialização, condição, comandos e atualização.

```java
int i = 1; // Inicialização
while (i < 10) { // Condição
    System.out.println(i); // Comandos
    i++; // Atualização
}
```

* A inicialização é importante para que o laço execute adequadamente. Mesmo com essa importância, a inicialização fica separada do while.

* A atualização é fundamental para que não aconteça um "loop infinito". Porém, a sintaxe do while não a coloca em evidência.

* Há um outro laço que coloca em destaque a inicialização, a condição e a atualização. Esse laço é o for.

```java
for (int i = 1; i < 10; i++) {
    System.out.println(i);
}
```

* O for tem três argumentos separados por ;. O primeiro é a inicialização, o segundo, a condição, e o terceiro, a atualização.

* A inicialização é executada somente uma vez no começo do for. A condição é verificada no começo de cada rodada (iteração). A atualização é executada no fim de cada iteração.

* Todos os três argumentos do for são opcionais. Desta forma, você poderia escrever o seguinte código:

```java
for(;;){
    // CODIGO
}
```

* O que acontece com esse laço? Para responder essa pergunta é necessário saber quais são os "valores default" colocados nos argumentos do for, quando não é colocado nada pelo programador. A inicialização e a atualização ficam realmente vazias. Agora, a condição recebe por padrão o valor true. Então, o código anterior depois de compilado fica assim:

```java
//loop infinito
for (;true;){
    // CODIGO
}
```

* Nos exemplos anteriores, basicamente o que fizemos na inicialização foi declarar e inicializar apenas uma variável qualquer. Porém, é permitido declarar diversas variáveis de um mesmo tipo ou inicializar diversas variáveis.

* Na inicialização, não é permitido declarar variáveis de tipos diferentes. Mas é possível informar variáveis de nomes diferentes. Veja os exemplos:

```java
// Declarando três variáveis do tipo int e inicializando as três.
// Repare que o "," separa as declarações e inicializações.
for (int i = 1, j = 2, k = 3;;){
    // CODIGO
}

// Declarando três variáveis de tipos diferentes
int a;
double b;
boolean c;

// Inicializando as três variáveis já declaradas
for (a = 1, b = 2.0, c = true;;){
    // CODIGO
}
```

* Na atualização, é possível fazer diversas atribuições separadas por ,.

```java
//a cada volta do laço, incrementamos o i e decrementamos o j
for (int i=1,j=2;; i++,j--){
    //código
}
```

* Como já citamos anteriormente, não é possível, na inicialização, declarar variáveis de tipos diferentes:

```java
for (int i=1, long j=0; i< 10; i++){ // erro
    //código
}
```

* No campo de condição, podemos passar qualquer expressão que resulte em um boolean. São exatamente as mesmas regras do if e while.

* No campo de atualização, não podemos só usar os operadores de incremento, podemos executar qualquer trecho de código:

```java
    for (int i = 0; i < 10; i += 3) { //somatório
    //código
    }

    for (int i = 0; i < 10; System.out.println(i++)) { // bizarro
    //código
    }
```

* Enhanced for
* Quando vamos percorrer uma coleção de objetos ou um array, podemos usar uma versão simplificada do for para percorrer essa coleção de maneira simplificada. Essa forma simplificada é chamada de ::enhanced for::, ou ::foreach:: :

```java
int[] numeros = {1,2,3,4,5,6};
for (int num : numeros) { //enhanced for
    System.out.println(num);
}
```

* A sintaxe é mais simples, temos agora 2 partes dentro da declaração do for:

```java
for(VARIAVEL : COLEÇÃO){
    CODIGO
}
```

* Nesse caso, declaramos uma variável que irá receber cada um dos membros da coleção ou array que estamos percorrendo. O próprio for irá a cada iteração do laço atribuir o próximo elemento da lista à variável. Seria o equivalente a fazer o seguinte:

```java
int[] numeros = {1,2,3,4,5,6};

for( int i=0; i < numeros.length; i++){
    int num = numeros[i]; //declaração da variável e atribuição
    System.out.println(num);
}
```

* Se fosse uma ::collection::, o código fica mais simples ainda se comparado com o for original:

```java
ArrayList<String> nomes = //lista com vários nomes

//percorrendo a lista com o for simples
for(Iterator<String> iterator = nomes.iterator();
    iterator.hasNext();){
    String nome = iterator.next();
    System.out.println(nome);
}

//percorrendo com o enhanced for
for (String nome : nomes) {
    System.out.println(nome);
}
```

* Existem, porém, algumas limitações no ::enhanced for::. Não podemos, por exemplo, modificar o conteúdo da coleção que estamos percorrendo usando a variável que declaramos:

```java
ArrayList<String> nomes = //lista com vários nomes

//tentando remover nomes da lista
for (String nome : nomes) {
    nome = null;
}

//o que imprime abaixo?
for (String nome : nomes) {
    System.out.println(nome);
}
```

* Ao executar esse código, você perceberá que a coleção não foi modificada, nenhum elemento mudou de valor para null.

* Outra limitação é que não há uma maneira natural de saber em qual iteração estamos, já que não existe nenhum contador. Para saber em qual linha estamos, precisaríamos de um contador externo. Também não é possível percorrer duas coleções ao mesmo tempo, já que não há um contador centralizado. Para todos esses casos, é recomendado usar o for simples.

<h1>Aula 03 - Crie e uso laços do tipo do/while</h1>

* Uma outra opção de laço while seria o do .. while, que é bem parecido com o while. A grande diferença é que a condição é testada após o corpo do ::loop:: ser executado pelo menos uma vez:

```java
int i = 1;
do { //executa ao menos 1 vez
    System.out.println(i);
    i++;
} while (i < 10); // se der true, volta e executa novamente.
```

* A condição do do .. while só é verificada no final de cada iteração e não no começo, como no while. Repare que ao final do bloco do .. while existe um ponto e vírgula. Esse é um detalhe que passa desapercebido muitas vezes, mas que resulta em erro de compilação se omitido:

```java
int i = 1;
do {
    System.out.println(i);
    i++;
} while (i < 10) // não compila, faltou o ;
```

* Assim como no while, caso tenhamos apenas uma linha, as chaves podem ser omitidas. Caso exista mais de uma linha dentro do do .. while e não existam chaves, teremos um erro de compilação:

```java
int i = 0;
//compila normal
do
    System.out.println(i++);
while(i<10);

//erro, mais de uma linha dentro do do .. while
do
    System.out.print("o valor é: "); //erro
    System.out.println(i++);
while(i<10);
```