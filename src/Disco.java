import java.util.List;

    public class Disco {
        private String titulo;
        private int anoLancamento;
        private List<String> faixas;
        private Artista artista;

        public Disco(String titulo, int anoLancamento, List<String> faixa){
          this.titulo = titulo;
          this.anoLancamento = anoLancamento;
          this.faixas = faixas;

        }

        public String getTitulo(){
            return titulo;

        }

        public void setTitulo(String titulo){
            this.titulo = titulo;

        }

        public int getAnoLancamento(){
            return anoLancamento;

        }

        public void setAnoLancamento(int anoLancamento){
            this.anoLancamento = anoLancamento;

        }

        public List<String> getFaixas(){
            return faixas;

        }

        public void setArtista(Artista artista){
            this.artista = artista;

        }

        @Override
        public String toString() {
            return "Disco: " + titulo + " (" + anoLancamento + ")" +
            "\nArtista: " + (artista  !=null ? artista.getNome() : "Desconhecido") +
              "\nFaixas: " + faixas;
        }
    }



