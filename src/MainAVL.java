import java.util.Scanner;

public class MainAVL {

    // Classe interna para representar os nós da árvore
    static class No {
        String valor;
        No esquerda, direita;
        int altura;

        public No(String valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }

    // Classe AVL
    static class ArvoreAVL {
        private No raiz;

        public No getRaiz() {
            return raiz;
        }

        public void inserir(String valor) {
            raiz = inserir(raiz, valor);
        }

        private No inserir(No no, String valor) {
            if (no == null) return new No(valor);

            if (valor.compareTo(no.valor) < 0) {
                no.esquerda = inserir(no.esquerda, valor);
            } else if (valor.compareTo(no.valor) > 0) {
                no.direita = inserir(no.direita, valor);
            } else {
                return no; // duplicado, ignora
            }

            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

            int balance = getBalance(no);

            // Casos de rotação
            if (balance > 1 && valor.compareTo(no.esquerda.valor) < 0)
                return rotacionarDireita(no);

            if (balance < -1 && valor.compareTo(no.direita.valor) > 0)
                return rotacionarEsquerda(no);

            if (balance > 1 && valor.compareTo(no.esquerda.valor) > 0) {
                no.esquerda = rotacionarEsquerda(no.esquerda);
                return rotacionarDireita(no);
            }

            if (balance < -1 && valor.compareTo(no.direita.valor) < 0) {
                no.direita = rotacionarDireita(no.direita);
                return rotacionarEsquerda(no);
            }

            return no;
        }

        private int altura(No no) {
            return (no == null) ? 0 : no.altura;
        }

        private int getBalance(No no) {
            return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
        }

        private No rotacionarDireita(No y) {
            No x = y.esquerda;
            No T2 = x.direita;

            x.direita = y;
            y.esquerda = T2;

            y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
            x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

            return x;
        }

        private No rotacionarEsquerda(No x) {
            No y = x.direita;
            No T2 = y.esquerda;

            y.esquerda = x;
            x.direita = T2;

            x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
            y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));

            return y;
        }

        public void imprimirEmOrdem(No no) {
            if (no != null) {
                imprimirEmOrdem(no.esquerda);
                System.out.print(no.valor + " ");
                imprimirEmOrdem(no.direita);
            }
        }

        public boolean buscar(String valor) {
            return buscar(raiz, valor);
        }

        private boolean buscar(No no, String valor) {
            if (no == null) return false;

            if (valor.equals(no.valor)) return true;
            if (valor.compareTo(no.valor) < 0) return buscar(no.esquerda, valor);
            else return buscar(no.direita, valor);
        }
    }

    // Método principal
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();
        Scanner scanner = new Scanner(System.in);

        // Inserindo alguns valores
        avl.inserir("M");
        avl.inserir("B");
        avl.inserir("Q");
        avl.inserir("A");
        avl.inserir("C");
        avl.inserir("Z");

        System.out.println("Árvore AVL criada com os seguintes elementos:");
        System.out.print("Em ordem (AVL): ");
        avl.imprimirEmOrdem(avl.getRaiz());
        System.out.println("\n");

        // Loop de busca
        while (true) {
            System.out.print("Digite um valor para buscar (ou 'sair' para encerrar): ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            boolean encontrado = avl.buscar(entrada);
            if (encontrado) {
                System.out.println("Encontrado: " + entrada + "\n");
            } else {
                System.out.println("Não encontrado: " + entrada + "\n");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
