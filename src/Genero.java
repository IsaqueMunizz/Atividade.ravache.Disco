public class Genero{
    private String nome;

    public  Genero(String nome){
        this.nome = nome;

    }

    public String getNome() {
      return nome;


    }

    public void setnome(String nome){
        this.nome = nome;


    }

    @Override
    public String toString(){
      return nome;

    }

}

