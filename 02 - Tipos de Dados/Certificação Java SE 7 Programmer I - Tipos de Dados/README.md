<h1>Aula 01 - Declarar e inicializar variáveis</h1>

* Em uma linguagem de programação sempre quando queremos armazenar valores, armazenamos em variáveis.
* Falamos que o Java é uma linguagem de programação tipada, isso é, todas as variáveis vão ter o tipo explicito, mas hoje com o Java hoje, em algumas situações podemos ter até o tipo implícito.
* Necessário sempre inicializar a varíavel, se tiver um if no meio que não garante a inicialização da variável, o código não compila.
* Variáveis membros ou Atributos possuem valor
* Atributos números são inicializados com 0 como padrão.
* Char vem com um espaço em branco como valor padrão, ou o 0.
* Boolean valor padrão é false ou 0;
* Valor padrão de uma variável referencia é null.
* Para todo objeto como atributo o valor padrão é null;
* Quando se cria um array nova, também existe um valor padrão.
* Tanto variáveis membro como arrays criadas, possuem valores padrão.
* new int[5] -> 0
* new boolean[5] -> false
* new object[5] -> null

* Tipos primitivos que não são referências no Java
    * byte
    * short
    * char
    * int
    * long
    * float
    * double
    * boolean

* double e o float -> ponto flutuante
* byte, short, int, long, char -> inteiro
* No java não existe unsigned e signed (valores que só sao negativos e só são positivos)
    * Todos eles podem ser negativo ou positivo
    * byte pode ter o valor entre -128 a +127 - não precisa decorar os outros, só o byte
    * char -> somente 0 ou positivo + enchendo de palavra
    * short e char tem o mesmo tamanho

* Ponto flutuando pode receber:
    * + infinito - divisão por 0
    * - infinito
    * NaN - Not a Number - Não é um número

* Valores literais (inicializar um valor literal para a varíavel)
    * Só falamos em literais quando estamos falando de tipos primitivos

* Palavras chaves no java sempre em minusculo
* Quer que seja long, L no final. Quer que seja float. F no final.
* Separação dos números entre com underline entre números ou underlines.
* Código unicode do caracter '\u03A9

* Identificadores de variáveis
    * Não pode usar uma palavra reservada

```java
// Declaração
int idade;

System.out.println(idade); // erro de compilação

// Declaração
int idade;

// Inicialização explícita de uma variável
idade = 10;

// Utilização da variável
System.out.println(idade); // ok
```
* Podemos declarar e iniciar a variável na mesma instrução:

```java
// Declaração e inicialização explícita na mesma linha
double pi = 3.14;
```

* Se eu tenho um if, a inicialização deve ser feita em todos os caminhos possíveis:

```java
void metodo(int a) {
    double x;
    if(a > 1) {
        x = 6;
    }
    System.out.println(x); // talvez x não tenha sido 
                           // inicializado, portanto não compila
}
```
* Quando a variável é membro de uma classe, ela é iniciada implicitamente junto com o objeto com um valor default:

```java
class Prova {
     double tempo;
}

// Implicitamente, na criação de um objeto Prova, 
// o atributo tempo é iniciado com 0
Prova prova = new Prova();

// Utilização do atributo tempo
System.out.println(prova.tempo);
```
* Outro momento em que ocorre a inicialização implícita é na criação de arrays:

```java
int[] numeros = new int[10];
System.out.println(numeros[0]); // imprime 0
```
* Quando iniciadas implicitamente, os valores default para as variáveis são:

    * primitivos numéricos inteiros - 0
    * primitivos numéricos com ponto flutuante - 0.0
    * boolean - false
    * char - vazio, equivalente a 0
    * referências - null
    * Os tipos das variáveis do Java podem ser classificados em duas categorias: primitivos e não primitivos (referências).

* Tipos primitivos
    * Todos os tipos primitivos do Java já estão definidos e não é possível criar novos tipos primitivos. São oito os tipos primitivos do Java: byte, short, char, int, long, float, double e boolean.

* O boolean é o único primitivo não numérico. Todos os demais armazenam números: double e float são ponto flutuante, e os demais, todos inteiros (incluindo char). Apesar de representar um caractere, o tipo char armazena seu valor como um número positivo. Em Java, não é possível declarar variáveis com ou sem sinal (unsigned), todos os números (exceto char) podem ser positivos e negativos.

* Cada tipo primitivo abrange um conjunto de valores. Por exemplo, o tipo byte abrange os números inteiros de -128 até 127. Isso depende do tamanho em bytes do tipo sendo usado.

* Os tipos inteiros têm os seguintes tamanhos:

    * byte - 1 byte (8 bits, de -128 a 127);
    * short - 2 bytes (16 bits, de –32.768 a 32.767);
    * char - 2 bytes (só positivo), (16 bits, de 0 a 65.535);
    * int - 4 bytes (32 bits, de –2.147.483.648 a 2.147.483.647);
    * long - 8 bytes (64 bits, de –9.223.372.036.854.775.808 a 9.223.372.036.854.775.807).
* Decorar o tamanho dos primitivos para prova
* Não há a necessidade de decorar o intervalo e tamanho de todos os tipos de primitivos para a prova. O único intervalo cobrado é o do byte (-128 a 127).

* É importante também saber que o char, apesar de ter o mesmo tamanho de um short, não consegue armazenar todos os números que cabem em um short, já que o char só armazena números positivos.

* Para saber mais: calculando o intervalo de valores
* Dado o número de bits N do tipo primitivo inteiro, para saber os valores que ele aceita usamos a seguinte conta:

* -2^(n-1) a 2^(n-1) -1
* O char, por ser apenas positivo, tem intervalo:

