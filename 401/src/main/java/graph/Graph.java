package graph;

import java.security.InvalidParameterException;
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

    public Node<T> addNode(T value) {
        Node<T> n = new Node<>(value);
        this.nodes.add(n);
        return n;
    }

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

    public List<Edge> getNeighbors(Node node) {
        return node.neighbors;
    }
}
