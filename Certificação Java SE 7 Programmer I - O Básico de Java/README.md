<h1>Aula 01 - Defina o escopo de variáveis</h1>

* Variável local - Declarada dentro de um método ou construtor.
    * Vai existir dentro do bloco em que ela foi criada (chaves)
    * últimas chaves que criaram aquela variável.
* Variável de Instancia, ou de Objeto, ou de Atributo ou Variável membro
    * Declarada dentro da classe
    * Pode ser acessada dentro do objeto
* Variáveis Estáticas
    * Variáveis de classe
    * Existe uma única para aquela classe
    * Se for criado 5 objetos diferentes com aquela classe, é apenas uma varíavel de instancia.
    * Compartilha a variável entre as instancias
    * Pode ser utilizada através da Classe ou Instancia
    * Podem ser acessadas através de qualquer escopo
* Métodos Estáticos
    * Podem acessar as variáveis estaticas


* Nomes de varíaveis
    * Não é possível ter um nome de variável com o mesmo nome no mesmo escopo.
    * Parametros do método tbm nao pode ser criadas outra variável com o mesmo nome
    * Não é possível ter uma variável estatica e uma variavel membro com o mesmo nome
    * É possível definir uma varíavel local e uma variável membro com o mesmo nome
    * Pode ter parametro com variavel instancia, parametro com variavel membro

* O que é shadowing?
    * Esconder a varíavel
    * Acessa a variável local
    * variável de instancia utiliza o this.
    * variavel de classe utiliza o Pessoa.

* Duas variáveis com o mesmo nome -> ERRADO
* Variável membro e variável de instancia com o mesmo nome -> ERRADO
* Combinar uma variavel membro com uma variavel local -> CERTO
* Combinar uma variável estática com variável local -> CERTO

* O escopo é o que determina em que pontos do código uma variável pode ser usada.

* Variáveis locais
* Chamamos de locais as variáveis declaradas dentro de métodos ou construtores. Antes de continuar, vamos estabelecer uma regra básica: o ciclo de vida de uma variável local vai do ponto onde ela foi declarada até o fim do bloco onde ela foi declarada.

* Mas o que é um bloco? Podemos entender como bloco um trecho de código entre chaves. Pode ser um método, um construtor, o corpo de um if, de um for etc.:

```java
public void m1() { // início do bloco do método
    int x = 10; // variável local do método

    if (x >= 10) { // início do bloco do if
        int y = 50; // variável local do if
        System.out.print(y);

    } // fim do bloco do if

} // fim do bloco do método
```

* Analisando esse código, temos uma variável x, que é declarada no começo do método. Ela pode ser utilizada durante todo o corpo do método. Dentro do if, declaramos a variável y. y só pode ser utilizada dentro do corpo do if, delimitado pelas chaves. Se tentarmos usar y fora do corpo do if, teremos um erro de compilação, pois a variável saiu do seu escopo.

* Tome cuidado especial com loops for. As variáveis declaradas na área de inicialização do loop só podem ser usadas no corpo do loop:

```java
for (int i = 0, j = 0; i < 10; i++)
    j++;

System.out.println(j); // erro, já não está mais no escopo
```
* Parâmetros de métodos também podem ser considerados variáveis locais ao método, ou seja, só podem ser usados dentro do método onde foram declarados:

```java
    class Teste {

        public void m1(String bla) {
            System.out.print(bla);
        }

        public void m2() {
            // erro de compilação pois bla não existe neste
            // escopo
            System.out.println(bla);
        }
    }
```
* Variáveis de instância
* Variáveis de instância ou variáveis de objeto são os atributos dos objetos. São declaradas dentro da classe, mas fora de qualquer método ou construtor. Podem ser acessadas por qualquer membro da classe e ficam em escopo enquanto o objeto existir:

``` java
class Pessoa {
    // variável de instância ou variável de objeto
    String nome;

    public void setNome(String n) {
        // acessando a variável de instância no método
        this.nome = n;
    }
}
```
* Variáveis estáticas (class variables)
* Podemos declarar variáveis que são compartilhadas por todas as instâncias de uma classe usando a palavra chave static. Essas variáveis estão no escopo da classe, e lá ficarão enquanto a classe estiver carregada na memória (enquanto o programa estiver rodando, na grande maioria dos casos).

