package treeintersection;


import stacksandqueues.Stack;
import tree.BinaryTree;
import tree.Node;

import java.util.HashSet;
import java.util.Set;

public class TreeIntersection {
    public static Set findCommonValues(BinaryTree t1, BinaryTree t2) {
        Set t1values = new HashSet<>();
        Set duplicates = new HashSet<>();
        Node current = t1.root;
        Stack<Node> s = new Stack<>();

        while (current != null) {
            t1values.add(current.value);
            if (current.left != null) {
                s.push(current.left);
            }
            if (current.right != null) {
                s.push(current.right);
            }
            current = s.pop();
        }

        current  = t2.root;
        while (current != null) {
            if (t1values.contains(current.value)) {
                duplicates.add(current.value);
            }
            if (current.left != null) {
                s.push(current.left);
            }
            if (current.right != null) {
                s.push(current.right);
            }
            current = s.pop();
        }

        return duplicates;
    }
}
