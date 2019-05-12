package financeiro;

// import modelo.Pessoa;
// import modelo.Endereco;
import modelo.*;

//NÃO PODE IMPORTAR DUAS CLASSES COM O MESMO NOME
// import java.util.Date;
// import java.sql.Date;

//ASSIM FUNCIONA, MAS QUAL DATE ELE VAI PEGAR?
//VAI PEGAR O ESPECÍFICO E NÃO O GERAL
import java.util.*;
import java.sql.Date;

//IMPORTA A REFERENCIA DO TAMANHO NO UTIL
// import static modelo.Util.TAMANHO;
// import static modelo.Util.maior;
//REFERENCIA TUDO QUE É ESTÁTICO
import static modelo.Util.*;

class Pedido{
    // modelo.Pessoa cliente;
    Pessoa cliente;
    // modelo.Endereco endereco;
    Endereco endereco;
    
    //TIPOS INCOMPATIVEIS  
    //Date dataDeCriacao = new java.util.Date();

    //CLASSES DEFINIDAS NO PACOTE DEFAULT NÃO PODERÁ SER ACESSADA POR NGM
    // Produto produto;

    public Pessoa getCliente() {
        return cliente;
    }

    public void calculaTudo(){
        //COMO JA FORAM IMPORTADOS NÃO PRECISA ACESSAR PELO FULLYQUALIFIED NAME
        // int t = modelo.Util.TAMANHO;
        // modelo.Util.maior(3, 10); 

        int t = TAMANHO;
        maior(3, 10);

    }

}