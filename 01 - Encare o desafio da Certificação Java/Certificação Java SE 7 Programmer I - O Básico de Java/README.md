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
* O main da varíavel args nao precisa necessárimanete ser args, pode ser outro nome, pois nao influencia na chamada do método, desde que seja um array the String.
* Compilador -> javac -> Da própria oracle que vem com o jdk -> Java Development Kit
* Se eu quero apenas executar eu preciso baixar a jre.
* Mesmo utilizando um compilador mais recente se voce passar o parametro javac -source 1.3 voce passará qual versão do compilador gostaria que ele compilasse (no caso é o 1.3).
* Quando a classe faz parte de um pacote, por exemplo certificacao. Para executá-la o comando é: java certificacao.Teste. Esse é o nome inteiro da minha classe.
* O nome de uma classe inclui o pacote dela tbm.
* Passando propriedades na linha de comando
    * java -Dsistema=producao -Dproduto=certificacao certificacao.Teste
    * Toda propriedade passada segue com -D
* Como o java sabe onde procurar as minhas classes?
    * Existe uma variável chamada CLASSPATH
    * Define onde ele vai procurar as classes e pacotes.
    * Por padrão o CLASSPATH é somente o diretório atual.
    * CLASSPATH=.
    * Posso mudar isso com vaŕiaveis de ambiente
    * CLASSPATH=.:usr/libraries/arquivo.jar -> no linux separa com :, no windows com ;
    * jars são somente arquivos .zip.
    * É possível setar a variável de ambiente CLASSPATH, mas não é uma boa prática.
    * Toda aplicação Java vai utilizar esse CLASSPATH.
    * É mais interessante na hora de rodar o programa é possível utilizar o seguinte comando para o CLASSPATH (cp).
        * java -classpath . certificacao.Teste
        * java -cp . certificacao.Teste
        * Ele vai procurar as classes dentro do diretório que você passar
        * java -cp certificacao certificacao.Teste

* Existem duas maneiras de se mudar o CLASSPATH
    * Variável global de ambiente.
    * Passando como parametro -cp

* Se não passar -cp, -classpath?
    * usa o CLASSPATH

* Se não existe CLASSPATH?
    * Usa o diretório atual.

* javac para compilar, java para rodar.

* Nesta seção, entenderemos as diferenças entre classes normais e classes que podem ser executadas pela linha de comando.

* Uma classe executável é uma classe que possui um método inicial para a execução do programa - o método main, que será chamado pela JVM. Classes sem o método main não são classes executáveis e não podem ser usadas como ponto inicial da aplicação.

* Método main
    * O tal método de entrada deve seguir algumas regras para ser executado pela JVM:

* Ser público (public);
* Ser estático (static);
* Não ter retorno (void);
* Ter o nome main;
* Receber como parâmetro um array ou varargs de String (String[] ou String...).
* São então métodos main válidos os seguintes exemplos:

```java
//Parâmetro como array
public static void main (String[] args) {}

//Parâmetro como varargs
public static void main (String... args) {}

//A ordem dos modificadores não importa
static public void main(String[] args) {}

//O nome do parâmetro não importa
public static void main (String... argumentos){}

//Também é uma definição válida de array
public static void main (String args[]) {}
```

* Executando uma classe pela linha de comando
* Para executar uma classe com main pela linha de comando, devemos compilar o arquivo com o comando javac e executar a classe com o comando java:

* Usando o arquivo HelloWorld.java a seguir:

```java
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World! ");
    }
}
```
* Compilamos e executamos no terminal com os seguintes comandos:


* $ javac HelloWorld.java
* $
* $ java HelloWorld
* Hello World!
* Repare que, para compilar a classe, passamos como parâmetro para o comando javac o nome do arquivo, enquanto para executar, passamos apenas o nome da classe (HelloWorld) para o comando java.

* Passando parâmetros pela linha de comando
    * Ao executarmos uma classe pela linha de comando, podemos passar parâmetros para o método main. Esses valores serão recebidos no array do método main. Por exemplo, vamos passar um nome para a classe HelloWorld:

```java
public class HelloWorld{

    public static void main(String[] args) {
        //Lendo o valor da primeira posição do array args
        System.out.println("Hello " + args[0] + "!");
    }
}
```
* Para informar o valor do parâmetro, é só informá-lo APÓS o nome da classe que está sendo executada:


