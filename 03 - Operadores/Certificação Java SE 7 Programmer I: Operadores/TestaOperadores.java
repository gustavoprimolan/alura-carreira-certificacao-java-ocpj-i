import java.util.ArrayList;
import java.util.List;

class TestaOperadores{

    public static void main(String[] args){
        
        ArrayList<String> lista = new ArrayList<>();
        //CLASSE PAI - MAIS GENÉRICA - MENOS ABRANGENTE PARA O MAIS ABRANGENTE
        List<String> lista2 = lista;

        int i = 15;

        // long idade = 15;
        long idade;
        idade = 15;

        //byte -> short -> int -> long
        // float -> double 
        //char -> só é positivo

        int a = 10;
        long b = 20;
        short c = 3;
        byte d = 4;
        
        //error: incompatible types: possible lossy conversion from long to int
        //a = b; //NÃO PODE, POIS LONG PODE SER QUE NÃO CAIBA NO INT

        double e = 30.0;
        float f = 40.3f;
        double g = 40.4f;

        f = a;
        f = b;

        //error: incompatible types: possible lossy conversion from long to int
        // char ca= -2;
    }

}