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

* Na prova será cobrado qual estrutura de um arquivo e de uma classe java.
* Primeira coisa que o arquivo pode ter é o pacote
* Cobra a estrutura de uma classe java
* Só pode ter um pacote.
* Depois vem os imports, mas a primeira coisa é o pacote. O pacote é opcional, mas sempre vem primeiro quando tem
* Depois vem classes e interfaces e enums, tanto faz a ordem
* Comentários entram em qualquer lugar
* PACOTE, IMPORTACAO;
* Quando nao importa o pacote, é pq ele esta no pacote padrao (package default). Diretório raiz.
* Dentro das classes pode haver variáveis (atributos), podem haver construtores.
* Possível ter nome de atributos, classe, construtor e método com o mesmo nome
* Arquivo Java pode ter várias classes, varias interfaces varias enums dentro dele.
* Se houver classes, interfaces, enums. Apenas um pode ser público. Se esse cara é publico ele tem que ter o mesmo nome que o arquivo. Pq? Para ficar fácil de achar ele.
* Variável estática ou variável de classe.
* Construtor retorna uma instancia da classe, mas ele nao possui um retorno específico, nao pode ter um tipo para ele retornar.
* Varíaveis final nao podem ter o seu valor ou sua referência alterada.
* Variáveis dentro de uma interface é estatica e publica e final;
* Métodos dentro de uma interface é publico e abstrato mesmo que nao coloque

* Um arquivo java, vários tipos - OK
* Um arquivo java, um único público - OK
* Um arquivo java, vários públic - ERRADO
* Um arquivo java, público com nome do arquivo - OK
* Um arquivo java, público nome diferente - ERRADO

* Nesta seção, iremos entender a estrutura de um arquivo java, onde inserir as declarações de pacotes e imports e como declarar classes e interfaces.

* Para entender a estrutura de uma classe, vamos ver o arquivo Pessoa.java:

```java
// Declaração de pacote
package br.com.caelum.certificacao;

// imports
import java.util.Date;

// Declaração da classe
class Pessoa {
    // conteúdo da classe
}
```
* Pacotes
    * Pacotes servem para separar e organizar as diversas classes que temos em nossos sistemas. Todas as classes pertencem a um pacote, sendo que, caso o pacote não seja explicitamente declarado, a classe fará parte do que chamamos de pacote padrão, ou default package. Todas as classes no default package se enxergam e podem ser utilizadas entre si. Classes no pacote default não podem ser importadas para uso em outros pacotes:

```java
// Uma classe no pacote padrão
class Pessoa {
    //...
}
```

* Para definir qual o pacote a que a classe pertence, usamos a palavra-chave package, seguida do nome do pacote. Só pode existir um único package definido por arquivo, e ele deve ser a primeira instrução do arquivo. Após a definição do package, devemos finalizar a instrução com um ;. Podem existir comentários antes da definição de um pacote:

```java
// declaração do pacote
package br.com.caelum.certificacao;

class Pessoa {
    //...
}
```
* Aproveitando que tocamos no assunto, o package deve ser a primeira instrução de código que temos declarada em nosso arquivo. Comentários não são considerados parte do código, portanto, podem existir em qualquer lugar do arquivo java sem restrições.

* Para inserir comentário em nosso código, temos as seguintes formas:

```java
// comentário de linha

/*
   comentário de
   multiplas linhas
 */
class /* comentário no meio da linha */ Pessoa {

    /**
     *  JavaDoc, repare que a primeira linha do comentário tem
     *  2 asteriscos
     */
    public void metodo() {
    }
}
```
* Para saber mais: JavaDoc
* Classe
    * Uma classe é a forma no Java onde definimos os atributos e comportamentos de um objeto. A declaração de uma classe pode ser bem simples, apenas a palavra class seguida do nome e de {}:

```java
class Pessoa {}
```

* Existem outros modificadores que podem ser usados na definição de uma classe, mas veremos essas outras opções mais à frente, onde discutiremos esses modificadores com mais detalhes.

* Vale lembrar que java é case sensitive e Class é o nome de uma classe e não podemos usá-lo para definir uma nova classe.

* Dentro de uma classe, podemos ter variáveis, métodos e construtores. Essas estruturas são chamadas de membros da classe.:


```java
class Pessoa {

    String nome;
    String sobrenome;

    Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return this.nome + this.sobrenome;
    }
}
```
* Nomes dos membros
* Variaveis
    * Usando como exemplo a classe Pessoa definida anteriormente, nome e sobrenome são variáveis. A declaração de variáveis é bem simples, sempre o tipo seguido do nome da variável.

* Dizemos que essas são variáveis de instância, pois existe uma cópia delas para cada objeto Pessoa criado em nosso programa. Cada cópia guarda o estado de uma certa instância desses objetos.

