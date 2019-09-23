<h1> Declare, instancie, inicialize e use um array uni-dimensional</h1>

* As linguagens de programação, normalmente, fornecem algum recurso para o armazenamento de variáveis em memória sequencial. No Java, os arrays permitem esse tipo de armazenamento.

* Um array é um objeto que armazena sequencialmente "uma porção" de variáveis de um determinado tipo. É importante reforçar que os arrays são objetos. Uma referência para um objeto array deve ser armazenada em uma variável do tipo array.

* A prova de certificação verifica se o candidato está apto a manipular tanto arrays de tipos primitivos quanto de tipos não primitivos.

* Os quatro pontos importantes sobre arrays são:

* Declarar
* Inicializar
* Acessar
* Percorrer
* Arrays de tipos primitivos
* Declaração:

* Para declarar um array, é utilizado [] logo após ao tipo das variáveis que desejamos armazenar ou logo após ao nome da variável.

```java
// Declaração de um array para guardar variáveis do tipo int.
int[] idades;

// Declaração de um array para guardar variáveis do tipo double.
double pesos[];

// Declaração de um array para guardar variáveis do tipo long.
long []pesos;

// Declaração de um array para guardar variáveis do tipo long.
long[]tamanhos;

// Perceba as formas de declarar um array.
```
* Inicialização:

* Como um array é um objeto, a inicialização envolve a criação de um objeto. O new, operador que cria objetos, é utilizado para construir um array. Se você não executa o new, qual o valor padrão? Para atributos, é null, e para variáveis locais, não há valor, como qualquer outra variável de referência:

```java
public class Clientes {

    int[] idades;

    public static void main(String[] args) {
        Clientes c = new Clientes();
        System.out.println(c.idades); // imprime null
    }
}
public class Produtos {

    public static void main(String[] args) {
        int[] precos;
        System.out.println(precos); // nao compila, não foi 
                                    // inicializada
    }
}
```


* E como instancio um array?

```java
// Inicialização do array idades.
idades = new int[10];

// Inicialização do array pesos.
pesos = new double[50];
```

* Na inicialização, é definida a capacidade do array, ou seja, a quantidade de variáveis que ele terá. Quando falarmos em tamanho de um array, estaremos nos referindo à sua capacidade.

* Cada variável guardada em um array é iniciada implicitamente no momento em que o array é criado. Os valores atribuídos às variáveis são os valores default.

```java
// Imprime 0 pois esse é o valor default para int.
System.out.println(idades[0]);
```

* E temos alguns casos extremos:

```java
    //compila e roda
    int[] numeros = new int[0];

    //compila, mas joga NegativeArraySizeException
    numeros = new int[-1];

```

* Durante a declaração de uma referência para um array, temos a oportunidade de criá-lo de uma maneira mais fácil se já sabemos o que queremos colocar dentro:

```java
int[] numeros;
numeros = new int[]{1,2,5,7,5};

Carro[] carros = new Carro[]{new Carro(), null, new Carro()};
```

* Não passamos o tamanho e fazemos a declaração dos elementos entre chaves e separados por vírgula. Os arrays terão tamanho 5 e 3, respectivamente.

* E se a declaração e a inicialização estiverem na mesma linha podemos simplificar ainda mais:

```java
    int[] numeros = {1,2,5,7,5};
```

* Mas temos que tomar um pouco de cuidado com esse modo mais simples de declarar o array. Só podemos fazer como no exemplo anterior quando declaramos e inicializamos o array na mesma linha. Se fizermos a declaração e a inicialização em linhas separadas, o código não compila:

```java
int[] numeros = {1,2,5,7,5}; // compila
int[] numeros2;
numeros2 = {1,2,5,7,5}; //Não compila
```

* Se desejamos inicializar posteriormente, devemos adicionar o operador new para poder iniciar o array em outra linha:

```java
int[] numeros2;
numeros2 = new int[]{1,2,5,7,5}; //compila
```

* Acesso
* As posições de um array são indexadas (numeradas) de 0 até a capacidade do array menos um. Para acessar uma das variáveis do array, é necessário informar sua posição.

