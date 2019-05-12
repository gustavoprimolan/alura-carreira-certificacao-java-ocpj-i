class TestaStringBufferEBuilder{

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("Caelum"); //MUTÁVEL - CONTEÚDO QUE ESTÁ LA DENTRO PODE MUDAR DE VALOR
        sb.append(" - ");
        sb.append("Ensino e Inovação");
        System.out.println(sb.toString());

        StringBuffer sb2 = new StringBuffer(50); //BUFFER / ARRAY DE TAMANHO 50
        System.out.println(sb2.toString());


        StringBuffer sb3 = new StringBuffer(sb);
        sb3.append(" e Alura e Casa do Código");
        System.out.println(sb3.toString());

        //STRING BUILDER
        StringBuilder sd = new StringBuilder("Caelum"); //MUTÁVEL - CONTEÚDO QUE ESTÁ LA DENTRO PODE MUDAR DE VALOR
        sd.append(" - ");
        sd.append("Ensino e Inovação");
        System.out.println(sd.toString());

        StringBuilder sd2 = new StringBuilder(50); //BUFFER / ARRAY DE TAMANHO 50
        System.out.println(sd2.toString());


        StringBuilder sd3 = new StringBuilder(sd);
        sd3.append(" e Alura e Casa do Código");
        sd3.append('x'); //RECEBE APENAS 1 CARACTER
        sd3.append(sd);
        sd3.append(new Carro()); //VAI CHAMAR O toString()
        sd3.append("Depois do carro");
        System.out.println(sd3.toString());

        StringBuilder sd4 = new StringBuilder("Caelum - Inovação");
        sd4.insert(9, "Ensino e "); //POSIÇÃO ONDE ELE VAI INSERIR E O TEXTO ONDE ELE IRÁ INSERIR
        System.out.println(sd4.toString());
        sd4.delete(6, 15);
        System.out.println(sd4);

        String valor = sd4.toString();
        
        System.out.println(new StringBuffer("Gustavo").reverse());

        StringBuilder sd5 = new StringBuilder("Caelum - Ensino e Inovação");
        System.out.println(sd5.substring(6, 15)); //NÃO ALTERA O StringBuffer
        System.out.println(sd5.subSequence(6, 15)); //NÃO ALTERA O StringBuffer
        System.out.println(sd5);

    }
}