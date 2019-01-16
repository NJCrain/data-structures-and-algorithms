package treeintersection;


import stacksandqueues.Stack;
import tree.BinaryTree;
import tree.Node;

import java.util.HashSet;
import java.util.Set;

public class TreeIntersection {

    //Takes in two BinaryTrees and returns a set of any common values between the two trees.
    public static Set findCommonValues(BinaryTree t1, BinaryTree t2) {
        //Variable setup to perform the search
        Set t1values = new HashSet<>();
        Set duplicates = new HashSet<>();
        Node current = t1.root;
        Stack<Node> s = new Stack<>();

        //Traverse the first tree, add each value in the tree to t1Values set
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

        //Traverse the 2nd tree, checking each value to see if it is in t1Values and adding it to duplicates set if it is
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
