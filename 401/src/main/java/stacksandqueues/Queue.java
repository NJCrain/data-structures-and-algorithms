package stacksandqueues;

public class Queue {
    public Node front;
    public Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    //Takes in a value and adds a new Node to the end of the queue, with that value
    public void enqueue(int value) {
        if (rear == null) {
            rear = new Node(value, null);
            front = rear;
        } else {
            rear.next = new Node(value, null);
            rear = rear.next;
        }
    }

    //Removes the front node from the queue and returns its value. Will give a message and return 0 if the queue is empty
    public int dequeue() {
        if (front != null) {
            Node temp = front;
            this.front = front.next;
            return temp.value;
        }
        System.out.println("There is currently nothing in the queue");
        return 0;
    }

    //Returns the front Node of the queue
    public Node peek() {
        return front;
    }
}