* 0 a 2^(16) -1
* Os tipos ponto flutuante têm os seguintes tamanhos em notação científica:

    * float - 4 bytes (32 bits, de +/–1.4 10 ^ 45 a +/–3.4028235 10 ^ 38);
    * double - 8 bytes (64 bits, de +/–4.9 10 ^ 324 a +/–1.7976931348623157 10 ^ 308).
* Todos os números de ponto flutuante também podem assumir os seguintes valores:

* +/– infinity
* +/- 0
* NaN (Not a Number)
* Literais
* Na codificação, muitas vezes o programador coloca os valores das variáveis diretamente no código-fonte. Quando isso ocorre, dizemos que o valor foi literalmente escrito no código, ou seja, é um valor literal.

* Todos os valores primitivos maiores que int podem ser expressos literalmente. Por outro lado, as referências (valores não primitivos) não podem ser expressas de maneira literal (não conseguimos colocar direto os endereços de memória dos objetos).

* Ao inicializar uma variável, podemos explicitar que queremos que ela seja do tipo double ou long usando a letra específica:

```java
        // compila pois 737821237891232 é um double válido
        System.out.println(737821237891232d);

        // compila pois 737821237891232 é um long válido
        System.out.println(737821237891232l);

        // nao compila pois 737821237891232 é um valor maior que
        // o int aceita
        System.out.println(737821237891232);
```
* Da mesma maneira, o compilador é um pouco esperto e percebe se você tenta quebrar o limite de um int muito facilmente:

```java
        // compila pois 737821237891232l é um long válido
        long l = 737821237891232l;

        // não compila pois o compilador não é bobo assim
        int i = l;


// booleanos
System.out.println(true); // booleano verdadeiro
System.out.println(false); // booleano falso

// números simples são considerados inteiros
System.out.println(1); // int

// números com casa decimal são considerados double.
// Também podemos colocar uma letra "D" ou "d" no final
System.out.println(1.0); //double
System.out.println(1.0D); //double

// números inteiros com a letra "L" ou "l" 
// no final são considerados long.
System.out.println(1L); //long

// números com casa decimal com a letra "F" ou "f" 
// no final são considerados float.
System.out.println(1.0F); //float
```
* Bases diferentes
    * No caso dos números inteiros, podemos declarar usando bases diferentes. O Java suporta a base decimal e mais as bases octal, hexadecimal e binária.

    * Um número na base octal tem que começar com um zero à esquerda e pode usar apenas os algarismos de 0 a 7:

```java
int i = 0761; // base octal

System.out.println(i); // saída: 497
```
* E na hexadecimal, começa com 0x ou 0X e usa os algarismos de 0 a 15. Como não existe um algarismo "15", usamos letras para representar algarismos de "10" a "15", no caso, "A" a "F", maiúsculas ou minúsculas:

```java
int j = 0xAB3400; // base hexadecimal
System.out.println(j); // saída: 11219968
```
* Já na base binária, começamos com 0b, e só podemos usar "0" e "1":

```java
int b = 0b100001011; // base binária
System.out.println(b); // saída: 267
```
* Não é necessário aprender a fazer a conversão entre as diferentes bases e a decimal. Apenas saber quais são os valores possíveis em cada base, para identificar erros de compilação como o que segue:

```java
int i = 0769; // erro, base octal não pode usar 9
```
* Notação científica
* Ao declarar doubles ou floats, podemos usar a notação científica:

```java
double d = 3.1E2;
System.out.println(d); // 310.0

float e = 2e3f;
System.out.println(e); // 2000.0

float f = 1E4F;
System.out.println(f); // 10000.0
```
* Usando underlines em literais
* A partir do Java 7, existe a possibilidade de usarmos underlines (_) quando estamos declarando literais para facilitar a leitura do código:


* int a = 123_456_789;
* Existem algumas regras sobre onde esses underlines podem ser posicionados nos literais, e caso sejam colocados em locais errados resultam em erros de compilação. A regra básica é que eles só podem ser posicionados com valores numéricos em ambos os lados. Vamos ver alguns exemplos:

```java
int v1 = 0_100_267_760;        // ok
int v2 = 0_x_4_13;             // erro, _ antes e depois do x
int v3 = 0b_x10_BA_75;         // erro, _ depois do b 
int v4 = 0b_10000_10_11;     // erro, _ depois do b
int v5 = 0xa10_AF_75;         // ok, apesar de ser letra 
                            // representa dígito
int v6 = _123_341;            // erro, inicia com _
int v7 = 123_432_;            // erro, termina com _
int v8 = 0x1_0A0_11;        // ok
int v9 = 144__21_12;        // ok
```
* A mesma regra se aplica a números de ponto flutuante:

```java
double d1 = 345.45_e3;        // erro, _ antes do e
double d2 = 345.45e_3;        // erro, _ depois do e
double d3 = 345.4_5e3;        // ok
double d4 = 34_5.45e3_2;    // ok
double d5 = 3_4_5.4_5e3;    // ok
double d6 = 345._45F;        // erro, _ depois do .
double d7 = 345_.45;        // erro, _ antes do .
double d8 = 345.45_F;        // erro, _ antes do indicador de 
                            // float
double d9 = 345.45_d;        // erro, _ antes do indicador de 
                            // double
```
* Iniciando chars
    * Os chars são iniciados colocando o caractere desejado entre aspas simples:


* char c = 'A';
* Mas podemos iniciar com números também. Neste caso, o número representa a posição do caractere na tabela unicode:

```java
char c = 65;
System.out.println(c); // imprime A
```

* Não é necessário decorar a tabela unicode, mas é preciso prestar atenção a pegadinhas como a seguinte:

