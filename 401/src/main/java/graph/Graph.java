package graph;

import stacksandqueues.Queue;

import java.security.InvalidParameterException;
import java.util.*;

public class Graph<T> {
    private List<Node<T>> nodes;

    //Creates a new Graph object with an empty ArrayList of Nodes
    public Graph() {
        this.nodes = new ArrayList<>();
    }

    //returns the ArrayList of Nodes for a graph
    public List<Node<T>> getNodes() {
        return nodes;
    }

    //Returns and integer representing how many Nodes are in the graph
    public int size() {
        return nodes.size();
    }

    //Takes in a value and adds a new Node with that value to the graph. Returns the new Node
    public Node<T> addNode(T value) {
        Node<T> n = new Node<>(value);
        this.nodes.add(n);
        return n;
    }

    //Takes in 2 nodes and adds an Edge to each one to create the relation that they are neighbors. The new Edges will have a weight of 0 with this method
    public void addEdge(Node<T> node1, Node<T> node2) throws NoSuchElementException, InvalidParameterException {
        if (this.nodes.contains(node1) && this.nodes.contains(node2)) {
            if(node1 == node2) {
                throw new InvalidParameterException("An edge must be added between two unique Nodes");
            } else {
                node1.neighbors.add(new Edge(node2));
                node2.neighbors.add(new Edge(node1));
            }
        } else {
            throw new NoSuchElementException("Could not find one of the provided Nodes in the graph");
        }
    }

    //Takes in 2 nodes and adds an Edge to each one to create the relation that they are neighbors. Also takes in a value for the weight of the Edges
    public void addEdge(Node<T> n1, Node<T> n2, int weight) throws NoSuchElementException {
        if (this.nodes.contains(n1) && this.nodes.contains(n2)) {
            if(n1 == n2) {
                throw new InvalidParameterException("An edge must be added between two unique Nodes");
            } else {
                n1.neighbors.add(new Edge(n2, weight));
                n2.neighbors.add(new Edge(n1, weight));
            }
        } else {
            throw new NoSuchElementException("Could not find one of the provided Nodes in the graph");
        }
    }

    //Takes in a Node and returns that Node's ArrayList of Edges that point to its neighbors
    public List<Edge<T>> getNeighbors(Node<T> node) {
        return node.neighbors;
    }

    public static List<Node<?>> breadthFirst(Node<?> root) {
        List<Node<?>> returnList = new ArrayList<>();
        Set<Node<?>> seen = new HashSet<>();
        Queue<Node<?>> q = new Queue<>();
        seen.add(root);
        q.enqueue(root);

        while(q.front != null) {
            Node<?> current = q.dequeue();
            returnList.add(current);
            for(Edge edge : current.neighbors) {
                if(!seen.contains(edge.neighbor)) {
                    q.enqueue(edge.neighbor);
                    seen.add(edge.neighbor);
                }
            }
        }
        return returnList;
    }
}
