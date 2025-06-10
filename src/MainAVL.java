public class MainAVL {
    public static void main(String[] args) {
        AVL avl = new AVL();

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
