class TestaIncrementos {
    public static void main(String[] args){
        int i = 5;
        // i--;
        System.out.println(i--); //PÓS DECREMENTO - PRIMEIRO USA DEPOIS SUBTRAI
        System.out.println(i++); //PÓS INCREMENTO
        System.out.println(--i);// PRÉ DECREMENTO - PRIMEIRO SUBTRAI, DEPOIS USA;
        System.out.println(i++);

        i += 2;
        i -= 2;
        i /= 10;
        i *= 5;
        i %= 3;
        System.out.println(i);

        byte b = 15;
        b += 200; //ELE CONVERTE AUTOMATICAMENTE (AUTO CASTING)
        System.out.println(b);

        int a = 10;

        a += ++a + a + ++a;
        // a = a ++a + a + ++a;
        // a = 10 ++a + a ++a;
        // a = 10 + 11 + 11 + ++a;
        // a = 10 + 11 + 11 + 12; //44

        System.out.println(a);
    }
}