* java HelloWorld Mario
* Hello Mario!
* Você pode passar quantos parâmetros quiser, basta separá-los por espaço. Cada parâmetro informado será armazenado em uma posição do array, na mesma ordem em que foi informado.

* Compilação e execução
* Para criar um programa java, é preciso escrever um código-fonte e, através de um compilador, gerar o executável (bytecode). O compilador do JDK (Java Development Kit) é o javac. Para a prova de certificação, devemos conhecer o comportamento desse compilador.

* A execução do bytecode é feita pela JVM (Java Virtual Machine). O comando java invoca a máquina virtual para executar um programa java. Ao baixarmos o Java, podemos escolher baixar o JDK, que já vem com o JRE, ou somente o JRE (Java Runtime Environment), que inclui a Virtual Machine.

* Algumas questões da prova abordam aspectos fundamentais do processo de compilação e de execução. É necessário saber como os comandos javac e o java procuram os arquivos.

* javac
* Imagine o arquivo Prova.java dentro do diretório de meu projeto:

```java
class Prova {
    double tempo;
}
```
* $ javac Prova.java
* O bytecode da classe Prova gerado na compilação é colocado no arquivo Prova.class dentro do nosso diretório de trabalho, no meu caso, projeto. O resultado é:

* Os projetos profissionais utilizam o recurso de pacotes para melhor organizar os fontes e os bytecodes. Vejamos qual é o comportamento do javac com a utilização de pacotes. Colocamos o arquivo Prova.java no diretório certificacao:

```java
package certificacao;
class Prova {
    double tempo;
}
```
* [certificacao]$ javac certificacao/Prova.java
* Nesse exemplo, o arquivo Prova.class é colocado no diretório certificacao.

* Escolhendo a versão do Java na hora de compilar
* Na hora da compilação, é possível definir em que versão do Java o código-fonte foi escrito. Isso é feito com a opção -source do comando javac. (javac MinhaClasse.java -source 1.3).

* java
* Vamos utilizar um exemplo para mostrar o funcionamento do comando java, criando o arquivo Teste.java no mesmo diretório, no mesmo pacote:
```java
package certificacao;
class Teste {
    public static void main(String[] args) {
        Prova p = new Prova();
        p.tempo = 210;
        System.out.println(p.tempo);
    }
}
```
* $ javac certificacao/Teste.java
* $ java certificacao.Teste
* Saída:
* 210.0
* E o resultado são os arquivos:
* Somente o arquivo Teste.java foi passado para o compilador. Nesse arquivo, a classe Teste utiliza a classe Prova que se encontra em outro arquivo, Prova.java. Dessa forma, o compilador vai compilar automaticamente o arquivo Prova.java se necessário.

* Para executar, é preciso passar o nome completo da classe desejada para a máquina virtual. O sufixo .class não faz parte do nome da classe, então ele não aparece na invocação da máquina virtual pelo comando java.

* Propriedades na linha de comando
    * A prova ainda cobra conhecimentos sobre como executar um programa java passando parâmetros ou propriedades para a JVM e essas propriedades são identificadas pelo -D antes delas. Este -D não faz parte da chave.


    * java -Dchave1=abc -Dchave2=def Foo xpto bar
    * chave1=abc e chave2=def são parâmetros/propriedades e xpto e bar são argumentos recebidos pelo método main.

* Classpath
    * Para compilar ou para executar, é necessário que os comandos javac e java possam encontrar as classes referenciadas pela aplicação java.

    * A prova de certificação exige o conhecimento do algoritmo de busca das classes. As classes feitas pelo programador são encontradas através do classpath (caminho das classes).

* O classpath é formado por diretórios, jars e zips que contenham as classes e pacotes da nossa aplicação. Por padrão, o classpath está configurado para o diretório corrente (.).

* Configurando o classpath
* Há duas maneiras de configurar o classpath:

* 1) Configurando a variável de ambiente CLASSPATH no sistema operacional.

* Basta seguir as opções do SO em questão e definir a variável. Isso é considerado uma má prática no dia a dia porque é um classpath global, que vai valer para qualquer programa java executado na máquina.

* 2) Com as opções -cp ou -classpath dos comandos javac ou java.

* É a forma mais usada. Imagine que queremos usar alguma biblioteca junto com nosso programa:


