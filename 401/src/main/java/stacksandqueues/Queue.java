package stacksandqueues;

public class Queue {
    public Node front;
    public Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int value) {
        if (rear == null) {
            rear = new Node(value, null);
            front = rear;
        } else {
            rear.next = new Node(value, null);
            rear = rear.next;
        }
    }

    public int dequeue() {
        if (front != null) {
            Node temp = front;
            this.front = front.next;
            return temp.value;
        }
        System.out.println("There is currently nothing in the queue");
        return 0;
    }

    public Node peek() {
        return front;
    }
}
