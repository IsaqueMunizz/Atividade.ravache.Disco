import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Disco> discos = new ArrayList<>();
    private List<Artista> artistas = new ArrayList<>();
    private List<Genero> generos = new ArrayList<>();

    // Adicionar Gênero
    public void adicionarGenero(Genero genero) {
        if (generos.stream().noneMatch(g -> g.getNome().equalsIgnoreCase(genero.getNome()))) {
            generos.add(genero);
        }
    }

    // Listar Gêneros
    public void listarGeneros() {
        if (generos.isEmpty()) {
            System.out.println("Nenhum gênero disponível.");
        } else {
            System.out.println("=== Gêneros ===");
            generos.forEach(g -> System.out.println("- " + g.getNome()));
        }
    }

    // Adicionar Disco
    public void adicionarDisco(Disco disco) {
        discos.add(disco);
    }

    // Listar Discos
    public void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco disponível.");
        } else {
            System.out.println("=== Discos ===");
            discos.forEach(disco -> {
                System.out.println(disco);
                System.out.println("------------------");
            });
        }
    }

    // Remover Disco
    public void removerDisco(String titulo) {
        boolean removido = discos.removeIf(disco -> disco.getTitulo().equalsIgnoreCase(titulo));
        if (removido) {
            System.out.println("Disco removido com sucesso.");
        } else {
            System.out.println("Disco não encontrado.");
        }
    }

    // Editar Disco
    public void editarDisco(String titulo, String novoTitulo, Integer novoAno, List<String> novasFaixas) {
        Disco disco = discos.stream()
                .filter(d -> d.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
        if (disco != null) {
            if (novoTitulo != null && !novoTitulo.isEmpty()) {
                disco.setTitulo(novoTitulo);
            }
            if (novoAno != null) {
                disco.setAnoLancamento(novoAno);
            }

            System.out.println("Disco editado com sucesso.");
        } else {
            System.out.println("Disco não encontrado.");
        }
    }

    // Adicionar Artista a Disco
    public void adicionarArtista(Artista artista, String tituloDisco) {
        Disco disco = discos.stream()
                .filter(d -> d.getTitulo().equalsIgnoreCase(tituloDisco))
                .findFirst()
                .orElse(null);
        if (disco != null) {
            disco.setArtista(artista);
            if (artistas.stream().noneMatch(a -> a.getNome().equalsIgnoreCase(artista.getNome()))) {
                artistas.add(artista);
            }
        } else {
            System.out.println("Disco não encontrado.");
        }
    }

    // Listar Artistas
    public void listarArtistas() {
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista disponível.");
        } else {
            System.out.println("=== Artistas ===");
            artistas.forEach(System.out::println);
        }
    }

    // Editar Artista
    public void editarArtista(String nome, String novoNome, String novoGenero) {
        Artista artista = artistas.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
        if (artista != null) {
            if (novoNome != null && !novoNome.isEmpty()) {
                artista.setNome(novoNome);
            }
            if (novoGenero != null && !novoGenero.isEmpty()) {
                Genero genero = generos.stream()
                        .filter(g -> g.getNome().equalsIgnoreCase(novoGenero))
                        .findFirst()
                        .orElseGet(() -> {
                            Genero novo = new Genero(novoGenero);
                            generos.add(novo);
                            return novo;
                        });
                artista.setGenero(genero);
            }
            System.out.println("Artista editado com sucesso.");
        } else {
            System.out.println("Artista não encontrado.");
        }
    }

    // Métodos auxiliares para obter listas
    public List<Disco> getDiscos() {
        return discos;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public List<Genero> getGeneros() {
        return generos;
    }
}