```java
// Coloca o valor 10 na primeira variável do array idades.
int idades[] = new int[10];
idades[0] = 10;

// Coloca o valor 73.14 na última variável do array pesos.
double pesos[] = new double[50];
pesos[49] = 73.14;
```

* O que acontece se alguém tentar acessar uma posição que não existe?

```java
// Erro de execução ao tentar acessar um posição que não existe.
// ArrayIndexOutOfBoundsException
pesos[50] = 88.4;
```

* Será gerado um erro de execução (não de compilação). A ::exception:: lançada pelo Java é ArrayIndexOutOfBoundsException.

* Percorrendo
* Supondo que a capacidade de um array qualquer seja 100, os índices desse array variam de 0 até 99, ou seja, de 0 até a capacidade menos um.

* O tamanho de um array é definido na inicialização e fica guardado no próprio array, podendo ser recuperado posteriormente.

* Para recuperar o tamanho ou a capacidade de um array, é utilizado um atributo chamado length presente em todos os arrays.

```java
for (int i = 0; i < idades.length; i++) {
    idades[i] = i;
}
```

* No for tradicional, as posições de um array são acessadas através dos índices. Dessa forma, é possível, inclusive, modificar os valores que estão armazenados no array.

* Porém, em determinadas situações, é necessário apenas ler os valores de um array sem precisar modificá-los. Nesse caso, pode ser utilizado o for introduzido na versão 5 do Java.

```java
for(int idade : idades){
    System.out.println(idade);
}
```

* Não há índices no for do Java 5. Ele simplesmente percorre os valores. Assim ele não permite modificar o array facilmente.

<h1>Aula 02 - Declare, instancie, inicialize e use um array uni-dimensional - Array de referências</h1>

* Em cada posição de um array de tipos não primitivos é guardada uma variável não primitiva. Esse é um fato fundamental.

```java
// Declarando e iniciando um array de Prova
Prova[] provas = new Prova[10];
```

* Lembrando que o new inicia as variáveis implicitamente e que o valor padrão para variáveis não primitivas é null, todas as dez posições do array desse código estão null imediatamente após o new.

```java
// Erro de execução ao tentar aplicar o operador "." 
// em  uma referência com valor null.
// NullPointerException
provas[0].tempo = 10;
```

* Para percorrer um array de tipos não primitivos, podemos utilizar um laço:

```java
for (int i = 0; i < provas.length; i++){
    provas[i] = new Prova();
    provas[i].tempo = 210;
}

for (Prova prova : provas){
    System.out.println(prova.tempo);
}
```

* Caso a classe Prova seja abstrata, devido ao polimorfismo é possível adicionar filhas de Prova nesse array: o polimorfismo funciona normalmente, portanto funciona igualmente para interfaces.

```java
class Prova {
}
class ProvaPratica extends Prova {
}
class Test {
    public static void main(String[] args) {
        Prova[] provas = new Prova[2];
        provas[0] = new Prova();
        provas[1] = new ProvaPratica();
    }
}
```

* Uma vez que o array de objetos é sempre baseado em referências, lembre-se que um objeto não será copiado, mas somente sua referência passada:

```java
Cliente guilherme = new Cliente();
guilherme.setNome("guilherme");

Cliente[] clientes = new Clientes[10];
clientes[0] = guilherme;

System.out.println(guilherme.getNome()); // guilherme
System.out.println(clientes[0].getNome()); // guilherme

guilherme.setNome("Silveira");

System.out.println(guilherme.getNome()); // silveira
System.out.println(clientes[0].getNome()); // silveira
```

* Casting de arrays
* Não há ::casting:: de arrays de tipo primitivo, portanto não adianta tentar:

```java
    int[] valores = new int[10];
    long[] vals = valores; // não compila
```

* Já no caso de referências, por causa do polimorfismo é possível fazer a atribuição sem casting de um array para outro tipo de array:

```java
    String[] valores = new String[2];
    valores[0] = "Certificação";
    valores[1] = "Java";

    Object[] vals = valores;
    for(Object valor : vals) {
        System.out.println(valor); // Certificação e depois Java
    }
```

* E o casting compila normalmente mas, ao executarmos, um array de Object não é um array de String e levamos uma ClassCastException:

