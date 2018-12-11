package stacksandqueues;

public class Node<T> {
    public T value;
    public Node next;

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}
