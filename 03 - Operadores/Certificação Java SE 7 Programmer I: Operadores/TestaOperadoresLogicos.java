class TestaOperadoresLogicos{

    public static boolean metodo(String msg){
        System.out.println(msg);
        return true;
    }

    public static void main(String[] args){
        //BITWISE OR BYTE BY BYTE
        System.out.println(1 == 1 & 1 > 2);
        System.out.println(1 == 1 | 1 > 2);
        System.out.println(1 == 1 ^ 1 > 2);
        System.out.println(!(1 == 1));


        //SHORT-CIRCUIT
        //NAO EXECUTA O LADO DA DIREITA SE O RESULTADO JÁ FOR DEFINIDO
        System.out.println(1 == 1 && 1 > 2);
        System.out.println(1 == 1 || 1 > 2);
        System.out.println(1 == 1 && metodo("primeiro")); //SÓ EXECUTA O MÉTODO SE O PRIMEIRO FOR VERDADEIRO
        System.out.println(1 == 1 || metodo("segundo")); //SÓ EXECUTA O MÉTODO SE O PRIMEIRO FOR FALSE
    }
}