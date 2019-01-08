package graph;

public class Edge<T> {
   public Node<T> neighbor;
   public int weight;

   public Edge(Node<T> neighbor) {
       this.neighbor = neighbor;
       this.weight = 0;
   }

    public Edge(Node<T> neighbor, int weight) {
        this.neighbor = neighbor;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node:" + this.neighbor + " Edge Weight:" + this.weight;
    }
}