* $ javac -cp /diretorio/biblioteca.jar Prova.java
* $ java -cp /diretorio/biblioteca.jar Prova
* E podemos passar tanto caminhos de outras pastas como de JARs ou zips. Para passar mais de uma coisa no classpath, usamos o separador de parâmetros no SO (no Windows é ponto e vírgula, no Linux/Mac/Solaris/Unix são dois pontos):


* $ javac -cp /diretorio/biblioteca.jar;/outrodir/ scjp/Prova.java
* $ java -cp /diretorio/biblioteca.jar;/outrodir/ scjp.Prova
* Para saber mais: arquivos JAR
* Para facilitar a distribuição de bibliotecas de classes ou de aplicativos, o JDK disponibiliza * uma ferramenta para a compactação das classes java.

* Um arquivo JAR nada mais é que a pasta de nossas classes no formato ZIP mas com extensão .jar.

* Para criar um jar incluindo a pasta scjp que fizemos antes:

* jar -cf bib.jar scjp
* Agora podemos executar nossa classe usando esse jar:

* java -cp bib.jar scjp.Prova
* Para saber mais: META-INF/Manifest.mf
* Ao criar o jar usando o comando jar do JDK, ele cria automaticamente a pasta META-INF, que é usada para configurações relativas ao nosso jar. E dentro dela, cria o arquivo Manifest.mf.

* Esse arquivo pode ser usado para algumas configurações. Por exemplo, é possível dizer qual classe do nosso jar é a classe principal (Main-Class) e que deve ser executada.

* Basta criar um arquivo chamado Manifest.mf com a seguinte instrução indicando a classe com o método main:

* Main-Class: scjp.Teste
* E depois gerar o jar passando esse arquivo:

* jar -cmf bib.jar meumanifest scjp
* Na hora de rodar um jar com Main-Class, basta usar:

* java -jar bib.jar

<h2>Exercício 1</h2>

* Qual é uma assinatura válida do método main para executar um programa java?

* R: O método main não pode devolver int nem Void. Ele também deve ser público e só receber um argumento: um array (ou varargs) de String. Portanto:

* public static void main(String... args)

<h2>Exercício 2</h2>

* Escolha a opção adequada para compilar e rodar o arquivo A.java, existente no diretório b:
```java
package b;
class A {
    public static void main(String[] args) {
        System.out.println("rodando");
    }
}
```

* R: Para compilar, estamos trabalhando com arquivos e diretórios, portanto javac b/A.java; enquanto, para rodar, estamos pensando em pacotes e classes: java b.A.

<h2>Exercicio 3</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        System.out.println(args);
        System.out.println(args.length);
        System.out.println(args[0]);
    }
}
```

* Ao rodar sem argumentos, nosso array tem tamanho zero, portanto, ao tentar acessar seu primeiro elemento recebemos um ArrayIndexOutOfBoundsException na linha 5.

<h2>Exercicio 4</h2>

* Escolha a opção adequada para rodar a classe A.java presente no diretório b, que foi compactado em um arquivo chamado programa.jar, sendo que não existe nenhum arquivo de manifesto:

```java
package b;
class A {
    public static void main(String[] args) {
        System.out.println(args[0]);
    }
}
```

* R: Para rodar um programa dentro de um jar sem ter um manifesto, devemos usar o classpath customizado. Colocamos o jar no classpath e dizemos qual classe desejamos rodar: java -cp programa.jar b.A.

<h2>Exercício 5</h2>

* Escolha a opção adequada para compilar a classe A.java, definida como no pacote b presente no diretório b, e adicionar também o arquivo programa.jar na busca de classes durante a compilação. Lembre-se que . significa o diretório atual.

* R: Durante a compilação, para adicionar o arquivo programa.jar ao classpath, devemos usar -cp programa.jar e, para especificar o arquivo adequado, usamos b/A.java. A opção que apresenta essas duas características é javac -cp programa.jar:. b/A.java.


<h1>Aula 04 - Importe outros pacotes Java e deixe-os acessíveis ao seu código</h1>

* Quando duas classes estão em um mesmo pacote, não necessita importação de pacote para a referencia de uma classe dentro da outra.
* O import é opcional, não da erro caso importe.
* java modelo/*.java  //COMPILA TUDO
* Uma classe que não tem modificador de acesso só pode ser acessado dentro do mesmo pacote da classe.
* Se não estiver no mesmo pacote a classe devera ser pública.
* Para poder acessar a classe de outro pacote ela precisa ser pública.

* Como usar duas classes diferentes com o mesmo nome e em pacotes distintos?
    * Não é possível importar duas classes com o mesmo nome.

* Dois importes com o mesmo nome específico não compila.
* Um import com asterisco e um nome específico, estamos utilizando o nome específico.
* Se eu tenho um import e quiser usar uma classe de outro pacote com o mesmo nome precisa usar o fullyqualified name.

* E as classes no pacote padrão (default package)?
    * Você nunca pode acessar uma classe do pacote default.

* Convensão de pacotes
    * Tudo minusculo
    * Começa com o nome da sua empresa ao contrario

* Quando voce importa com o asterisco voce esta importando os tipos (classes, interfaces e enums), não pacotes.
* Não existe importar os "subpacotes".

* Import static
    * Sempre vem primeiro a palavra import, depois static. (Pegadinha)

* Se duas classes estão no mesmo pacote, elas se "enxergam" entre si, sem a necessidade de colocar o nome do pacote. Por exemplo, imagine que as classes Pessoa e Endereco estejam no mesmo pacote:

```java
package modelo;