* Existem ainda variáveis que não guardam valores ou referências para uma determinada instância, mas sim um valor compartilhado por todas as instâncias de objetos. Essas são variáveis estáticas, definidas com a palavra-chave static. Veremos mais sobre esse tipo de membro mais à frente.

* Métodos
    * A declaração de métodos é um pouquinho diferente pois precisamos do tipo do retorno, seguido do nome do método e seguido de parênteses, sendo que pode ou não haver parâmetros de entrada desse método. Cada parâmetro é uma declaração de variável em si. Essa linha do método, onde está definido o retorno, o nome e os parâmetros é onde temos a assinatura do método. Cuidado, pois a assinatura de um método inclui somente o nome do método e os tipos dos parâmetros.

* Assim como variáveis, métodos também podem ser static, como veremos mais adiante.

* Construtores
    * Uma classe pode possuir zero ou vários construtores. Nossa classe Pessoa possui um construtor que recebe como parâmetros o nome e o sobrenome da pessoa. A principal diferença entre a declaração de um método e um construtor é que um construtor não tem retorno e possui o mesmo nome da classe.

* Métodos com o mesmo nome da classe
    * Note que um construtor pode ter um return vazio:

```java
class X {
    int j = -100;

    X(int i) {
        if (i > 1)
            return;
        j = i;
    }
}
```
* Caso o valor seja maior que 1, o valor de j será -100, caso contrário, será o mesmo valor de i.

* Interfaces
    * Além de classes, também podemos declarar interfaces em nossos arquivos java. Para definir uma interface usamos a palavra reservada interface:

```java 
interface Autenticavel {

    final int TAMANHO_SENHA = 8;

    void autentica(String login, String senha);
}
```
* Em uma interface, devemos apenas definir a assinatura do método, sem a sua implementação. Além da assinatura de métodos, também é possível declarar constantes em interfaces.

* Multíplas estruturas em um arquivo
    * Em java, é possível definir mais de uma classe/interface em um mesmo arquivo java, embora devamos seguir algumas regras:

* Podem ser definidos em qualquer ordem;
    * Se existir alguma classe/interface pública, o nome do arquivo deve ser o mesmo dessa classe/interface;
    * Só pode existir uma classe/interface pública por arquivo;
    * Se não houver nenhuma classe/interface pública, o arquivo pode ter qualquer nome.
* Logo, são válidos:

```java
// arquivo1.java
interface Bar {}

class Foo {}

// Foo.java
public class Foo {}

interface X {}
```
* Pacotes e imports em arquivos com múltiplas estruturas
    * As regras de pacotes e imports valem também para arquivos com múltiplas estruturas definidas. Caso exista a definição de um pacote, ela vale para todas as classes/interfaces definidas nesse arquivo, e o mesmo vale para imports.

<h2>Exercício 1</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir sem nenhum parâmetro na linha de comando, como java D:

```java
package a.b.c;

import java.util.*;

class D {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();

        for (String arg : args) {
            if (new E().existe(arg))
                lista.add(arg);
        }
    }
}

import java.io.*;

class E {
    public boolean existe(String nome) {
        File f = new File(nome);
        return f.exists();
    }
}
```

* R: O arquivo não compila pois não podemos ter um import após a definição de uma classe.

<h2>Exercício 2</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class Teste {
    int Teste = 305;

    void Teste() {
        System.out.println(Teste);
    }

    public static void main(String[] args) {
        new Teste();
    }
}
```

* R: O código compila e roda, não imprimindo nada, pois não chamamos o método Teste.

<h2>Exercicio 3</h2>

* Escolha a opção adequada ao tentar compilar o arquivo a seguir:

```java
package br.com.teste;

import java.util.ArrayList;
```

* R: O código compila sem erros: a ordem package e import está adequada, e os tipos são opcionais dentro de um arquivo java.

<h2>Exercício 4</h2>

* Escolha a opção adequada ao tentar compilar o arquivo A.java:

```java
class A implements B { //A
}
public interface B { //B
}
class C extends A { //C
}
class D extends A, implements B { //D
}
```
* R: Uma vez que o arquivo chama A.java, o único tipo público que pode existir dentro dele deve se chamar A, o que não é verdade: tentamos definir um tipo B público. Além disso, após o extends não podemos colocar uma ,.

<h1>Aula 03 - Crie aplicações Java executáveis com um método main</h1>

* Qual a diferença entre uma classe normal e uma classe que pode ser executada pela linha de comando.
* Toda classe chamada na linha de comando deve possuir o método main.
* As classes que possuem o método main possuem sua privacidade como public
* O main precisa ser público
* O método precisa ser estático
* O main tem que devolver void
* O main tem que receber um array [] ou var args (...)
* O main da varíavel args nao precisa necessárimanete ser args, pode ser outro nome, pois nao influencia na chamada do método