```java
char sete = 7; // número, pois não está entre aspas simples
System.out.println(sete);  // Não imprime nada!!!!
```
* Quando usando programas em outras línguas, às vezes queremos usar caracteres unicode, mas não temos um teclado com tais teclas (árabe, chinês etc.). Neste caso, podemos usar uma representação literal de um caractere unicode em nosso código, iniciando o char com \u :

```java
char c = '\u03A9'; // unicode
System.out.println(c); // imprime a letra grega ômega
```
* Identificadores
* Quando escrevemos nossos programas, usamos basicamente dois tipos de termos para compor nosso código: identificadores e palavras reservadas.

* Chamamos de identificadores as palavras definidas pelo programador para nomear variáveis, métodos, construtores, classes, interfaces etc.

* Já palavras reservadas ou palavras-chave são termos predefinidos da linguagem que podemos usar para definir comandos (if, for, class, entre outras).

* São diversas palavras-chave na linguagem java:

    * abstract
    * assert
    * boolean
    * break
    * byte
    * case
    * catch
    * char
    * class
    * const
    * continue
    * default
    * do
    * double
    * else
    * enum
    * extends
    * false
    * final
    * finally
    * float
    * for
    * goto
    * if
    * implements
    * import
    * instanceof
    * int
    * interface
    * long
    * native
    * new
    * null
    * package
    * private
    * protected
    * public
    * return
    * short
    * static
    * strictfp
    * super
    * switch
    * synchronized
    * this
    * throw
    * throws
    * transient
    * true
    * try
    * void
    * volatile
    * while
    * null, false e true
    * Outras três palavras reservadas que não aparecem nessa lista são true, false e null. Mas, segundo a especificação na linguagem Java, esses três termos são considerados literais e não palavras-chave (embora também sejam reservadas), totalizando 53 palavras reservadas.

* http://java.sun.com/docs/books/tutorial/java/nutsandbolts/_keywords.html

* Identificadores válidos devem seguir as seguintes regras:

    * Não podem ser igual a uma palavra-chave;
    * Podem usar letras (unicode), números, $ e _;
    * O primeiro caractere não pode ser um número;
    * Podem possuir qualquer número de caracteres.
    * Os identificadores são case sensitive, ou seja, respeitam maiúsculas e minúsculas:

```java
int umNome; // ok
int umnome;    // ok, diferente do anterior
int _num;    // ok
int $_ab_c; // ok
int x_y;    // ok
int false;    // inválido, palavra reservada
int x-y;     // inválido, traço
int 4num;     // inválido, começa com número
int av#f;     // inválido, #
int num.spc; // inválido, ponto no meio
```

<h2>Exercício 01</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        int
        idade
        = 100;
        System.out.println(idade);
    }
}
```

* R: O código compila e imprime 100. Podemos ter espaços em branco desde que não quebre uma palavra-chave, nome de método, classe etc. ao meio. Onde pode ter um espaço em branco, pode haver vários.

<h2>Exercício 02</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        int idade;
        if(args.length > 0) {
            idade = Integer.parseInt(args[0]);
        } else {
            System.err.println("Por favor passe sua idade como 
                                primeiro parâmetro");
        }
        System.out.println("Sua idade é " + idade);
    }
}
```

* R: O código não compila pois tentamos acessar a variável idade que pode não ter sido inicializada. Não é certeza (somente se cair no if ela será inicializada).

<h2>Exercício 03</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        boolean array = new boolean[300];
        System.out.println(array[3]);
    }
}
```

* R: Não compila, do lado direito da atribuição temos um array de boolean e do lado esquerdo uma variável simples do tipo boolean.

<h2>Exercício 04</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        boolean argumentos;
        if(args.length > 0)
            argumentos = 1;
        else
            argumentos = 0;
        System.out.println(argumentos);
    }
}
```

* R: Não compila pois boolean em Java só pode ser false ou true.

<h2>Exercício 05</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        int n = 09;
        int m = 03;
        int x = 1_000;
        System.out.println(x - n + m);
    }
}
```

* O número octal 09 não existe. Você não precisa aprender a transformar uma base em outra, mas é importante lembrar que binários são compostos de 0s e 1s, octais são compostos de 0s até 7s, hexadecimais são de 0s até 9s e As até Fs (maiúsculo ou minúsculo). O caractere _ é permitido desde que dos dois lados dele tenhamos algarismos válidos, que é o caso de 1_000. Portanto, o único número inválido é 09 (por curiosidade, o número 9 em base octal é 011).

<h2>Exercício 06</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        for(char c='a';c <= 'z';c++) {
            System.out.println(c);
        }
    }
}
```

* R: Compila e imprime o alfabeto pois caracteres são números em Java.

<h2>Exercício 07</h2>

* Qual das palavras a seguir não é reservada em Java?
* R: instanceOf não é palavra reservada: note a letra maiúscula no meio dela. Nenhuma palavra-chave em Java possui caractere maiúsculo.

<h2>Exercício 08</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        boolean BOOLEAN = false;
        if(BOOLEAN) {
            System.out.println("Sim");
        }
    }
}
```

* R: Compila e roda, não imprimindo nada. Lembre-se que os identificadores são case-sensitive.

<h1>Aula 02 - Diferenciar entre variáveis de referências a objetos e tipos primitivos</h1>

* Variáveis que podem referenciar um objeto (Variáveis de referencia)
* Variáveis de tipos primitivos (Que tem um valor). Quando um valor é atribuido para outra variável, eu estou copiando o valor para aquela variável.
* Variáveis de referencia está apontando para o objeto. o1 -> meu objeto valor:0
* Tipo primitivo copia o valor. Tipo objeto referencia o valor.
* Primitivo: copia o valor;
* Referência: cria uma nova referência para o mesmo objeto.

* As variáveis de tipos primitivos de fato armazenam os valores (e não ponteiros/referências). Ao se atribuir o valor de uma variável primitiva a uma outra variável, o valor é copiado, e o original não é alterado:

```java
int a = 10;
int b = a; // copiando o valor de a para b
b++; // somando 1 em b
System.out.println(a); // continua com 10.
```
* Os programas construídos com o modelo orientado a objetos utilizam, evidentemente, objetos. Para acessar um atributo ou invocar um método de qualquer objeto, é necessário que tenhamos armazenada uma referência para o mesmo.

* Uma variável de referência é um ponteiro para o endereço de memória onde o objeto se encontra. Ao atribuirmos uma variável de referência a outra, estamos copiando a referência, ou seja, fazendo com que as duas variáveis apontem para o mesmo objeto, e não criando um novo objeto:

```java
class Objeto {
    int valor;
}