class Endereco {
    String rua;
    String numero;
    String bairro;
    //...
}
```

* E o outro arquivo:

```java
package modelo;

class Pessoa {
    Endereco endereco; // Pessoa usando o endereço
}
```

* Para usar uma classe que está em outro pacote, temos duas opções: podemos referenciá-la usando o que chamamos de Fully Qualified Name, ou seja, o nome do pacote seguido do nome da classe. O código ficaria assim:

```java
package financeiro;

class Pedido {
    modelo.Pessoa cliente; // Usando a classe Pessoa de outro
                           // pacote
}
```

* Tentamos compilar mas ele não deixa, porque uma classe, por padrão, só pode ser acessada dentro do próprio pacote, e a nossa classe Pessoa está no pacote modelo. Portanto, definiremos nossa classe Pessoa como pública. Veremos com mais calma os modificadores de acesso na seção que cobra isso na prova. Por enquanto, basta lembrar que classes públicas podem ser acessadas por outros pacotes, já classes padrão não podem.

```java
package modelo;

public class Pessoa {
    Endereco endereco // Pessoa usando o endereço
}
```
* Outra opção é importar a classe Produto e referenciá-la apenas pelo nome simples dentro de nosso código. Para fazer o import usamos a palavra import, seguida do Fully Qualified Name da classe. A instrução de import deve aparecer na classe logo após o package (se este existir), e antes da definição da classe. É possível importar mais de uma classe por vez:

```java
package modelo;

// Importando a classe Produto do pacote estoque
import estoque.Produto;
// Outro import qualquer
import java.util.Date;

class Pedido {
    Pessoa cliente; // mesmo pacote
    Produto item; // importado
    Date dataEmissao; //importado
}
```

* Também é possível importar todas as classes de um determinado pacote, basta usar um * após o nome do pacote:

```java
// Importando todas as classes do pacote estoque
import estoque.*;
```

* Importando classes com mesmo nome
    * Quando precisamos usar duas classes com o mesmo nome mas de pacotes diferentes, só podemos importar uma delas. A outra deve ser referenciada pelo Fully Qualified Name. Tentativas de importar as duas classes irão resultar em erros de compilação:

```java
import java.util.Date;
import java.sql.Date; // Erro de compilação pois temos duas
                      // classes Date

class Teste {
    Date d1;
    Date d2;
}
```

* O correto seria:

```java
import java.util.Date;

class Teste {
    Date d1;            // java.util
    java.sql.Date d2; // java.sql
}
```
* Caso tenhamos um import específico e um import genérico, o Java usa o específico:

```java
import java.util.*;
import java.sql.Date;

class Teste{
    Date d1; // java.sql
    Date d2; // java.sql
}
```
* Por padrão, todas as classes do pacote java.lang são importadas. Um ponto importante é que nenhuma classe de pacote que não seja o padrão pode importar uma classe do pacote padrão:

```java
class Gerente {
}

