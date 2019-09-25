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

<h1>Aula 04 - Compare os tipos de laços</h1>

* Embora o for, while e do .. while sejam todos estruturas que permitam executar ::loops::, existem similaridades e diferenças entre essas construções que serão cobradas na prova.

* Comparando while e do .. while
* No caso do while e do while, ambos são muito similares, sendo a principal diferença o fato do do .. while ter a condição testada somente após executar o código de dentro do ::loop:: pelo menos uma vez.

```java
int i = 20;

//imprime 20, já que só faz o teste após a execução do código
do {
    System.out.println(i);
    i++;
} while(i < 10);

int j = 20;

//não imprime nada, já que testa antes de executar o bloco
while(j < 10){
    System.out.println(i);
    i++;
}
```

* Comparando for e enhanced for
* Apesar de ser mais complexo, o for simples é mais poderoso que o enhanced for. Com o enhanced for, não podemos:

* Percorrer mais de uma coleção ao mesmo tempo;
* Remover os elementos da coleção;
* Inicializar um array.
* Caso desejemos fazer uma iteração de leitura, por todos os elementos da coleção, aí sim o enhanced for é a melhor opção.

* Comparando while e for
* Ambas estruturas de laço permitem executar as mesmas operações em nosso código, e são bem similares. Mas, apesar disso, existem situações em que o código ficará mais simples caso optemos por uma delas.

* Geralmente optamos por usar for quando sabemos a quantidade de vezes que queremos que o laço seja executado. Pode ser percorrer todos os elementos de uma coleção, (onde sabemos a quantidade de vezes que o loop será executado por saber o tamanho da coleção) ou simplesmente executar o laço uma quantidade fixa de vezes.

* Usamos o while ou do .. while quando não sabemos a quantidade de vezes em que o laço será executado, mas sabemos uma condição que, enquanto for verdadeira, fará com que o laço seja repetido.

* O exemplo a seguir mostra um código no qual conhecemos a condição de parada, mas não faz sentido nenhum ter uma variável inicializada ou uma condição de incremento, então escolhemos um while:

```java
    while(conta.getSaldo() > 0) {
        conta.saca(1000);
    }
```

* Note que, caso queira contar quantas vezes foi sacado, faria sentido usar um for:

```java
    int saques;
    for(saques = 0; conta.getSaldo() > 0; saques++) {
        conta.saca(1000);
    }
    System.out.println("Saquei " + saques + " vezes");
```

<h1>Aula 05 - Use break e continue</h1>

* Em qualquer estrutura de laço podemos aplicar os controladores break e continue. O break serve para parar o laço totalmente. Já o continue interrompe apenas a iteração atual. Vamos ver alguns exemplos:

```java
int i = 1;
while (i < 10) {
    i++;
    if (i == 5)
        break; // sai do while com i valendo 5
    System.out.println(i);
}
System.out.println("Fim");
```

* Ao executar o break, a execução do while para completamente. Temos a seguinte saída:

* 2
* 3
* 4
* Fim
* Vamos comparar com o continue:

```java
int i = 1;
while (i < 10) {
    i++;
    if (i == 5)
        continue; // vai para a condição com o i valendo 5
    System.out.println(i);
}
```

* Neste caso, iremos parar a execução da iteração apenas quando o valor da variável for igual a 5. Ao encontrar um continue, o código volta ao início da iteração, ao ponto do loop. Nossa saída agora é a seguinte:


    * 2
    * 3
    * 4
    * 6
    * 7
    * 8
    * 9
    * 10

* Fim

* Isto é, o break quebra o laço atual, enquanto o continue vai para a próxima iteração do laço.

* Tome cuidado, pois um laço que tenha um while infinito do tipo true e que contenha um ::break:: é compilável, já que o compilador não sabe se o código poderá parar, possivelmente sim:

```java
while(true) {
    if(1==2) break;
    System.out.println("em loop infinito compilável");
}
```

* Os controladores de laços, break e continue podem ser aplicados no for. O break se comporta da mesma maneira que no while e no do .. while, parar o laço por completo. Já o continue faz com que a iteração atual seja abortada, executando em seguida a parte de ::atualização:: do for, e em seguida a de ::condição::. Vamos ver o exemplo a seguir:

```java
for (int i = 1; i < 10; i++) {
    if (i == 8) {
        break; // sai do for sem executar mais nada do laço.
    }
    if (i == 5) {
        // pula para a atualização sem executar o resto do corpo.
        continue; 
    }
    System.out.println(i);
}
```

* A saída desse código é :

    * 1
    * 2
    * 3
    * 4 
    * 6
    * 7

* Rótulos em laços (labeled loops)

