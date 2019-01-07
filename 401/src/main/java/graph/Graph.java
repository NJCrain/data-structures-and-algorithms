package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Graph<T> {
    private List<Node<T>> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public List<Node<T>> getNodes() {
        return nodes;
    }

    public int size() {
        return nodes.size();
    }

    public Node addNode(T value) {
        Node<T> n = new Node<>(value);
        this.nodes.add(n);
        return n;
    }

    public void addEdge(Node n1, Node n2) throws NoSuchElementException {
        if (this.nodes.contains(n1) && this.nodes.contains(n2)) {
            n1.neighbors.add(new Edge(n2));
            n2.neighbors.add(new Edge(n1));
        } else {
            throw new NoSuchElementException("Could not find one of the provided Nodes in the graph");
        }
    }

    public void addEdge(Node n1, Node n2, int weight) {
        if (this.nodes.contains(n1) && this.nodes.contains(n2)) {
            n1.neighbors.add(new Edge(n2, weight));
            n2.neighbors.add(new Edge(n1, weight));
        } else {
            throw new NoSuchElementException("Could not find one of the provided Nodes in the graph");
        }
    }
}