package modelo;
classe Banco {
    Gerente gerente; // não compila pois não é possível importar
                     // tipos do pacote padrão de jeito *nenhum*
}
```
* Pacotes
    * Nesta seção, entenderemos mais a fundo como funciona a declaração de pacotes, e como isso influencia nos imports das classes.

    * Como já discutimos anteriormente, pacotes servem para organizar suas classes e interfaces. Eles permitem agrupar componentes que tenham alguma relação entre si, além de garantir algum nível de controle de acesso a membros. Além de serem uma divisão lógica para as suas classes, os pacotes também definem uma separação física entre os arquivos de seu projeto, já que espelham a estrutura de diretórios dos arquivos do projeto.

* Subpacotes e estrutura de diretórios
    * Pacotes são usados pela JVM como uma maneira de encontrar as classes no sistema de arquivos, logo a estrutura de diretórios do projeto deve ser a mesma da estrutura de pacotes. Vamos usar como exemplo a classe Pessoa:

```java
package projeto.modelo;

public class Pessoa {}
```
* O arquivo Pessoa.java deve estar localizado dentro do diretório modelo, que deve estar dentro do diretorio projeto, conforme a figura a seguir:


* Dizemos que modelo é um subpacote de projeto, já que está dentro dele. Podemos ter vários subpacotes, como projeto.utils e projeto.conversores, por exemplo. Usamos o caractere . como separador de pacotes e subpacotes.

* Convenções de nomes para pacotes
    * Existem algumas convenções para nomes de pacotes. Elas não são obrigatórias, mas geralmente são seguidas para facilitar o entendimento e organização do código:
    * O nome do pacote deve ser todo em letras minúsculas;
    * Um pacote deve começar com o site da empresa, ao contrário;
    * Após o site, deve vir o projeto;
    * Após o projeto, a estrutura é livre.
    * Import usando classes de outros pacotes

* Existem diversas maneiras de referenciar uma classe de pacote diferente em nosso código. Vamos analisar essas opções:

* Fully Qualified Name
* Podemos referenciar uma classe em nosso código usando o que chamamos de Fully Qualified Name, ou FQN. Ele é composto pelo pacote completo mais o nome da classe, por exemplo:

```java
class Pessoa {
    // FQN da classe Calendar
    java.util.Calendar dataDeNascimento;
}
```
* import
    * Usar o FQN nem sempre deixa o código legível, portanto, em vez de usar o nome completo da classe, podemos importá-la e usar apenas o nome simples da classe:

```java
import java.util.Calendar;

class Pessoa {
    Calendar dataDeNascimento;
}
```

* É permitido também importar todas as classes de um pacote de uma vez, usando o * no lugar do nome da classe:

```java
import java.util.*;

class Pessoa {
    // Calendar e List são do pacote java.util
    Calendar dataDeNascimento;
    List<String> apelidos;
}
```

* Caso existam duas classes com o mesmo nome, mas de pacotes diferentes, só podemos importar uma delas. A outra deve ser referenciada pelo FQN:

```java
import java.util.Date;

class Foo {
    //do java.util
    Date some;
    java.sql.Date other;
}
]
```
* Multiplos imports com *
    * Caso importemos dois ou mais pacotes que contenham classes com o mesmo nome, será obrigatório especificar, usando o FQN, qual das classes queremos utilizar. Ao tentar usar apenas o nome simples da classe, teremos um erro de compilação:

```java
import java.util.*;
import java.sql.*;

public class Testes {
    private Date d; // Erro de compilação, de qual pacote é
                    // para usar?
}
```

* Import de subpacotes
    * Em Java, não podemos importar todas as classes de subpacotes usando *. Veja a seguinte situação, considerando que cada classe foi definida em seu próprio arquivo:

```java
package sistema.prova;

public class Pergunta {}

package sistema.banco;

public class PerguntaDao {}

package sistema;

public class Exame {}

package sistema.teste;

import sistema.*; //só importou a classe Exame

public class Teste {}
```
* O único modo de importar todas as classes é explicitamente importando cada subpacote:

```java
package sistema.teste;

import sistema.*;
import sistema.prova.*;
import sistema.banco.*;
public class Teste {}
```

* import static
    * Desde o Java 5, é possível importar apenas métodos e atributos estáticos de uma classe, usando a palavra-chave static juntamente com o import. Podemos importar um a um ou simplesmente importar todos usando *:

```java
package model;

public class Utils {

    // Atributo estático público
    public static int VALOR = 0;
    // Métodos estáticos públicos
    public static void metodo1() {}
    public static void metodo1(int a) {}

}

// Importando todos os membros public static de Utils
import static model.Utils.*;

public class Testes {