```java
    Object[] valores = new Object[2];
    valores[0] = "Certificação";
    valores[1] = "Java";
    String[] vals = (String[]) valores;
    for(Object valor : vals) {
        System.out.println(valor);
    }
```

* Isso pois a classe dos dois é distinta e a classe pai de array de string não é um array de objeto, e sim, um Object (lembre-se: todo array herda de Object):

```java
    Object[ ] objetos = new Object[ 2 ];
    String[ ] strings = new String[ 2 ];
    System.out.println(objetos.getClass().getName()); 
    // [ Ljava.lang.Object;
    System.out.println(strings.getClass().getName()); 
    // [ Ljava.lang.String;

    System.out.println(strings.getClass().getSuperclass()); 
    // java.lang.Object
```

<h1>Aula 03 - Declare, instancie, inicialize e use um array multi-dimensional</h1>

* Podemos generalizar a ideia de array para construir arrays de duas dimensões, em outras palavras, array de arrays. Analogamente, podemos definir arrays de quantas dimensões quisermos.

* Declaração:

```java
// Um array de duas dimensões.
int[][] tabela;

// Um array de três dimensões.
int[][] cubo[];

// Um array de quatro dimensões.
int[] [][]hipercubo[];

// Perceba que as dimensões podem ser definidas do lado 
// esquerdo ou direito da variável.
Inicialização:


// Inicializando a primeira dimensão com 10 e a segunda com 15
tabela = new int[10][15];

// Inicializando a primeira dimensão com 10 e deixando as outras
// para serem iniciadas depois
cubo = new int[10][][];

// Inicializando com valores
int[][] teste = new int[][]{{1,2,3},{3,2,1},{1,1,1}};
```

* Acesso:

```java
// Acessando a posição (0,1)
System.out.println(tabela[0][1]);
```

* Podemos criar um array que não precisa ser "quadrado", ele pode ter tamanhos estranhos:

```java
int[][] estranha = new int[2][];
estranha[0] = new int[20];
estranha[1] = new int[10];
for(int i=0;i<estranha.length;i++) {
    System.out.println(estranha[i].length); // imprime 20 e 10
}
```

<h1>Declare e use uma ArrayList</h1>

* Nesta prova, veremos somente a ArrayList, uma lista que usa internamente um array. Rápida no método get, pois sua estrutura interna permite acesso aleatório (random access) em tempo constante.

* Jamais se esqueça de importar a ArrayList:

```java
import java.util.ArrayList;
```

* O primeiro passo é criar uma ArrayList vazia de Strings:


```java
ArrayList<String> nomes = new ArrayList<String>();
```

* A ArrayList herda diversos métodos abstratos e concretos e veremos vários deles aqui, dentre esses, os principais para a certificação, vindos da interface Collection.

* Por exemplo, para adicionar itens, fazemos:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("certificação");
nomes.add("java");
```

* Para remover e verificar a existência do mesmo na lista:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("certificação");
nomes.add("java");

System.out.println(nomes.contains("java")); // true
System.out.println(nomes.contains("c#")); // false

// true, encontrado e removido
boolean removido = nomes.remove("java"); 

System.out.println(nomes.contains("java")); // false
System.out.println(nomes.contains("c#")); // false
```

* Note que o remove remove somente a primeira ocorrência daquele objeto.

* Podemos também verificar o tamanho de nossa ArrayList:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("certificação");
nomes.add("java");
System.out.println(nomes.size()); // imprime 2
```

* E convertê-la para um array:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("certificação");
nomes.add("java");

Object[] nomesComoString = nomes.toArray();
```

* Caso desejarmos um array de String, devemos indicar isso ao método toArray de duas formas diferentes:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("certificação");
nomes.add("java");

String[] nomes2 = nomes.toArray(new String[0]);
String[] nomes3 = nomes.toArray(new String[nomes.size()]);
```

* Ambas passam um array de String: o primeiro menor e o segundo com o tamanho suficiente para os elementos. Se ele possui o tamanho suficiente, ele mesmo será usado, enquanto que, se o tamanho não é suficiente, o toArray cria um novo array do mesmo tipo.

* Além disso, podemos adicionar uma coleção inteira em outra:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("certificação");
nomes.add("java");

ArrayList<String> paises = new ArrayList<String>();
paises.add("coreia");
paises.add("brasil");

ArrayList<String> tudo = new ArrayList<String>();
tudo.addAll(nomes);
tudo.addAll(paises);
System.out.println(tudo.size()); // imprime 4
```

