public class BinaryTree {
    private Node root;

    public BinaryTree() {
        buildTree();
    }

    private void buildTree() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        root = a;
    }

    public Node getRoot() {
        return root;
    }

    public void printPreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.getValue() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    public void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        printInOrder(node.getRight());
    }

    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }
}
