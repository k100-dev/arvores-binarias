import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        buildTree();
    }

    private void buildTree() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);
        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);
        nodeC.setRight(nodeF);

        this.root = nodeA;
    }

    public Node getRoot() {
        return root;
    }

    // Pré-ordem (recursiva)
    public void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    /* 
    // Pré-ordem (iterativa)
    public void printPreOrderIterative() {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.getValue() + " ");

            if (current.getRight() != null) stack.push(current.getRight());
            if (current.getLeft() != null) stack.push(current.getLeft());
        }
    }
    */

    // Em ordem (recursiva)
    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrder(node.getRight());
        }
    }

    /* 
    //Em ordem (iterativa)
    public void printInOrderIterative() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            System.out.print(current.getValue() + " ");
            current = current.getRight();
        }
    }
    */

    // Pós-ordem (recursiva)
    public void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    /* 
    // Pós-ordem (iterativa)
    public void printPostOrderIterative() {
        if (root == null) return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.getLeft() != null) stack1.push(current.getLeft());
            if (current.getRight() != null) stack1.push(current.getRight());
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getValue() + " ");
        }
    }
    */

    // Nível (iterativa - única forma prática)
    public void printLevelOrder() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.getValue() + " ");

            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }
    }

    // Contar todos os nós (recursiva)
    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

    // Contar nós folha (recursiva)
    public int countLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        return countLeafNodes(node.getLeft()) + countLeafNodes(node.getRight());
    }

    /*
    // Contar nós folha (iterativa)
    public int countLeafNodesIterative() {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.getLeft() == null && current.getRight() == null) {
                count++;
            }

            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }

        return count;
    }
    */
}
