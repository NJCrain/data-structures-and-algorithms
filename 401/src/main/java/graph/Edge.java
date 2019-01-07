package graph;

public class Edge {
   public Node neighbor;
   public int weight;

   public Edge(Node neighbor) {
       this.neighbor = neighbor;
       this.weight = 0;
   }

    public Edge(Node neighbor, int weight) {
        this.neighbor = neighbor;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node:" + this.neighbor + " Edge Weight:" + this.weight;
    }
}
