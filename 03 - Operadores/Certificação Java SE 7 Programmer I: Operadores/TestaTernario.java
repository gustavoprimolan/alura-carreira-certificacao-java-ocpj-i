class TestaTernario {
    public static void main(String[] args){
        // (condicao) ? caso_verdadeira : caso_falsa;
        int i = 5;
        int resultado = (i == 5) ? 100 : 0;
        System.out.println(resultado);

        // int resultado2 = (i == 5) ? "100" : 0; //NAO COMPILA
        System.out.println(i == 5 ? "100" : 0); //COMPILA, POIS O sout CONVERTE
    }
}