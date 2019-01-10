package depthfirst;

import graph.Edge;
import graph.Graph;
import graph.Node;
import stacksandqueues.Stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirst {

    //Takes in a graph and returns a List of all the Nodes in the graph in depth-first pre-order
    public static List<Node> depthFirst(Graph g) {
        Node current =  (Node) g.getNodes().get(0);
        List<Node> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Set<Node> seen = new HashSet<>();

        s.push(current);
        seen.add(current);

        while (s.peek() != null) {
            current = s.pop();
            ans.add(current);
            for (Edge e : (List<Edge>) current.neighbors) {
                if (!seen.contains(e.neighbor)) {
                    seen.add(e.neighbor);
                    s.push(e.neighbor);
                }
            }
        }

        return ans;
    }
}
