class TestaComparacaoStrings2 {
    public static void main(String[] args){
        String ab = "a" + "b"; //CONCATENA DOIS LITERAIS O RESULTADO É UM LITERAL
        System.out.println(ab == "ab"); //TRUE

        String a = "a";
        String ab2 = a + "b"; // CRIA UM NOVO OBJETO E NAO UTILIZA O POOL
        System.out.println(ab2 == "ab"); //FALSE


        //STRING SAO IMUTÁVEIS
        String texto = "um texto qualquer";
        String txt = texto.substring(3, 8); //CRIADO COMO OBJETO - NUNCA ESTARÁ NO POOL POIS CRIARA UM NOVO OBJETO
        System.out.println(txt == "texto"); //FALSE


        //PEGADINHA
        //CHAMA O MÉTODO DA STRING E ELE DEVOLVE O MESMO OBJETO TEXTO - POIS OS VALORES SAO IGUAIS
        System.out.println(texto.toLowerCase() == texto); //TRUE

        //TRUE
        Ststem.out.pritnln(texto.toString() == texto);
    }
}