class Teste{
    public static void main(String[] args){
        Objeto a = new Objeto();
        Objeto b = a; // agora b aponta para o mesmo objeto de a

        a.valor = 5;

        System.out.println(b.valor); // imprime 5
    }
}
```
* Duas referências são consideradas iguais somente se elas estão apontando para o mesmo objeto. Mesmo que os objetos que elas apontem sejam iguais, ainda são referências para objetos diferentes:

```java
Objeto a = new Objeto();
a.valor = 5;

Objeto b = new Objeto();
b.valor = 5;

Objeto c = a;

System.out.println(a == b); // false
System.out.println(a == c); // true
```
* Veremos bastante sobre comparação de tipos primitivos e de referências mais à frente.

<h2>Exercício 1</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        int x = 15;
        int y = x;
        y++;
        x++;
        int z = y;
        z--;
        System.out.println(x + y + z);
    }
}
```

* R: Imprime 47, pois a atribuição é por cópia do valor.

<h2>Exercício 2</h2>

Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class B {
    int v = 15;
}
class A {
    public static void main(String[] args) {
        B x = new B();
        B y = x;
        y.v++;
        x.v++;
        B z = y;
        z.v--;
        System.out.println(x.v + y.v + z.v);
    }
}
```

* R: Imprime 48, pois a atribuição de objetos é feita por cópia da referência, criamos somente um único objeto do tipo B.

<h1>Aula 03 - Lendo e escrevendo campos de objetos</h1>

* Como acessar variáveis membro ou atributos.
* Read or write to object fields
* this.variavelMembro -> explicitamente

* Ler e escrever propriedades em objetos é uma das tarefas mais comuns em um programa java. Para acessar um atributo, usamos o operador . (ponto), junto a uma variável de referência para um objeto. Veja a seguinte classe:


```java
class Carro {
    String modelo;
    int ano;

    public Carro() { ano = 2014; }

    public String getDadosDeImpressao() {
        return modelo + " - " + ano;
    }

    public void setModelo(String m) {
        this.modelo = m;
    }
}
```
* Vamos escrever um código para usar essa classe:

```java
Carro a = new Carro();
a.modelo = "Palio";     // acessando diretamente o atributo
a.setModelo("Palio");    // acessando o atributo por um método

// acessando o método e passando o retorno como argumento para
// o método println
System.out.println(a.getDadosDeImpressao());  

}
```
* As linhas 2 e 3 têm exatamente o mesmo efeito. Como iniciamos o valor da propriedade ano no construtor, ao chamar o método imprimeDados, o valor 2014 é exibido junto ao nome do modelo.

* Quando estamos dentro da classe, não precisamos de nenhum operador para acessar os atributos de instância da classe. Opcionalmente, podemos usar a palavra-chave this, que serve como uma variável de referência para o próprio objeto onde o código está sendo executado:

```java
class Carro{
    int ano;
    int modelo;