    public static void main(String[] args) {
        int x = VALOR;
        metodo1();
        metodo1(x);
    }
}
```

<h2>Exercicio 1</h2>

* Escolha a opção adequada ao tentar compilar e rodar o Teste. Arquivo no diretório atual:

```java
import modelo.Cliente;
class Teste {
    public static void main(String[] args) {
        new Cliente("guilherme").imprime();
    }
}
```
* Arquivo no diretório modelo:

```java
package modelo;

class Cliente {
    private String nome;
    Cliente(String nome) {
        this.nome = nome;
    }
    public void imprime() {
        System.out.println(nome);
    }
}
```

* R: Ocorre um erro de compilação na classe Teste ao tentar importar uma classe não acessível a outros pacotes.

<h2>Exercicio 2</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
import modelo.basico.Cliente;
import modelo.avancado.Cliente;

class Teste {
    public static void main(String[] args) {
        System.out.println("Bem vindo!");
    }
}
```

* R: O erro de ambiguidade é dado no import e não na utilização, portanto o arquivo não compila.

<h2>Exercicio 3</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir, sabendo que existem duas classes Cliente, uma no pacote basico e outra no pacote avancado:

```java
import modelo.basico.Cliente;
import modelo.avancado.*;

class Teste {
    public static void main(String[] args) {
        System.out.println("Bem vindo!");
    }
}
```

* R: Não existe ambiguidade uma vez que o import específico tem preferência em cima do *.

<h2>Exercicio 4</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
import modelo.basico.Cliente;
import modelo.basico.Cliente;

class Teste {
    public static void main(String[] args) {
        System.out.println("Bem vindo!");
    }
}
```

* R: Não há erro de ambiguidade, simplesmente um import é desnecessário e não gera erro nenhum, apenas um ::warning::.

<h2>Exercício 5</h2>

* Escolha a opção adequada ao tentar compilar os arquivos a seguir:

* a/A.java:
```java
package a;
class A {
    b.B variavel;
}
```
* a/C.java:
```java
package a;
class C {
    b.B variavel;
}
```
* a/b/B.java:
```java
package a.b;
class B {
}
```
* O arquivo B compila pois é uma classe normal. O arquivo C não compila pois tenta acessar B, que está em outro pacote, mas lembre-se que devemos acessar os pacotes diretamente, não existe subpacote. O mesmo vale para A. Portanto, nem A nem C compilam.

<h2>Exercicio 6</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
package A;
class B{
    public static void main(String[] a) {
        System.out.println("rodei");
    }
}
```

* R: Um pacote pode ter nome começando com maiúsculo, isso não afeta em nada. Mas não é o padrão. O nome de variáveis locais e parâmetros não afetam a assinatura de um método em Java. Uma classe não precisa ser pública para ser rodada. Portanto o código compila e roda.

<h2>Exercício 7</h2>

* Escolha a opção adequada ao tentar compilar os arquivos a seguir:

* a/A.java:
```java
package a;
public class A {
    public static final int VALOR = 15;
    public void executa(int x) {
        System.out.println(x);
    }
}
```
* b/B.java:
```java
package b;
import static a.A.*;
class B{
    void m() {
        A a = new A();
        a.executa(VALOR);
    }
}
```

* Não importamos a classe A, somente seus membros, erro de compilação ao tentar referenciá-la na linha 5.

<h2>Exercício 8</h2>

* Escolha a opção adequada ao tentar compilar os arquivos a seguir:

* a/A.java:
```java
package a;
public class A {
    public static final int VALOR = 15;
    public void executa(int x) {
        System.out.println(x);
    }
}
```

* b/B.java:
```java
package b;
import a.A;
static import a.A.*;
class B{
    void m() {
        A a = new A();
        a.executa(VALOR);
    }
}
```

* R: import static é o uso adequado, e não static import, erro na linha 3.

<h2>Exercício 9</h2>

* Escolha a opção adequada ao tentar compilar os arquivos a seguir:

* A.java:

```java
public class A {
    public static final int VALOR = 15;
    public void executa(int x) {
        System.out.println(x);
    }
}
```

* b/B.java:

```java
package b;
import static A.*;
class B{
    void m() {
        A a = new A();
        a.executa(VALOR);
    }
}
```

* R: B não compila pois tenta acessar uma classe do pacote padrão (sem nome). Classes do pacote padrão só podem ser acessadas por outros tipos do pacote padrão. Não compila.