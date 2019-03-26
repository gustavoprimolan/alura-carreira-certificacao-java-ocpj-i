class Motor{

}

class Carro{
    int ano;
    char primeiraLetra;
    boolean usado;
    Motor motor;
    String marca;
}

public class Teste{

    public static void main(String[] args){
        // NÃO É POSSÍVEL COMPILAR UMA VARIÁVEL NAO INICIALIZADA
        //UMA VARIÁVEL LOCAL NAO TEM VALOR PADRÃO
        //PARA USAR UMA VARIÁVEL LOCAL EU PRECISO INICIALIZAR COM ALGUM VALOR
        // int idade;

        // int idade;
        // idade = 15;
        // int idade = 15;
        
        //NÃO É CERTEZA QUE A VARIÁVEL VAI ESTAR INICIALIZADA
        //NÃO COMPILA
        int idade;
        if(args.length > 10){
            idade = 15;
        } else {
            System.out.println("Faça uma outra coisa qualquer");
            idade = 0;
        }
        
        // System.out.println(idade);

        Carro carro = new Carro();
        //VARIÁVEL MEMBRO OU ATRIBUTO TEM VALOR PADRÃO
        System.out.println(carro.ano); //VALOR PADRÃO 0
        System.out.println(carro.primeiraLetra); //VALOR PADRÃO EM BRANCO - CARACTER 0
        System.out.println(carro.usado); //false
        System.out.println(carro.motor); // null
        System.out.println(carro.marca);// null


        //VALOR DE CADA INDICE É 0
        int[] valores = new int[10];
        System.out.println(valores[0]);
        boolean[] valorBoolean = new boolean[10];
        System.out.println(valorBoolean[0]);

        boolean valor = true;
        int x = 15;
        double v = 10.2d; //SE NÃO COLOCAR O d ele pega double automaticamente
        long l = 13L; //ou 13l;
        float f = 13.1F; //ou 13.1f
        
        //SEMPRE QUANDO TIVER 0 NA FRENTE ELE VAI PEGAR A BASE OCTAL
        //SE VOCE COLOCAR 08 NÃO IRÁ COMPILAR POIS O NÚMERO 0 NÃO EXISTE NA BASE OCTAL
        int i = 0123;

        //NÚMERO HEXADECINAL
        //DEPOIS DO x PODE VIR A,B,C,D,E,F
        int a = 0x12312;

        //BASE BINÁRIA
        //0 ou 1
        int b = 0b1;

        //EXISTE A NOTAÇÃO CIENTIFICA PARA OS NÚMEROS FLUTUANTES
        //3.1 vezes 10 elevado a 2 = 310
        double d2 = 3.1E2;
        float f2 = 2e3f;
        
        //A PARTIR DA VERSÃO 7 DO JAVA É POSSÍVEL ACRESCENTAR O UNDERLINE PARA SEPARAR OS NÚMEROS
        long x2 = 1_234_567_891_234l;


        //UNICODE - QUALQUER VALOR DO CARACTER UNICODE
        char un = '\u03A9';
        

    } 
}