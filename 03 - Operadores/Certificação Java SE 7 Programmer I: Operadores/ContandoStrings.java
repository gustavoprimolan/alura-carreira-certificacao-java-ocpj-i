public class ContandoStrings{
    public static void main(String[] args){
        String h = new String("hello ");//2 Strings quando é utilizado os literais - 2 OBJETOS SENDO CRIADOS
        String h1 = "hello "; // NENHUM OBJETO CRIADO AQUI E FAZ REFERENCIA EM UM OBJETO JÁ EXISTENTE
        String w = "world"; // 1 - POOL DE STRING - STRING LITERAL

        System.out.println("hello "); // 0 - NENHUM OBJETO CRIADO
        System.out.println(h1 + "world"); // 1 - OBJETO POR CONTA DA CONCATENACAO - NAO NO POOL DE STRING
        System.out.println("Hello " == h1);// 1 - OBJETO CRIADO NO POOL POR CONTA DO H MAIUSCULO
    }   
}