    public Carro(){ 
        modelo = "Indefinido";    // acessando variável de 
                                // instancia sem o this
        this.ano = 2014;        // acessando com o this.
    }
```


<h2>Exercício 1</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class B{
    int c;
    void c(int c) {
        c = c;
    }
}
class A {
    public static void main(String[] args) {
        B b = new B();
        b.c = 10;
        System.out.println(b.c);
        b.c(30);
        System.out.println(b.c);
    }
}
```

* R: Não existe conflito de nomes entre variável membro e método ou variável membro e variável local. Ao invocar o método c, por causa do shadowing da variável c, não acessamos a variável membro, sem alterá-la. O resultado é a impressão dos valores 10 e 10 novamente.

<h1>Aula 04 - O ciclo de vida de um objeto</h1>

* Como é o ciclo de vida de um objeto?

* Ciclo de vida:
    * Novo objeto, referência
    * não referenciado
    * deixa de existir, garbage coletado

* Criação - Não referenciado - Garbage Collected

* Criado = Construtor = new NomeDoObjeto();
* Acessível: Enquanto é referenciado diretamente ou indiretamente
* Inacessível: Sem referências diretas ou indiretas
* GC: Garbage Collector -> Joga os objetos fora depois que se tornaram inacessíveis

* Quantos objetos foram garbage coletados? Não é possível dizer.
* Inacessíveis é.

* Referências podem ser diretas ou indiretas

<h2>O ciclo de vida de um objeto</h2>

* O ciclo de vida dos objetos java está dividido em três fases distintas. Vamos conhecê-las e entender o que cada uma significa.

* Criação de objetos
* Toda vez que usamos o operador new, estamos criando uma nova instância de um objeto na memória:

```java
class Pessoa {
    String nome;
}

class Teste {
    public static void main(String[] args) {
        Pessoa p = new Pessoa(); // criando um novo objeto do 
                                 // tipo Pessoa
    }
}
```
* Repare que há uma grande diferença entre criar um objeto e declarar uma variável. A variável é apenas uma referência, um ponteiro, não contém um objeto de verdade.

```java
// Apenas declarando a variável, 
// nenhum objeto foi criado aqui
Pessoa p;

// Agora um objeto foi criado e atribuído a variável
p = new Pessoa();
Objeto acessível
```
* A partir do momento em que um objeto foi criado e atribuído a uma variável, dizemos que o objeto está acessível, ou seja, podemos usá-lo em nosso programa:

```java
Pessoa p = new Pessoa(); // criação
p.nome = "Mário"; // acessando e usando o objeto
```
* Objeto inacessível
* Um objeto é acessível enquanto for possível "alcançá-lo" através de alguma referência direta ou indireta. Caso não exista nenhum caminho direto ou indireto para acessar esse objeto, ele se torna inacessível.:

```java
Pessoa p = new Pessoa();
p.nome = "Mário";

// atribuímos a p o valor null
// o objeto não está mais acessível
p = null

// criando um objeto sem variável
new Pessoa();
```
* Nesse código, criamos um objeto do tipo Pessoa e o atribuímos à variável p. Na linha 6 atribuímos null a p. O que acontece com o objeto anterior? Ele simplesmente não pode mais ser acessado por nosso programa, pois não temos nenhum ponteiro para ele. O mesmo pode ser dito do objeto criado na linha 9. Após essa linha, não conseguimos mais acessar esse objeto.

* Outra maneira de ter um objeto inacessível é quando o escopo da variável que aponta para ele termina:

```java
int valor = 100;
if( valor > 50) {
    Pessoa p = new Pessoa();
    p.nome = "João";
} // Após esta linha, o objeto do tipo Pessoa não está mais 
  // acessível
```
* Garbage Collector
* Todo objeto inacessível é considerado elegível para o ::garbage collector::. Algumas questões da prova perguntam quantos objetos são elegíveis ao garbage collector ao final de algum trecho de código:

```java
public class Bla {
     int b;
     public static void main(String[] args) {
         Bla b;
        for (int i = 0; i < 10; i++) {
             b = new Bla(); 
             b.b = 10;
         }
           System.out.println("fim");
     }
 }
 ```
* Ao chegar na linha 9, temos 9 objetos elegíveis para o Garbage Collector.

* Objetos elegíveis X Objetos coletados
* O ::garbage collector:: roda em segundo plano juntamente com sua aplicação java. Não é possível prever quando ele será executado, portanto não se pode dizer com certeza quantos objetos foram efetivamente coletados em um certo ponto da aplicação. O que podemos determinar é quantos objetos são elegíveis para a coleta. A prova pode tentar se aproveitar do descuido do desenvolvedor aqui: nunca temos certeza de quantos objetos passaram pelo garbage collector, logo, somente indique quantos estão passíveis de serem coletados.

* Por fim, é importante ver um exemplo de referência indireta, no qual nenhum objeto pode ser "garbage coletado":

```java
import java.util.*;
class Carro {

}
class Carros {
    List<Carro> carros = new ArrayList<Carro>();
}
class Teste {
    public static void main(String args[]) {
        Carros carros = new Carros();
        for(int i = 0; i < 100; i++)
            carros.carros.add(new Carro());
        // até essa linha todos ainda podem ser alcançados
    }
}
```
* Nesse código, por mais que tenhamos criados 100 carros e um objeto do tipo Carros, nenhum deles pode ser garbage coletado pois todos podem ser alcançados direta ou indiretamente através de nossa thread principal.

<h2>Exercício 01</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class B{

}
class A {
    public static void main(String[] args) {
        B b;
        for(int i = 0;i < 10;i++)
            b = new B();
        System.out.println("Finalizando!");
    }
}
```
* Compila e não podemos falar quantos objetos do tipo B foram garbage coletados na linha do System.out. Alternativa correta

<h2>Exercício 02</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class B{

}
class A {
    public static void main(String[] args) {
        B b = new B();
        for(int i = 0;i < 10;i++)
            b = new B();
        System.out.println("Finalizando!");
    }
}
```

* Compila e 10 objetos do tipo B podem ser garbage coletados ao chegar na linha do System.out.

<h2>Exercício 03</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class B{

}
class A {
    public static void main(String[] args) {
        B[] bs = new B[100];
        System.out.println("Finalizando!");
    }
}
```

* O código compila, mas como não chamamos nenhum construtor, o único objeto criado que se assemelha a B, porém não é B, é um array do tipo B, com 100 espaços. Nenhum objeto é criado. Note que para criar devemos, por padrão, invocar o construtor.

<h1>Aula 05 - Chamadas de métodos nos objetos</h1>

* Call methods on objects

* Argumentos de um método é obrigatório preencher todos. Utilizar o retorno do método é opcional

* ... (varargs) - Apenas um tipo e tem que ser o último argumento do método.
* Um varargs é um array, mas um array não é um varargs. Não são a mesma coisa

* Além de acessar atributos, também podemos invocar métodos em um objeto. Para isso usamos o operador . (ponto), junto a uma variável de referência para um objeto. Deve-se prestar atenção ao número e tipo de parâmetros do método, além do seu retorno. Métodos declarados como void não possuem retorno, logo, não podem ser atribuídos a nenhuma variável ou passado para outro método como parâmetro:


```java
class Pessoa{

