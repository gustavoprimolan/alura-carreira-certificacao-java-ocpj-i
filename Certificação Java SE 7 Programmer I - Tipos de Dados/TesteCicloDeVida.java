class Carros{
    Carro c1;
    Carro c2;
}

class TestaCicloDeVida {

    public static void main(String[] args){
        Carros carros = new Carros();
        
        //O Carro é um objeto que esta na memória, c referencia
        Carro c = new Carro(); // CRIAR UM OBJETO PRECISA CHAMAR UM CONSTRUTOR
        c.ano = 2014;
        c.modelo = "Ferrari";
        carros.c1 = c;//NÃO PODE SER GARBAGE COLETADO
        c = new Carro(); //OUTRO CARRO TOTALMENTE DIFERENTE
        carros.c2 = c;
        c = null;

        if(15 > 10){
            Carro c2 = new Carro();
            c2.ano = 2010;
        }

        Carro c3;
        for(int i = 0; i < 10; i++){
            c3 = new Carro();
        }

    }

}