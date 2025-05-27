public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        System.out.println("Pré-ordem:");
        tree.printPreOrder(tree.getRoot());
        System.out.println();

        System.out.println("Em ordem:");
        tree.printInOrder(tree.getRoot());
        System.out.println();

        System.out.println("Pós-ordem:");
        tree.printPostOrder(tree.getRoot());
        System.out.println();

        System.out.println("Por nível:");
        tree.printLevelOrder();
        System.out.println();

        System.out.println("Total de nós folha: " + tree.countLeafNodes(tree.getRoot()));
        System.out.println();

        System.out.println("Total de nós da árvore: " + tree.countNodes(tree.getRoot()));
    }
}