* Às vezes, encontramos a necessidade de "encaixar" um laço dentro de outro. Por exemplo, um for dentro de um while ou de outro for. Nesses casos, pode ser preciso manipular melhor a execução dos laços encaixados com os controladores de laços, break e continue.

```java
for (int i = 1; i < 10; i++) { //laço externo
    for (int j = 1; j < 10; j++) { // laço interno
        if (i * j == 25)    {
            break; // qual for será quebrado?
        }
    }
}
```

* Quando utilizamos o break ou o continue em laços encaixados, eles são aplicados no laço mais próximo. Por exemplo, nesse código, o break irá "quebrar" o for mais interno. Se fosse preciso "quebrar" o for mais externo, como faríamos?

* Labeled statements
* Podemos adicionar ::labels:: (rótulos) a algumas estruturas de código, e usá-los posteriormente para referenciarmos essas estruturas. Para declarar um label usamos um nome qualquer (mesma regra de nomes de variáveis etc.) seguido de dois pontos (:). Por exemplo, podemos dar um label para um for como o que segue:

* externo: //label

```java
for(int i=0; i<10;i++){
    //código
}
```

* Podemos usar esses ::labels:: para referenciar para qual loop queremos que o break ou o continue seja executado:

```java
externo: for (int i = 1; i < 10; i++) {
  interno: for (int j = 1; j < 10; j++) {
    if (i * j == 25)    {
        break externo; // quebrando o for externo
    }
    if (i * j == 16) {
        continue interno; // pulando um iteração do for interno
    }
  }
}
```

* Label http
* O código a seguir imprime os valores de 1 a 10. Mas como ele compila sendo que temos uma URI logo antes do laço for?

```java
http://www.caelum.com.br
    for (int i = 1; i <= 10; i++) {
        System.out.println(i);
    }
}
```

* Um rótulo ou label pode estar presente antes de um ::statement:: qualquer, mas só podemos utilizar um ::statement:: de break ou continue caso o rótulo esteja referenciando um for, while ou switch:

```java
void rotuloEmQualquerLugar() {
    rotulo: System.out.println("oi");
}

void rotuloEmQualquerLugarComBreakNaoCompila() {
    rotulo: System.out.println("oi");
    if(1<10) continue rotulo; // erro de compilação
}
```

* Cuidado, mesmo dentro de um for ou similar, o continue e o break só funcionarão se forem relativos a um label dentro do qual estão, e do tipo for, do...while, switch ou while. Vale lembrar que switch só aceita break.

```java
    void rotuloEmQualquerLugarComBreakNaoCompila() {
        rotulo: System.out.println("oi");
        for(int i=0;i<10;i++) {
            break rotulo; // não compila
        }
    }
    void rotuloEmOutroLaco() {
        rotulo:
        for(int i=0;i<10;i++) {
            System.out.println("oi");
        }
        for(int i=0;i<10;i++) {
            break rotulo; // não compila
        }
    }
```

* Rótulos podem ser repetidos desde que não exista conflito de escopo:

```java
    void rotulosRepetidos() {
        rotulo: for (int i = 0; i < 10; i++) {
            break rotulo;
        }
        rotulo: for (int i = 0; i < 10; i++) {
            break rotulo;
        }
    }
    void rotulosRepetidosNestedNaoCompila() {
        rotulo: for (int i = 0; i < 10; i++) {
            rotulo: for (int j = 0; j < 10; j++) {
                break rotulo;
            }
        }
    }
```

* Não há conflito de nome entre rótulos e variáveis, pois seu uso é bem distinto. O compilador sabe se você está referenciando um rótulo ou uma variável:

```java
class A {
    int rotulo = 15;
    void rotulosENomesDeVariaveisNaoConflitam() {
        rotulo: for (int i = 0; i < 10; i++) {
            int rotulo = 10;
            break rotulo;
        }
    }
}
```

* Um mesmo statement pode ter dois labels:

```java
    void rotulosNoMesmoStatement() {
        primeiro: segundo: for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
```

* Tome bastante cuidado com breaks e continues que são de switch mas parecem ser de fors:

```java
class TestaLacos {
    public static void main(String[] args) {

        for(int i = 0; i < 4; i++) {
            System.out.println("Estou antes do switch");
            mario:
            guilherme: switch(i) {
                case 0:
                case 1:
                    System.out.println("Caso " + i);
                    for(int j = 0; j < 3; j++) {
                        System.out.println(j);
                        if(j==1) break mario;
                    }
                case 2:
                    System.out.println("Estou em i = " + i);
                    continue;
                case 3:
                    System.out.println("Cheguei no 3");
                    break;
                default:
                    System.out.println("Estranho...");
                    break;
            } 
            System.out.println("Estou apos o switch");
        }
    }
}
```