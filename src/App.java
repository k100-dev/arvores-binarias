public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("Pré-ordem da árvore:");
        tree.printPreOrder(tree.root);  // Saída esperada: A B D E C F
    }
}
