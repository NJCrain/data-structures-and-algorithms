package tree;

import java.util.ArrayList;

public class BinaryTree<T> {
    public Node<T> root;

    public BinaryTree() {
        this.root = null;
        ArrayList<Node> nodes = new ArrayList<>();
    }

    public static ArrayList<Node> preOrder(Node root) {
        return preOrderHelper(new ArrayList<>(), root);
    }

    private static ArrayList<Node> preOrderHelper(ArrayList<Node> ordered, Node root) {
        ordered.add(root);
        if (root.left != null) {
            preOrderHelper(ordered, root.left);
        }
        if (root.right != null) {
            preOrderHelper(ordered, root.right);
        }

        return ordered;
    }

    public static ArrayList<Node> inOrder(Node root) {
        return inOrderHelper(new ArrayList<>(), root);
    }

    private static ArrayList<Node> inOrderHelper(ArrayList<Node> ordered, Node root) {
        if (root.left != null) {
            inOrderHelper(ordered, root.left);
        }
        ordered.add(root);
        if (root.right != null) {
            inOrderHelper(ordered, root.right);
        }

        return ordered;
    }

    public static ArrayList<Node> postOrder(Node root) {
        return postOrderHelper(new ArrayList<>(), root);
    }

    private static ArrayList<Node> postOrderHelper(ArrayList<Node> ordered, Node root) {
        if (root.left != null) {
            postOrderHelper(ordered, root.left);
        }
        if (root.right != null) {
            postOrderHelper(ordered, root.right);
        }
        ordered.add(root);

        return ordered;
    }


        public static void main(String[] args) {
        BinaryTree<Character> test = new BinaryTree<>();
        test.root = new Node<>('A');
        test.root.left = new Node<>('B');
        test.root.left.left= new Node<>('D');
        test.root.left.right= new Node<>('E');
        test.root.right = new Node<>('C');
        test.root.right.left = new Node<>('F');

        for (Node node : postOrder(test.root)) {
            System.out.println(node.value);
        }
//        System.out.println(preOrder(test.root));
    }
}
