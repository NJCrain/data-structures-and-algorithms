package graph;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
   public T value;
   public List<Edge> neighbors;

   public Node(T value) {
       this.value = value;
       this.neighbors = new ArrayList<>();
   }
}
