package fizzbuzztree;

import tree.BinaryTree;
import tree.Node;

public class FizzBuzzTree {
    public static BinaryTree<Object> fizzBuzzTree(BinaryTree<Object> t) {
        fizzBuzz(t.root);
        return t;
    }

    private static void fizzBuzz(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            fizzBuzz(root.left);
        }
        if (root.right != null) {
            fizzBuzz(root.right);
        }

        if ((int) root.value % 3 == 0) {
            if ((int) root.value % 5 == 0) {
                root.value = "fizzbuzz";
            } else {
                root.value = "fizz";
            }
        } else if ((int) root.value % 5 == 0) {
            root.value = "buzz";
        }
    }
}
