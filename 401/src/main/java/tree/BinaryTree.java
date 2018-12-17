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
        ArrayList<Node> nodes = new ArrayList<>();


    }

    public static void main(String[] args) {
        BinaryTree<Integer> test = new BinaryTree<>();
        test.root = new Node<Integer>(3);
        test.root.left = new Node<Integer>(2);
        test.root.left.left= new Node<Integer>(1);
        test.root.right= new Node<Integer>(4);

        for (Node node : preOrder(test.root)) {
            System.out.println(node.value);
        }
//        System.out.println(preOrder(test.root));
    }
}
