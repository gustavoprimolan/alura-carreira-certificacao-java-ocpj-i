class Param {
    void primitivo(double a){
        return;
        // System.out.println("Nunca vai ser executado, compilador percebe")
    }

    void referencia(Object o){

    }

    void teste(final int a, int b){
        b = 10;
        //a=5;
    }
}

class ClasseComMetodos {

    int getNumero(){
        return 5;
    }

}

class TestaMetodos{
    public static void main(String[] args) {
        Param p = new para();
        int a = 1;
        p.primitivo('Z'); //CHAR PODE SER DOUBLE PQ É UM NÚEMRO
        p.referencia(new Object());
        p.referencia("guilherme");

    }
}