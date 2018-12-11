package stacksandqueues;

public class Queue<T> {
    public Node<T> front;
    public Node<T> rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    //Takes in a value and adds a new Node to the end of the queue, with that value
    public void enqueue(T value) {
        if (rear == null) {
            rear = new Node<>(value, null);
            front = rear;
        } else {
            rear.next = new Node<>(value, null);
            rear = rear.next;
        }
    }

    //Removes the front node from the queue and returns its value. Will give a message and return 0 if the queue is empty
    public T dequeue() {
        if (front != null) {
            Node<T> temp = front;
            this.front = front.next;
            if (front == null) {
                rear = null;
            }
            return temp.value;
        }
        System.out.println("There is currently nothing in the queue");
        return null;
    }

    //Returns the front Node of the queue
    public Node<T> peek() {
        return front;
    }
}
