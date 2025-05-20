public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        System.out.println("Pré-ordem da árvore:");
        tree.printPreOrder(tree.getRoot()); 

        int totalNos = tree.countNodes(tree.getRoot());
        System.out.println("\nTotal de nós da árvore: " + totalNos); 
    }
}
