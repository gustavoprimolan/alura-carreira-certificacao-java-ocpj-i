class TestaComparacao {
    public static void main(String[] args){
        System.out.println(1.0f == 1.0d); //IGNORA O TIPO E VERIFICA O VALOR EM PRIMITIVO
        System.out.println(1 != 1);

        int idade = 25;
        System.out.println(idade = 1); //COMPILA E PRIMEIRO É FEITA A ATRIBUICAO DEPOIS PRINTA A MENSAGEM

        System.out.println(true == true);
        System.out.println(true != false);

        // System.out.println(true == "true"); NAO EXISTE COMPARACAO DE TIPOS DIFERENTES
        // System.out.println(true == 1); NAO EXISTE COMPARACAO DE TIPOS DIFERENTES

        System.out.println(2 >= 1);
        System.out.println(2 <= 1); // NAO COMPILA
        System.out.println(2 <= 1);
        System.out.println(2 > 1);
        System.out.println(2 < 1);

    }
}