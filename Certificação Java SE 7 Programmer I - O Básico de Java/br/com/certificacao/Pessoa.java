//declaração dos pacotes
package br.com.certificacao;

//comentário antes do import
import java.util.Date; //direita do import

interface A {
    //NÃO PODE TER O SEU VALOR OU SUA REFERÊNCIA ALTERADA
    //A VARIÁVEL POR PADRÃO É ESTÁTICA
    public final int TAMANHO = 5;

    //AMBOS SÃO PÚBLICOS QUEIRA EU DIGITE OU NAO
    //O MÉTODO POR PADRAO É ABSTRATO
    public void auntentica(String nome, String senha);
}

class B{
    //NÃO EXISTE CONFLITO ENTRE NOME DE VARIÁVEL E NOME DE CLASSE
    int B;
    static int A = 10;

    B(){

    }

    void B(){
     
    }

}

/**Javadoc
 * Serve para documentar a minha classe etc
 */
class /*NOME DA CLASSE (COMENTARIO PERMITIDO)*/Pessoa{
    /*
    COMENTÁRIO
    */

    //ATRIBUTOS
    String nome;

    //CONSTRUTORES
    Pessoa(String nome){
        this.nome = nome;
    }

    //MÉTODOS
    public String getNome() {
        String sobrenome = "Primolan";
        return nome + sobrenome;
    }
}

interface Figura{

}