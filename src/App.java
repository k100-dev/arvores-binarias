public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        System.out.println("Pré-ordem da árvore:");
        tree.printPreOrder(tree.getRoot());
        System.out.println();

        System.out.println("Em ordem da árvore:");
        tree.printInOrder(tree.getRoot());
        System.out.println();

        System.out.println("Total de nós da árvore: " + tree.countNodes(tree.getRoot()));
    }
}
