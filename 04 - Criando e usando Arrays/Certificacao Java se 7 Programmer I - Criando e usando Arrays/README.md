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