public class TestaArray2 {
    public static void main(String[] args){
        
        //OS ARRAYS DECLARAM O ARRAY COM OS VALORES PADRAO - PARA OBJETOS É null
        Cliente[] clientes = new Cliente[10];

        //NullPointerException 
        // System.out.println(clientes[0].nome);

        for(int i = 0; i < clientes.length; i++){
            clientes[i] = new Cliente();
            clientes[i].nome = "Gustavo";
        }

        for(Cliente c: clientes){
            System.out.println(c.nome);
        }

        //FUNCIONA NORMALMENTE
        Cliente clientes2[] = new Cliente[5];
        clientes2[0] = new Cliente();
        clientes2[1] = new ClienteEspecial();


        Cliente gustavo = new Cliente();
        gustavo.nome = "Gustavo";

        clientes2[0] = gustavo;

        System.out.println(gustavo.nome);
        System.out.println(clientes2[0].nome);

        //NAO É POSSÍVEL FAZER ESSE CAST
        // int[] valores = new int[10];
        // long numeros[] = valores;
        //NAO FUNCIONA, NAO É POSSÍVEL CONVERTER - PARA TIPOS PRIMITIVOS
        // long numeros[] = (long) valores;


        String[] nomes = {"Gustavo", "Primolan"};
        Object[] objetos;

        //FUNCIONA, POIS É REFERENCIA
        //É POSSÍVEL VER OS VALORES SEM PROBLEMA
        objetos = nomes;


    }
}

class Cliente {
    String nome;
}

class ClienteEspecial extends Cliente{

}