import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        construirArvore();
    }

    private void construirArvore() {
        No noA = new No("A");
        No noB = new No("B");
        No noC = new No("C");
        No noD = new No("D");
        No noE = new No("E");
        No noF = new No("F");

        noA.setEsquerdo(noB);
        noA.setDireito(noC);
        noB.setEsquerdo(noD);
        noB.setDireito(noE);
        noC.setDireito(noF);

        this.raiz = noA;
    }

    public No getRaiz() {
        return raiz;
    }

    // Pré-ordem (recursiva)
    public void imprimirPreOrdem(No no) {
        if (no != null) {
            System.out.print(no.getValor() + " ");
            imprimirPreOrdem(no.getEsquerdo());
            imprimirPreOrdem(no.getDireito());
        }
    }

    // Em ordem (recursiva)
    public void imprimirEmOrdem(No no) {
        if (no != null) {
            imprimirEmOrdem(no.getEsquerdo());
            System.out.print(no.getValor() + " ");
            imprimirEmOrdem(no.getDireito());
        }
    }

    // Pós-ordem (recursiva)
    public void imprimirPosOrdem(No no) {
        if (no != null) {
            imprimirPosOrdem(no.getEsquerdo());
            imprimirPosOrdem(no.getDireito());
            System.out.print(no.getValor() + " ");
        }
    }

    // Nível (iterativa)
    public void imprimirPorNivel() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.getValor() + " ");

            if (atual.getEsquerdo() != null) fila.add(atual.getEsquerdo());
            if (atual.getDireito() != null) fila.add(atual.getDireito());
        }
    }

    // Contar todos os nós (recursiva)
    public int contarNos(No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.getEsquerdo()) + contarNos(no.getDireito());
    }

    // Contar todos os nós (iterativa com pilha)
    public int contarNosComPilha() {
        if (raiz == null) return 0;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        int contador = 0;

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            contador++;

            if (atual.getDireito() != null) pilha.push(atual.getDireito());
            if (atual.getEsquerdo() != null) pilha.push(atual.getEsquerdo());
        }

        return contador;
    }

    // Contar nós folha (recursiva)
    public int contarNosFolha(No no) {
        if (no == null) return 0;
        if (no.getEsquerdo() == null && no.getDireito() == null) return 1;
        return contarNosFolha(no.getEsquerdo()) + contarNosFolha(no.getDireito());
    }
}
