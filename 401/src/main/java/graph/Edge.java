package graph;

public class Edge {
   public Node neighbor;
   public int weight;

   public Edge(Node neighbor) {
       new Edge(neighbor, 0);
   }

    public Edge(Node neighbor, int weight) {
        this.neighbor = neighbor;
        this.weight = weight;
    }
}
