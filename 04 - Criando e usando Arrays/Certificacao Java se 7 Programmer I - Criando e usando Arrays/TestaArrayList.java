import java.util.ArrayList;

public class TestaArrayList {
    public static void main(String[] args){
        ArrayList nomes = new ArrayList();
        // ArrayList<String> nomes = new ArrayList<>();

        nomes.add("java");
        nomes.add("ruby");
        nomes.add("java");

        System.out.println(nomes.contains("java"));
        System.out.println(nomes.contains("c#"));

        boolean removido = nomes.remove("java");


        System.out.println(removido);
        System.out.println(nomes.contains("java"));

        System.out.println(nomes.contains("java"));
    

    }

}