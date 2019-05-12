class Pessoa {
    static int id = 1;
}

class Bla{
    static int a;

}

//EXEMPLO SHADOWING
class X {
    int a = 10;
    //QUER SEJA UMA VARÍAVEL LOCAL OU UMA VARIÁVEL PARAMETRO
    public void metodo(){
        int a = 20;
        System.out.println(a);
    }
}

public class Teste{
    
    String nome = "Gustavo";

    public void m1(){
        int x = 10;
        if(x >= 10){
            int y = 50;
            System.out.println(y);
        }

        //System.out.println(y); //ELA MORRE NO BLOCO DO IF - OCORRE UM ERRO
        System.out.println(x);
    }

    public void m2(){
        for(int i=0, j=0; i<=10; i++) j++;
        // System.out.println(j); //NEM A VARIÁVEL I NEM A VARIÁVEL J EXISTEM FORA DO FOR
        // System.out.println(i);
    }

    public void m3(String nome){
        System.out.println(nome);
    }
    
    public void m4(){
        System.out.println(this.nome);    
    }

    public static void main(String[] args){
        Teste t = new Teste();
        // t.m1();
        // t.m2();
        //t.m3("Gustavo");
        // t.m4(); //NAO EXISTE O NOME DENTRO DO MÉTODO
        
        Pessoa p = new Pessoa();
        System.out.println(p.id);
        System.out.println(Pessoa.id);
    }
}