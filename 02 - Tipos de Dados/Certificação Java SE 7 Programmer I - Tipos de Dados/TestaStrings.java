class TestaStrings{

    public static void main(String[] args){

        String texto = "Pretendo fazer a prova de certificação de Java";


        //ENCONTRA A PRIMEIRA POSIÇÃO QUE ENCONTRA A PALAVRA OU LETRA
        System.out.println(texto.indexOf("Pretendo")); //QUANDO ENCONTRA A PALAVRA ELE DEVOLVE 0
        System.out.println(texto.indexOf("Pretendia")); //QUANDO NÃO ENCONTRA A PALAVRA ELE DEVOLVE -1

        System.out.println(texto.lastIndexOf("a")); // CONTA DE TRÁS PARA FRENTE
        System.out.println(texto.lastIndexOf("Pretendia")); // -1

        System.out.println(text.indexOf("e", 7)); //CARACTER e QUE APARECE APARTIR DA POSIÇÃO 7

        System.out.println(text.startsWith("Pretendo")); // TRUE
        System.out.println(text.startsWith("Pretendia")); //FALSE 
        System.out.println(text.endsWith("Java")); // TERMINA COM - TRUE

        System.out.println("Certificado".compareTo("Arnaldo")); //POSITIVO - VEM ANTES
        System.out.println("Certificado".compareTo("Certificado")); //0 - IGUAL
        System.out.println("Certificado".compareTo("Grecia")); // NEGATIVO - DEPOIS
        System.out.println("Certificado".compareTo("certificado")); // UMA LETRA MAIÚSCULA VEM ANTES DE UMA LETRA MINÚSCULA
        System.out.println("Certificado".compareToIgnoreCase("certificado")); // NEGATIVO - DEPOIS

        //MÉTODO CHAIN
        String parseado = "      quero tirar um certificado oficial de java    ".trim().toUpperCase();

        System.out.println(parseado);

        //STRING É IMUTÁVEL
        String s = "caelum";
        s.toUpperCase();
        System.out.println(s); //IMPRIME MINÚSCULO

        s = s.toUpperCase(); //O s APONTA PARA OUTRA REFERENCIA
        System.out.println(s);
        
        System.out.println(s.charAt(0)); // POSIÇÃO
        //System.out.println(s.charAt(200)); //Exception
        System.out.println(s.length());
        System.out.println(s.isEmpty());

        System.out.println("    joao     ".trim()); // TIRA ESPAÇOS DA DIREITA E DA ESQUERDA
        System.out.println(s.replace("A","B"));
        
        String nomeDireto = "Java";
        String nomeIndireto = new String("Java");

        char[] nome = new char[]{'J', 'a', 'v', 'a'};
        String nome1 = new String(nome);

        StringBuilder sb1 = new StringBuilder("Java");
        String nome2 = sb1.toString();


        String nomeNulo = null;

        String nomeDaProva = "Certificação" + " " + "Java";
        String nomeDaProvaComNulo = nomeDaProva + " " + nomeNulo;
        System.out.println(nomeDaProva);
        System.out.println(nomeDaProvaComNulo);
        //System.out.println(nomeNulo.toString());


        System.out.println("Certificação " + 1500);
        System.out.println(15 + (00 + " Certificação"));
        System.out.println(1 + (500 + " Certificação"));

    }
}