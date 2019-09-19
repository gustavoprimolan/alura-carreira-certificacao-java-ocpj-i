class TestaComparacaoStrings{
    public static void main(String[] args){
        String nome1 = new String("Gustavo");
        String nome2 = new String("Gustavo");

        System.out.println(nome1 == nome2);


        //STRING LITERAL
        String nome3 = "Gustavo"; //PEGA A STRING NO POOL DE STRING
        String nome4 = "Gustavo"; //JAVA ARMAZENA AS STRINGS MAIS UTILIZADAS NO POOL DE STRINGS
        String nome5 = new String("Gustavo"); //CRIA UM NOVO OBJETO NAO USANDO O POOL DE STRING
        System.out.println(nome3 == nome4); //COMPARA A POSICAO DA MEMÓRIA
        System.out.println(nome3 == nome5);
        System.out.println(nome3.equals(nome5));//COMPARA O VALOR DA STRING
    }
}