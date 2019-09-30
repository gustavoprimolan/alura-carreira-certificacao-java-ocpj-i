class Overloader {
    public void metodo() {
        System.out.println("Sem nada");
    }
    //ISSO NAO É SOBRECARGA APENAS A QUANTIDADE DE PARAMETROS E TIPO DELES REPRESENTAM A SOBRECARGA
    // public int metodo() {
        // return 1;
    // }

    //PERMITIDO
    public void metodo(int a){
        System.out.println("Com int");
    }

    //SEMPRE VAI CHAMAR A MAIS ESPECIFICA E DEPOIS A GENÉRICA
}

class TestaOverload {
    public static void main(String[] args){
        new Overloader().metodo(); //SEM NAD
        new Overloader().metodo(324); // COM INT
    }
}