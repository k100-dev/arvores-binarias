import java.util.Scanner;

public class MainRubroNegra {
    public static void main(String[] args) {
        ArvoreRubroNegra arvore = new ArvoreRubroNegra();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenuzin - Árvore Rubro-Negra");
            System.out.println("");
            System.out.println("1 - Inserir valor");
            System.out.println("2 - Remover valor");
            System.out.println("3 - Mostrar em ordem");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Valor para inserir: ");
                    String valIns = sc.nextLine();
                    arvore.inserir(valIns);
                    break;
                case 2:
                    System.out.print("Valor para remover: ");
                    String valRem = sc.nextLine();
                    arvore.remover(valRem);
                    break;
                case 3:
                    System.out.println("Organização - Em ordem:");
                    arvore.emOrdem();
                    break;
                case 0:
                    System.out.println("Saindo... Falou!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
