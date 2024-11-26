public class Artista {
    private String nome;
    private Genero genero;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;

    }

    public Genero getGenero(){
        return genero;

    }

    public void setGenero(Genero genero){
        this.genero = genero;

    }

    @Override
    public String toString(){
        return "artista:  " + nome + " | Gênero:  " + (genero != null ? genero.getNome() : "Desconhecido");
    }

}