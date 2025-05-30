public class App {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.println("Pré-ordem:");
        arvore.imprimirPreOrdem(arvore.getRaiz());
        System.out.println();

        System.out.println("Em ordem:");
        arvore.imprimirEmOrdem(arvore.getRaiz());
        System.out.println();

        System.out.println("Pós-ordem:");
        arvore.imprimirPosOrdem(arvore.getRaiz());
        System.out.println();

        System.out.println("Por nível:");
        arvore.imprimirPorNivel();
        System.out.println();

        int totalComPilha = arvore.contarNosComPilha();
        System.out.println("Total de nós (pilha): " + totalComPilha);
        System.out.println();

        System.out.println("Total de nós folha: " + arvore.contarNosFolha(arvore.getRaiz()));
        System.out.println();

        System.out.println("Total de nós da árvore: " + arvore.contarNos(arvore.getRaiz())); // corrigido
    }
}