* Outros métodos são específicos da interface List e recebem uma posição específica onde você quer colocar ou remover algo do array usado na ArrayList. O método get devolve o elemento na posição desejada, lembrando que começamos sempre com 0:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("certificação");
System.out.println(nomes.get(0)); // imprime certificação
```

* Já o método add foi sobrecarregado para receber a posição de inclusão:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("certificação");
System.out.println(nomes.get(0)); // imprime certificação

nomes.add(0, "java");
System.out.println(nomes.get(0)); // imprime java
System.out.println(nomes.get(1)); // imprime certificação
```

* O mesmo acontece para o método remove:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("java");
nomes.add("certificação");

String removido = nomes.remove(0); // retorna java
System.out.println(nomes.get(0)); // imprime certificação
```

* E o método set, que serve para alterar o elemento em determinada posição:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("java");
nomes.set(0, "certificação");

System.out.println(nomes.get(0)); // imprime certificação
System.out.println(nomes.size()); // imprime 1
```

* Os métodos indexOf e lastIndexOf retornam a primeira ou a última posição que possui o elemento desejado. Caso esse elemento não esteja na lista, ele retorna -1:

```java
ArrayList<String> nomes = new ArrayList<String>();
nomes.add("guilherme");
nomes.add("mario");
nomes.add("paulo");
nomes.add("mauricio");
nomes.add("adriano");
nomes.add("alberto");
nomes.add("mario");

System.out.println(nomes.indexOf("guilherme")); // 0
System.out.println(nomes.indexOf("mario")); // 1
System.out.println(nomes.indexOf("joao")); // -1
System.out.println(nomes.lastIndexOf("mario")); // 6
System.out.println(nomes.lastIndexOf("joao")); // -1
```

<h1>Aula 05 - Declare e use um ArrayList - Iterator e o enhanced for</h1>

* A interface Iterator define uma maneira de percorrer coleções. Isso é necessário porque, em coleções diferentes de List, não possuímos métodos para pegar o enésimo elemento. Como, então, percorrer todos os elementos de uma coleção?

* hasNext: retorna um booleano indicando se ainda há elementos a serem percorridos por esse iterador;
* next: pula para o próximo elemento, devolvendo-o;
* remove: remove o elemento atual da coleção.
* O código que costuma aparecer para percorrer uma coleção é o seguinte:

```java
    Collection<String> strings = new ArrayList<String>();
    Iterator<String> iterator = strings.iterator();
    while (iterator.hasNext()) {
        String atual = iterator.next();
        System.out.println(atual);
    }
```

* O enhanced-for também pode ser usado nesse caso:

```java
    Collection<String> strings = new ArrayList<String>();
    for (String atual : strings) {
        System.out.println(atual);    
    }
```

* O método equals em coleções

* A maioria absoluta das coleções usa o método equals na hora de buscar por elementos, como nos métodos contains e remove. Se você deseja ser capaz de remover ou buscar elementos, terá que provavelmente sobrescrever o método equals para refletir o conceito de igualdade em que está interessado, e não somente a igualdade de referência (implementação padrão do método).

* Cuidado ao tentar sobrescrever o método equals, se você escrevê-lo recebendo um tipo específico em vez de Object, não o estará sobrescrevendo, e o ArrayList continuará invocando o código antigo, a implementação padrão de equals!

* ArrayList e referências
* Vale lembrar que Java sempre trabalha com referências para objetos, e não cria cópias de objetos cada vez que os atribuímos a uma variável ou referência:

```java
Cliente guilherme = new Cliente();
guilherme.setNome("guilherme");

ArrayList<Cliente> clientes = new ArrayList<Cliente>();
clientes.add(guilherme);

System.out.println(guilherme.getNome()); // guilherme
System.out.println(clientes.get(0).getNome()); // guilherme

guilherme.setNome("Silveira");

System.out.println(guilherme.getNome()); // Silveira
System.out.println(clientes.get(0).getNome()); // Silveira
```