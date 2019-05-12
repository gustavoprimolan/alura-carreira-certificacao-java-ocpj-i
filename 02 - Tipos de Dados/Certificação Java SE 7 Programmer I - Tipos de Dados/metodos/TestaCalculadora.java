package metodos;

class Calculadora{
    //VARARGS é um array, mas um array não é um varargs. Não seria a mesma coisa colocar um array como
    //parametro  
    public int soma(int... numeros){ //RECEBE NÚMERO VARIÁVEL DE ARGUMENTOS
        int soma = 0;
        for(int i = 0; i < numeros.length; i++){
            soma += numeros[i];
        }
        return soma;
    }
}

class TestaCalculadora{
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        System.out.println(c.soma(new int[]{3,5}));
        System.out.println(c.soma(3, 5, 10));
        System.out.println(c.soma(3, 5, 10, 20, 30, 40));
        System.out.println(c.soma(3, 5, 10, 20, 30, 40,10, 20, 30, 40));
        System.out.println(c.soma(3));

    }
}