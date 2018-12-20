package tree;

import stacksandqueues.Queue;

import java.util.ArrayList;

public class BinaryTree<T> {
    public Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    //Takes in a root Node, and utilizing a helper method will return an ArrayList of all the Nodes in the tree, traversed by a depth first pre-order
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

    //Takes in a root Node, and utilizing a helper method will return an ArrayList of all the Nodes in the tree, traversed by a depth first in-order
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

    //Takes in a root Node, and utilizing a helper method will return an ArrayList of all the Nodes in the tree, traversed by a depth first post-order
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

    //Takes in a tree, and using a queue for help, traverses the tree breadth first, printing out the value of nodes in that order
    public static void breadthTraversal(BinaryTree t) {
        if (t.root ==null) {
            return;
        }

        Queue<Node> q = new Queue<>();
        q.enqueue(t.root);

        while (q.front != null) {
            Node front = q.dequeue();
            if (front.left != null) {
                q.enqueue(front.left);
            }
            if (front.right != null) {
                q.enqueue(front.right);
            }
            System.out.println(front.value);
        }
    }

    //Takes in a tree of Integer values and returns the highest value in the tree. Returns 0 if the tree is empty
    public static int findMaximumValue(BinaryTree<Integer> t) {
        if (t.root == null) {
            return 0;
        }
        return findMaximumValueHelper(t.root);
    }

    //Helper function to traverse the tree recursively in post order to return the highest value compared to a nodes value, and its highest left and right values
    private static int findMaximumValueHelper(Node<Integer> root) {
        int highestLeft = root.value;
        int highestRight = root.value;
        if (root.left == null && root.right == null) {
            return root.value;
        }
        if (root.left != null) {
            highestLeft = findMaximumValueHelper(root.left);
        }
        if (root.right != null) {
            highestRight = findMaximumValueHelper(root.right);
        }
        if (root.value >= highestLeft && root.value >= highestRight) {
            return root.value;
        } else if (highestLeft > highestRight) {
            return highestLeft;
        } else {
            return highestRight;
        }
    }

}