    String nome;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}

class Teste{
    public static void main(String[] args){
        Pessoa p = new Pessoa();

        //chamando método na variável de ref.
        p.setNome("Mario");

        //Atribuindo o retorno do método a variável.
        String nome = p.getNome();

        // erro, método é void
        String a = p.setNome("X");
    }
}
```
* Quando um método está sendo invocado em um objeto, podemos chamar outro método no mesmo objeto através da invocação direta ao nome do método:

```java
class A {
    void metodo1() {
        metodo2(); // chama o metodo2 no objeto onde metodo1 foi
                   // chamado
    }
    void metodo2() {
    }
}
```
* Argumentos variáveis: varargs
* A partir do Java 5, varargs possibilitam um método que receba um número variável (não fixo) de parâmetros. É a maneira de receber um array de objetos e possibilitar uma chamada mais fácil do método.

* Um caso especial é quando método recebe um argumento variável (varargs). Neste caso, podemos chamá-lo com qualquer número de argumentos:


```java
class Calculadora{
    public int soma(int... nums){
        int total = 0;
        for (int a : nums){
            total+= a;
        }
        return total;
    }

}
```
* nums realmente é um array aqui, você pode fazer um for usando o length, ou mesmo usar o enhanced for. A invocação desse método pode ser feita de várias maneiras:

```java
    public static void main (String[] args){
        Calculadora c = new Calculadora();    

        //Todas as chamadas abaixo sao válidas
        System.out.println(c.soma());
        System.out.println(c.soma(1));
        System.out.println(c.soma(1,2));
        System.out.println(c.soma(1,2,3,4,5,6,7,8,9));
    }
```
* Em todos os casos, um array será criado, nunca null será passado. Um parâmetro varargs deve ser sempre o último da assinatura do método para evitar ambiguidade. Isso implica que apenas um dos parâmetros de um método seja varargs. E repare que os argumentos variáveis têm que ser do mesmo tipo.

* E será dada a prioridade para o método que já podia existir antes no Java 1.4:

```java
void metodo(int ... x) { }
void metodo(int x) {}

metodo(5);
```
* Isso vai invocar o segundo método. Podemos também passar um array de ints para um método que recebe um varargs:

```java
void metodo(int ... x) { }

metodo(new int[] {1,2,3,4});
```
* Mas nunca podemos chamar um método que recebe array como se ele fosse varargs:

```java
void metodo(int[] x) { }

metodo(1,2,3); // não compila
```

<h2>Exercício 01</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class B {
    void x() {
        System.out.println("vazio");
    }
    void x(String... args) {
        System.out.println(args.length);
    }
}
class C {
    void x(String... args) {
        System.out.println(args.length);
    }
    void x() {
        System.out.println("vazio");
    }
}
class A {
    public static void main(String[] args) {
        new B().x();
        new C().x();
    }
}
```

* R: O código compila e devido à regra de sempre invocar o mais específico, ele sempre invoca o método sem argumentos. Portanto, o resultado é vazio/vazio. Lembre-se que em Java a ordem de definição de métodos não importa para a invocação. Já a ordem das variáveis pode importar, caso uma dependa da outra.

<h2>Exercício 02</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class B{
    void x(int... x) {
        System.out.println(x.length);
    }
}
class A {
    public static void main(String[] args) {
        new B().x(23789,673482);
    }
}
```

* R: O código compila e imprime 2.

<h2>Exercício 03</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class B{
    void x(int... x) {
        System.out.println(x.length);
    }
}
class A {
    public static void main(String[] args) {
        new B().x(new int[]{23789,673482});
    }
}
```
* R: O código compila e imprime 2.


<h1>Aula 06 - Manipulando dados usando a classe StringBuilder</h1>

* Creating and Manipulating Strings
* StringBuffer e StringBuilder

* StringBuffer é uma versão mais antiga do java, mas utilizada até hoje.
* StringBuilder veio do Java 5 (1.5).
* StringBuffer não sincroniza ao acesso aos métodos
* StringBuilder tem acesso sincronizado para cada um dos métodos
* StringBuilder se os métodos estão sendo acessados por apenas um thread - StringBuilder

* Para suportar Strings mutáveis, o Java possui as classes StringBuffer e StringBuilder. A operação mais básica é o append que permite concatenar ao mesmo objeto:

```java
StringBuffer sb = new StringBuffer();
sb.append("Caelum");
sb.append(" - ");
sb.append("Ensino e Inovação");

System.out.println(sb);  // Caelum - Ensino e Inovação
```

* Repara que o append não devolve novos objetos como em String, mas altera o próprio StringBuffer, que é mutável.

* Podemos criar um objeto desse tipo de diversas maneiras diferentes:

```java
// vazio
StringBuilder sb1 = new StringBuilder(); 
// conteudo inicial
StringBuilder sb2 = new StringBuilder("java"); 
// tamanho inicial do array para colocar a string
StringBuilder sb3 = new StringBuilder(50); 
// baseado em outro objeto do mesmo tipo
StringBuilder sb4 = new StringBuilder(sb2);
```

* Tenha cuidado: ao definir o tamanho do array, não estamos criando uma String de tamanho definido, somente um array desse tamanho que será utilizado pelo StringBuilder, portanto:

```java
StringBuilder sb3 = new StringBuilder(50);
System.out.println(sb3); // linha em branco
System.out.println(sb3.length()); // 0
```

* As classes StringBuffer e StringBuilder têm exatamente a mesma interface (mesmos métodos), sendo que a primeira é ::thread-safe:: e a última não (e foi adicionada no Java 5). Quando não há compartilhamento entre threads, use sempre que possível a StringBuilder, que é mais rápida por não precisar se preocupar com ::locks::.

* Inclusive, em Java, quando fazemos concatenação de Strings usando o +, por baixo dos panos, é usado um StringBuilder. Não existe a operação + na classe String. O compilador troca todas as chamadas de concatenação por StringBuilders (podemos ver isso no bytecode compilado).

* Principais métodos de StringBuffer e StringBuilder
* Há a família de métodos append com overloads para receber cada um dos primitivos, Strings, arrays de chars, outros StringBuffer etc. Todos eles devolvem o próprio StringBuffer/Builder o que permite chamadas encadeadas:

```java
StringBuffer sb = new StringBuffer();
sb.append("Caelum").append(" - ").append("Ensino e Inovação");
System.out.println(sb);  // Caelum - Ensino e Inovação
```
* O método append possui uma versão que recebe Object e chama o método toString de seu objeto.

* Há ainda os métodos insert para inserir coisas no meio. Há versões que recebem primitivos, Strings, arrays de char etc. Mas todos têm o primeiro argumento recebendo o índice onde queremos inserir:

```java
StringBuffer sb = new StringBuffer();
sb.append("Caelum - Inovação");
sb.insert(9, "Ensino e ");

System.out.println(sb); // Caelum - Ensino e Inovação
```
* Outro método que modifica é o delete, que recebe os índices inicial e final:

```java
StringBuffer sb = new StringBuffer();
sb.append("Caelum - Ensino e Inovação");
sb.delete(6, 15);

System.out.println(sb); // Caelum e Inovação
```
* Para converter um StringBuffer/Builder em String, basta chamar o toString mesmo. O método reverse inverte seu conteúdo:

```java
System.out.println(new StringBuffer("guilherme").reverse());
                                                // emrehliug
```
* Fora esses, também há o charAt, length(), equals, indexOf, lastIndexOf, substring.

* Cuidado, pois o método substring não altera o valor do seu StringBuilder ou StringBuffer, mas retorna a String que você deseja. Existe também o método subSequence que recebe o início e o fim e funciona da mesma maneira que o substring com dois argumentos.

<h2>Exercício</h2>

* Escolha a opção adequada ao tentar compilar e rodar o arquivo a seguir:

```java
class A {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("guilherme").delete(2,3);
        System.out.println(sb);
    }
}
```

* O array começa na posição 0, portanto, o primeiro caractere removido se encontra na posição 2, o i. Ele remove todos os caracteres até a posição 3, exceto o da posição 3, portanto somente o i é removido.

<h1>Aula 07 - Criando e Manipulando Strings</h1>

* String é imutável, ela não muda o valor dela depois que ela foi criada.

* Existem duas maneiras tradicionais de criar uma String:


```java
String nomeDireto = "Java";
String nomeIndireto = new String("Java");
```

* A comparação entre esses dois tipos de criação de Strings é feita na seção ::Test equality between strings and other objects using == and equals():: testequality

* Existem outras maneiras não tão comuns:

```java
char[] nome = new char[]{'J', 'a', 'v', 'a'};
String nomeComArray = new String(nome);

StringBuilder sb1 = new StringBuilder("Java");
String nome1 = new String(sb1);

StringBuffer sb2 = new StringBuffer("Java");
String nome2 = new String(sb2);
```

* Como uma String não é um tipo primitivo, ela pode ter valor null, lembre-se disso:

```java
String nome = null; // null explicito
```

* Podemos concatenar Strings com o +:

```java
String nome = "Certificação" + " " + "Java";
```

* Caso tente concatenar null com uma String, temos a conversão de null para String:

```java
String nula = null;
System.out.println("nula: " + nula); // imprime nula: null
```

* O Java faz a conversão de tipos primitivos para Strings automaticamente, mas lembre-se da precedência de operadores:

```java
String nome = "Certificação" + ' ' + "Java" + ' ' + 1500;
System.out.println(nome);

String nome2 = "Certificação";
nome2 += ' ' + "Java" + ' ' + 1500;
System.out.println(nome2);

String valor = 15 + 00 + " certificação";
System.out.println(valor); // imprime "15 certificação",
// primeiro efetuando uma soma
Strings são imutáveis
```

* O principal ponto sobre Strings é que elas são imutáveis:

```java
    String s = "caelum";
    s.toUpperCase();
    System.out.println(s);
```

* Esse código imprime caelum em minúscula. Isso porque o método toUpperCase não altera a String original. Na verdade, se olharmos o javadoc da classe String vamos perceber que todos os métodos que parecem modificar uma String na verdade devolvem uma nova.

```java
    String s = "caelum";
    String s2 = s.toUpperCase();
    System.out.println(s2);
```

* Agora sim imprimirá CAELUM, uma nova String. Ou, usando a mesma ::referência:::

```java
    String s = "caelum";
    s = s.toUpperCase();
    System.out.println(s);
```

* Para tratarmos de "strings mutáveis", usamos as classes StringBuffer e StringBuilder.

* Lembre-se que a String possui um array por trás e, seguindo o padrão do Java, suas posições começam em 0:

```java
// 0=g, devolve 'g'
char caracter0 = "guilherme".charAt(0);

// 0=g 1=u, devolve 'u'
char caracter1 = "guilherme".charAt(1); 

// 0=g 1=u 2=i, devolve 'i'
char caracter2 = "guilherme".charAt(2);
```

* Cuidado ao acessar uma posição indevida, você pode levar um StringIndexOutOfBoundsException (atenção ao nome da Exception, não é ArrayIndexOutofBoundsException):

```java
char caracter20 = "guilherme".charAt(20); // exception
char caracterMenosUm = "guilherme".charAt(-1); // exception
```

* Principais métodos de String
* O método length imprime o tamanho da String:

```java
String s = "Java";
System.out.println(s.length()); // 4
System.out.println(s.length); // não compila: não é atributo
System.out.println(s.size()); // não compila: não existe size
                              // em String Java
```

* Já o método isEmpty diz se a String tem tamanho zero:

```java
System.out.println("".isEmpty()); // true
System.out.println("java".isEmpty()); // false
System.out.println(" ".isEmpty()); // false
```

* Devolvem uma nova String:

```java
String toUpperCase() - tudo em maiúscula;
String toLowerCase() - tudo em minúsculo;
String trim() - retira espaços em branco no começo e no fim;
String substring(int beginIndex, int endIndex) - devolve a substring a partir dos índices de começo e fim;
String substring(int beginIndex) - semelhante ao anterior, mas toma a substring a partir do índice passado até o final da String;
String concat(String) - concatena o parâmetro ao fim da String atual e devolve o resultado;
String replace(char oldChar, char newChar) - substitui todas as ocorrências de determinado char por outro;
String replace(CharSequence target, CharSequence replacement) - substitui todas as ocorrências de determinada CharSequence (como String) por outra.
```

* O método trim limpa caracteres em branco nas duas pontas da String:

```java
System.out.println("     ".trim()); // imprime só a quebra de linha do println
System.out.println(" ".trim().isEmpty()); // true
System.out.println(" guilherme "); // imprime guilherme
System.out.println(". ."); // imprime '. .'
```

* O método replace substituirá todas as ocorrências de um texto por outro:

```java
System.out.println("java".replace("j", "J")); // Java
System.out.println("guilherme".replace("e", "i")); // guilhirmi
```

* Podemos sempre fazer o ::chaining:: e criar uma sequência de "transformações" que retornam uma nova String:

```java
String parseado = "  Quero tirar um certificado oficial de  Java!  ".toUpperCase().trim();

// imprime: "QUERO TIRAR UM CERTIFICADO OFICIAL DE JAVA!"
System.out.println(parseado);
```
* Para extrair pedaços de uma String, usamos o método substring. Cuidado ao usar o método substring com valores inválidos, pois eles jogam uma Exception. O segredo do método susbtring é que ele não inclui o caractere da posição final, mas inclui o caractere da posição inicial:

```java
String texto = "Java";

// ava
System.out.println(texto.substring(1)); 

// StringIndexOutOfBoundsException
System.out.println(texto.substring(-1));

// StringIndexOutOfBoundsException
System.out.println(texto.substring(5));    

// Java
System.out.println(texto.substring(0, 4)); 

// ava
System.out.println(texto.substring(1, 4)); 

// Jav
System.out.println(texto.substring(0, 3)); 

// StringIndexOutOfBoundsException
System.out.println(texto.substring(0, 5));    

// StringIndexOutOfBoundsException
System.out.println(texto.substring(-1, 4));
```

* Comparação:
```java
boolean equals(Object) - compara igualdade caractere a caractere (herdado de Object);
boolean equalsIgnoreCase(String) - compara caractere a caractere ignorando maiúsculas/minúsculas;
int compareTo(String) - compara as 2 Strings por ordem lexicográfica (vem de Comparable);
int compareToIgnoreCase(String) - compara as 2 Strings por ordem lexicográfica ignorando maiúsculas/minúsculas.
```

* E aqui, todas as variações desses métodos. Não precisa saber o número exato que o compareTo retorna, basta saber que será negativo caso a String na qual o método for invocado vier antes, zero se for igual, positivo se vier depois do parâmetro passado:

```java
String texto = "Certificado";
System.out.println(texto.equals("Certificado")); // true
System.out.println(texto.equals("certificado")); // false
System.out.println(texto.equalsIgnoreCase("certificado"));//true

System.out.println(texto.compareTo("Arnaldo")); // 2
System.out.println(texto.compareTo("Certificado")); // 0
System.out.println(texto.compareTo("Grécia")); // -4

System.out.println(texto.compareTo("certificado")); // -32

System.out.println(texto.compareToIgnoreCase("certificado"));//0
```

* Buscas simples:

```java
boolean contains(CharSequence) - devolve true se a String contém a sequência de chars;
boolean startsWith(String) - devolve true se começa com a String do parâmetro;
boolean endsWith(String) - devolve true se termina com a String do parâmetro;
int indexOf(char) e int indexOf(String) - devolve o índice da primeira ocorrência do parâmetro;
int lastIndexOf(char) e int lastIndexOf(String) - devolve o índice da última ocorrência do parâmetro.
```

* O código a seguir exemplifica todos os casos desses métodos:

```java
String texto = "Pretendo fazer a prova de certificação de Java";

System.out.println(texto.indexOf("Pretendo")); // imprime 0
System.out.println(texto.indexOf("Pretendia")); // imprime -1
System.out.println(texto.indexOf("tendo")); // imprime 3

System.out.println(texto.indexOf("a")); // imprime 10
System.out.println(texto.lastIndexOf("a")); // imprime 45
System.out.println(texto.lastIndexOf("Pretendia")); //imprime -1

System.out.println(texto.startsWith("Pretendo")); // true
System.out.println(texto.startsWith("Pretendia")); // false

System.out.println(texto.endsWith("Java")); // true
System.out.println(texto.endsWith("Oracle")); // false
```
<h2>Exercício 1</h2>

* Considere o seguinte código dentro de um main:

```java
class A{
    public static void main(String [] args){
        String s = "aba";
        for(int i = 0; i < 9; i++) {
            s = s +"aba";
        }
        System.out.println(s.length);
    }
}
```

* R: Não compila, pois length() é um método de String, diferente dos arrays em que length é um atributo.

<h2>Exercício 2</h2>

* Dada a seguinte classe:

```java

class B {
    String msg;

    void imprime() {
        if (!msg.isEmpty())
            System.out.println(msg);
        else
            System.out.println("vazio");
    }
}
```
* O que acontece se chamarmos new B().imprime(); ?

* R: Dá NullPointerException! msg é null e não dá pra chamar isEmpty em null.

<h2>Exercicio 3</h2>

* Dada a seguinte classe:

```java
class B {

    void imprime() {
        String msg;
        if (!msg.isEmpty())
            System.out.println(msg);
        else
            System.out.println("vazio");
    }
}
```
* O que acontece se chamarmos new B().imprime() ?

* R: Não compila pois a variável não foi inicializada.

