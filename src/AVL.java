public class AVL {
    private No raiz;

    public void inserir(String valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, String valor) {
        if (no == null) return new No(valor);

        if (valor.compareTo(no.getValor()) < 0) {
            no.setEsquerdo(inserir(no.getEsquerdo(), valor));
        } else if (valor.compareTo(no.getValor()) > 0) {
            no.setDireito(inserir(no.getDireito(), valor));
        } else {
            return no; // valor duplicado, não insere
        }

        atualizarAltura(no);
        return balancear(no);
    }

    private void atualizarAltura(No no) {
        no.setAltura(1 + Math.max(altura(no.getEsquerdo()), altura(no.getDireito())));
    }

    private int altura(No no) {
        return no == null ? 0 : no.getAltura();
    }

    private int fatorBalanceamento(No no) {
        return no == null ? 0 : altura(no.getEsquerdo()) - altura(no.getDireito());
    }

    private No balancear(No no) {
        int fb = fatorBalanceamento(no);

        if (fb > 1) {
            if (fatorBalanceamento(no.getEsquerdo()) < 0) {
                no.setEsquerdo(rotacionarEsquerda(no.getEsquerdo())); // rotação dupla esquerda-direita
            }
            return rotacionarDireita(no); // rotação simples à direita
        }

        if (fb < -1) {
            if (fatorBalanceamento(no.getDireito()) > 0) {
                no.setDireito(rotacionarDireita(no.getDireito())); // rotação dupla direita-esquerda
            }
            return rotacionarEsquerda(no); // rotação simples à esquerda
        }

        return no; // já balanceado
    }

    private No rotacionarDireita(No y) {
        No x = y.getEsquerdo();
        No T2 = x.getDireito();

        x.setDireito(y);
        y.setEsquerdo(T2);

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private No rotacionarEsquerda(No y) {
        No x = y.getDireito();
        No T2 = x.getEsquerdo();

        x.setEsquerdo(y);
        y.setDireito(T2);

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
            imprimirEmOrdem(no.getEsquerdo());
            System.out.print(no.getValor() + " ");
            imprimirEmOrdem(no.getDireito());
        }
    }
}
