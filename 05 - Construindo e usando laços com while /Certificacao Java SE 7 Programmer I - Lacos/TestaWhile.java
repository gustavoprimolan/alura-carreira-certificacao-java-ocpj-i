class TestaWhile {
    public class void main(String[] args){
        int i = 1;
        while(i < 10){
            System.out.println(i);
            i++;
        }

        while(false) // TAMBÉM NAO COMPILA, POIS O COMPILADOR SABE QUE NUNCA CAIRA AQUI
            System.out.println("false");

        while(true)
            System.out.println("a");

        System.out.pritnln("b");//NUNCA CHEGARÁ NESSA LINHA E O COMPILADOR SABE DISSO E ELE NAO COMPILA

        //WHILE:
        //PRIMEIRO EXECUTA A CONDICAO DEPOIS O CÓDIGO
        // ELE PODE ENTRAR EM LOOPING INFINITO
        //CHAVES OPCIONAIS
        //SE É TRUE OU FINAL TRUE, ELE NAO VAI COMPILAR
    }
}