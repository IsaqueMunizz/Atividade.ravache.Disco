import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Gestão de Catálogo de Discos ===");
            System.out.println("1. Adicionar Disco");
            System.out.println("2. Adicionar Artista a Disco");
            System.out.println("3. Adicionar Gênero");
            System.out.println("4. Listar Discos");
            System.out.println("5. Listar Artistas");
            System.out.println("6. Listar Gêneros");
            System.out.println("7. Remover Disco");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título do Disco: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ano de Lançamento: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Faixas (separadas por vírgula): ");
                    String[] faixas = scanner.nextLine().split(",");
                    catalogo.adicionarDisco(new Disco(titulo, ano, Arrays.asList(faixas)));
                    break;
                case 2:
                    System.out.print("Nome do Artista: ");
                    String nomeArtista = scanner.nextLine();
                    System.out.print("Gênero do Artista (escolha um gênero ou digite um novo): ");
                    String generoNome = scanner.nextLine();
                    Genero genero = catalogo.getGeneros().stream()
                            .filter(g -> g.getNome().equalsIgnoreCase(generoNome))
                            .findFirst()
                            .orElse(new Genero(generoNome));
                    catalogo.adicionarGenero(genero); // Caso seja novo, adiciona ao catálogo
                    System.out.print("Título do Disco para associar: ");
                    String tituloDisco = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Nome do Gênero: ");
                    String nomeGenero = scanner.nextLine();
                    catalogo.adicionarGenero(new Genero(nomeGenero));
                    break;
                case 4:
                    catalogo.listarDiscos();
                    break;
                case 5:
                    catalogo.listarArtistas();
                    break;
                case 6:
                    catalogo.listarGeneros();
                    break;
                case 7:
                    System.out.print("Título do Disco para remover: ");
                    String discoRemover = scanner.nextLine();
                    catalogo.removerDisco(discoRemover);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
