class TestaAritimetica{

    public static void main(String[] args){
        int dois = 2;
        int dez = 10;

        int doze = dez + dois;
        int oito = dez - dois;
        int vinte = dez * dois;
        int cinco = dez / dois;
        int restoDaDivisaoDeCincoPorDois = 5 % 2; // 1 - MOD

        //SERÁ DEVOLVIDO SEMPRE O MAIOR TIPO. EX: SE TEM UM INT E UM LONG SOMANDO, SERÁ DEVOLVIDO UM LONG
        //SE É FEITO UMA OPERAÇÃO ARITIMETICA COM BYTE, O MINÍMO QUE ELA DEVOLVE É UM INT

        byte doisByte = 2;
        byte dezByte = 10;

        int dozeComByte = doisByte + dezByte; //VAI DEVOLVER UM INT

        //error: incompatible types: possible lossy conversion from int to byte  
        // byte dozeByte = doisByte + dezByte; //NÃO PODE, POIS VAI DEVOLVER UM INT

        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        // int divisao1 = 5 / 0;

        double divisao2 = 5 / 0.0; //EXISTE - PODE, PONTO FLUTUANTE PODE FAZER A DIVISÃO POR 0
        System.out.println(divisao2); //NÚMERO QUE VAI DAR AQUI É INFINITO


        double positivoInfinito = 5.0 / 0;
        double negativoInfinito = -5.0 / 0;

        System.out.println(positivoInfinito + negativoInfinito); //NaN - Not a Number

    }

}