class TestaCasting {
    public static void main(String[] args){
        double d = 15.3;
        // int i = d; //NAO COMPILA
        // System.out.println(i); 

        int i = (int) d; // CASTING - VAI PERDER VALOR
        System.out.pritnln(i);  //15

        long l = 1515151515151l;
        int i2 = (int) l; //NUMERO VAI ESTOURAR E NAO SERÁ POSSÍVEL SABER O QUE HOUVE
        System.out.println(i2);
    }
}