class Cliente {
    String nome;
    public Cliente(String nome){
        this.nome = nome;
    }


    //ASSINATURA NAO PODE MUDAR
    //public boolean equals(Object o) -> recebe Object -> para sobreescrever tem que ser igualzinha se nao vai criar uma nova
    public boolean equals(Object o){
        Cliente outro = (Cliente) o;
        return this.nome.equals(outro.nome);
    }
}

class TestaComparacaoEquals {
    public static void main(String[] args){
        //O OPERADOR == TESTA SE DUAS VARIÁVEIS ESTAO APONTANDO PARA O MESMO OBJETO

        Cliente c1 = new Cliente("Gustavo");
        Cliente c2 = new Cliente("Jose");

        Cliente c3 = new Cliente("Jose");

        //OBJETOS DIFERENTES
        System.out.println(c1 == c2); //== MOSTRA SE ESTAO APONTANDO PARA A MESMA REFERENCIA
        System.out.println(c1 == c1);
        System.out.println(c2 == c3);

        //O EQUALS COMO PADRAO IRÁ COMPARAR OS DOIS OBJETOS COM ==
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c1));
        System.out.println(c2.equals(c3));

    }
}