package metodos;

class TestaPessoa{
    public static void main(String[] args){
        Pessoa p = new Pessoa();
        p.setNome("Gustavo"
        ,
         15); //QUEBRAS DE LINHAS SÃO ACEITAVEIS

        String nome = p.getNome();

        System.out.println(nome);
        System.out.println(p.getNome());
        p.getNome(); //NÃO NECESSARIAMENTE PRECISO UTILIZAR O RETORNO DO MÉTODO
    }
}