public class BinaryTree {
    private Node root;

    public BinaryTree() {
        buildTree();
    }

    private void buildTree() {
        // Criando os nós
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        // Montando a estrutura da árvore
        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);

        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);

        nodeC.setRight(nodeF); // lado esquerdo de C permanece vazio (null)

        this.root = nodeA;
    }

    public Node getRoot() {
        return root;
    }

    // Impressão pré-ordem
    public void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    // Método para contar nós
    public int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }
}
