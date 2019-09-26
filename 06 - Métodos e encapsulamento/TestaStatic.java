class Moto {
    //VARIÁVEL DA CLASSE E NAO DA INSTANCIA
    // private static int totalDeMotos = 0;
    public static int totalDeMotos = 0;
    //EXISTE NA CLASSE E NAO DA INSTANCIA
    public static int getTotalDeMotos(){
        return Moto.totalDeMotos;
    }
}

class TestaStatic {
    public static void main(String[] args){
        Moto.totalDeMotos = 15;
        System.out.println(Moto.getTotalDeMotos());

        // Moto m = new Moto();
        // System.out.println(m.getTotalDeMotos());
    }
}