```java
class Pessoa {
    static int id = 1;
}

class Teste {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        System.out.println(p.id); // acessando pelo objeto
        System.out.println(Pessoa.id); // acessando direto pela
                                       // classe
    }
}
```
* No caso de variáveis static, não precisamos ter uma referência para usá-las e podemos acessá-las diretamente a partir da classe, desde que respeitando as regras de visibilidade da variável.

* Variáveis com o mesmo nome
* Logicamente, não é possível declarar duas variáveis no mesmo escopo com o mesmo nome:

```java
public void bla() {
    int a = 0;
    int a = 10;// erro
}
```
* Mas, eventualmente, podemos ter variáveis em escopos diferentes que podem ser declaradas com o mesmo nome. Em casos em que possa haver ambiguidade na hora de declará-las, o próprio compilador irá emitir um erro evitando a confusão. Por exemplo, não podemos declarar variáveis de classe e de instância com o mesmo nome:

```java
class Bla {
    static int a;
    int a; // erro de compilação,
}
...

System.out.println(new Bla().a); // qual variável estamos
                                 // acessando?
```
* Também não podemos declarar variáveis locais com o mesmo nome de parâmetros:

```java
public void metodo(String par) {
    int par = 0; // erro de compilação

    System.out.println(par); // qual?
}
```
* Apesar de parecer estranho, é permitido declarar variáveis locais ou parâmetros com o mesmo nome de variáveis de instância ou de classe. Essa técnica é chamada de ::shadowing::. Nesses casos, é possível resolver a ambiguidade: para variáveis de classe, podemos referenciar pela própria classe; para variáveis de instância, usamos a palavra chave this:

```java
class Pessoa {

    static int x = 0;
    int y = 0;

    public static void setX(int x) {
        // Usando a referência da classe
        Pessoa.x = x;
    }

    public void setY(int y) {
        // usando o this
        this.y = y;
    }
}
```
* Quando não usamos o this ou o nome da classe para usar a variável, o compilador sempre utilizará a variável de menor escopo:

```java
class X {
    int a = 10;

    public void metodo() {
        int a = 20; // shadowing
        System.out.println(a); // imprime 20
    }
}
```
<h2>Introdução</h2>

* Escolha a opção adequada ao tentar compilar e executar o código a seguir. Verifique se não está faltando nenhum ponto-e-vírgula, se os nomes das variáveis e métodos estão corretos, preste atenção a cada detalhe:
```java
class Teste{

  static int id = 1;

  public static void main(String[] args){
    System.out.println(id)
    id = id + 1;
  }
}
```
* R: Não compila. Falta um ponto-e-vírgula após a impressão, na linha 6.

* Isso é normal. Durante a prova, você precisará não apenas analisar o comportamento do código, também precisará se atentar as pequenas regras necessárias para que o código compile. Para facilitar, veja antes se existe alguma alternativa indicando que o código não compila, caso ela exista, verifique cada ponto-e-vírgula, visibilidade, escopo de variáveis, nomes e parâmetros de métodos, etc.

<h2>Exercício 1</h2>

* Escolha a opção adequada ao tentar compilar e rodar o código a seguir:
```java
class Teste {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }
        int i = 15;
        System.out.println(i);
    }
}
```
* R: A resposta correta é: Compila e roda, imprimindo de 0 até 19 e depois 15. Repare que a variável i declarada no for, só é visível dentro do for, por isso podemos declará-la novamente logo em seguida

<h2>Exercício 2</h2>

* Escolha a opção adequada ao tentar compilar e rodar o código a seguir:

```java
class Teste {
    static int x = 15;

    public static void main(String[] x) {
        x = 200;
        System.out.println(x);
    }
}
```
* A variável x declarada como parâmetro do método main efetua um shadowing. Nesse instante, ao dizermos x = 200, tentamos atribuir um int a um array de String, erro de compilação.

<h2>Exercício 3</h2>

* Escolha a opção adequada ao tentar compilar e rodar o código a seguir:
```java
class Teste {
    static int i = 3;
    public static void main(String[] a) {
        for (new Teste().i = 10; new Teste().i < 100;
             new Teste().i++) {
            System.out.println(i);
        }
    }
}
```

* R: Isso porque o acesso à variável estática pode ser feito através da instância da classe ou diretamente caso seja uma variável estática sendo acessada por um método estático.

<h1>Aula 02 - Defina a estrutura de uma classe java</h1>


