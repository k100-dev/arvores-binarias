public class MainAVL {
    public static void main(String[] args) {
        AVL avl = new AVL();

        // Inserções que causam rotações e balanceamento
        avl.inserir("C");
        avl.inserir("J");
        avl.inserir("A"); // rotação simples à direita
        avl.inserir("X");
        avl.inserir("D"); // rotação dupla esquerda-direita
        avl.inserir("F"); // rotação simples à esquerda
        avl.inserir("Z"); // pode provocar outra rotação

        System.out.println("Árvore AVL construída.");
        System.out.print("Em ordem (AVL): ");
        avl.imprimirEmOrdem();
    }
}

class No {
    String valor;
    int altura;
    No esquerda;
    No direita;

    No(String valor) {
        this.valor = valor;
        this.altura = 1;
    }
}

class AVL {
    private No raiz;

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
            return no; // valor duplicado, não insere
        }

        atualizarAltura(no);
        return balancear(no);
    }

    private void atualizarAltura(No no) {
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

    private int altura(No no) {
        return no == null ? 0 : no.altura;
    }

    private int fatorBalanceamento(No no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private No balancear(No no) {
        int fb = fatorBalanceamento(no);

        if (fb > 1) {
            if (fatorBalanceamento(no.esquerda) < 0) {
                no.esquerda = rotacionarEsquerda(no.esquerda); // rotação dupla esquerda-direita
            }
            return rotacionarDireita(no); // rotação simples à direita
        }

        if (fb < -1) {
            if (fatorBalanceamento(no.direita) > 0) {
                no.direita = rotacionarDireita(no.direita); // rotação dupla direita-esquerda
            }
            return rotacionarEsquerda(no); // rotação simples à esquerda
        }

        return no; // já balanceado
    }

    private No rotacionarDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private No rotacionarEsquerda(No y) {
        No x = y.direita;
        No T2 = x.esquerda;

        x.esquerda = y;
        y.direita = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
        System.out.println();
    }

    private void imprimirEmOrdem(No no) {
        if (no != null) {
            imprimirEmOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdem(no.direita);
        }
    }
}
