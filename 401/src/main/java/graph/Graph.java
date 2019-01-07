package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public int size() {
        return nodes.size();
    }
}
