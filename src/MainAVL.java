import java.util.Scanner;

public class MainAVL {

    // Classe do nó da árvore
    static class No {
        String valor;
        No esquerda, direita;
        int altura;

        public No(String valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }

    // Classe da árvore AVL
    static class ArvoreAVL {
        private No raiz;

        public No getRaiz() {
            return raiz;
        }

        // Inserção na árvore com balanceamento AVL
        public void inserir(String valor) {
            raiz = inserirRec(raiz, valor);
        }

        private No inserirRec(No no, String valor) {
            if (no == null) return new No(valor);

            if (valor.compareTo(no.valor) < 0) {
                no.esquerda = inserirRec(no.esquerda, valor);
            } else if (valor.compareTo(no.valor) > 0) {
                no.direita = inserirRec(no.direita, valor);
            } else {
                return no; // valor duplicado
            }

            atualizarAltura(no);
            int balance = getBalance(no);

            // Casos de desbalanceamento e rotações
            if (balance > 1 && valor.compareTo(no.esquerda.valor) < 0) {
                return rotacaoDireita(no); // Caso esquerda-esquerda
            }
            if (balance < -1 && valor.compareTo(no.direita.valor) > 0) {
                return rotacaoEsquerda(no); // Caso direita-direita
            }
            if (balance > 1 && valor.compareTo(no.esquerda.valor) > 0) {
                no.esquerda = rotacaoEsquerda(no.esquerda); // Caso esquerda-direita
                return rotacaoDireita(no);
            }
            if (balance < -1 && valor.compareTo(no.direita.valor) < 0) {
                no.direita = rotacaoDireita(no.direita); // Caso direita-esquerda
                return rotacaoEsquerda(no);
            }

            return no;
        }

        private void atualizarAltura(No no) {
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        }

        private int altura(No no) {
            return (no == null) ? 0 : no.altura;
        }

        private int getBalance(No no) {
            return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
        }

        // Rotação simples à direita
        private No rotacaoDireita(No y) {
            No x = y.esquerda;
            No t2 = x.direita;

            x.direita = y;
            y.esquerda = t2;

            atualizarAltura(y);
            atualizarAltura(x);

            return x;
        }

        // Rotação simples à esquerda
        private No rotacaoEsquerda(No x) {
            No y = x.direita;
            No t2 = y.esquerda;

            y.esquerda = x;
            x.direita = t2;

            atualizarAltura(x);
            atualizarAltura(y);

            return y;
        }

        // Impressão em ordem
        public void imprimirEmOrdem(No no) {
            if (no != null) {
                imprimirEmOrdem(no.esquerda);
                System.out.print(no.valor + " ");
                imprimirEmOrdem(no.direita);
            }
        }

        // Busca por valor na árvore
        public boolean buscar(String valor) {
            return buscarRec(raiz, valor);
        }

        private boolean buscarRec(No no, String valor) {
            if (no == null) return false;
            if (valor.equals(no.valor)) return true;
            if (valor.compareTo(no.valor) < 0) return buscarRec(no.esquerda, valor);
            return buscarRec(no.direita, valor);
        }
    }

    // Execução principal
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();
        Scanner scanner = new Scanner(System.in);

        // Inserção inicial de dados
        avl.inserir("M");
        avl.inserir("B");
        avl.inserir("Q");
        avl.inserir("A");
        avl.inserir("C");
        avl.inserir("Z");
        avl.inserir("X");
        avl.inserir("L");
        

        System.out.println("Árvore AVL construída.");
        System.out.print("Em ordem (AVL): ");
        avl.imprimirEmOrdem(avl.getRaiz());
        System.out.println();

        // Loop de busca
        while (true) {
            System.out.print("Digite um valor para buscar (ou 'sair' para encerrar): ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            boolean encontrado = avl.buscar(entrada);
            if (encontrado) {
                System.out.println("Valor encontrado.");
            } else {
                System.out.println("Valor não encontrado.");
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}
