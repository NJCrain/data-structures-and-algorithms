package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    List<Node<T>> nodes;

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
}
