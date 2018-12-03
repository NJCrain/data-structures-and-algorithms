package linkedlists;

public class Node {
    public int value;
    public Node next;

    public void Node() {
        Node(0, null);
    }

    public void Node(int value) {
        this.value = value;
        this.next = null;
    }

    public void Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
