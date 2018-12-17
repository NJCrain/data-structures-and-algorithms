package tree;

public class BinarySearchTree extends BinaryTree {

    public void add(int value) {
        if (this.root == null) {
            this.root = new Node<>(value);
        } else {
            addHelper(this.root, value);
        }
    }

    private void addHelper(Node<Integer> root, int value) {
        if (value > root.value) {
            if (root.right == null) {
                root.right = new Node<>(value);
            } else {
                addHelper(root.right, value);
            }
        }
        if (value < root.value){
            if (root.left == null) {
                root.left  = new Node<>(value);
            } else {
                addHelper(root.left, value);
            }
        }
    }

    public Node<Integer> search(int value) {
         return searchHelper(this.root, value);
    }

    private Node<Integer> searchHelper(Node<Integer> root, int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return root;
        }
        if (value > root.value) {
           return searchHelper(root.right, value);
        } else {
            return searchHelper(root.left, value);
        }
    }

}
