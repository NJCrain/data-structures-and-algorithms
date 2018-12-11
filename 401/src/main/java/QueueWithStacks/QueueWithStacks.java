package QueueWithStacks;

import stacksandqueues.Node;
import stacksandqueues.Stack;

public class QueueWithStacks<T> {
    public Stack<T> stack1 = new Stack<>();
    public Stack<T> stack2 = new Stack<>();
    public Node<T> front;
    public Node<T> rear;

    public QueueWithStacks() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T value) {
        T current = this.stack1.pop();

        while (current != null) {
            this.stack2.push(current);
            current = this.stack1.pop();
        }

        if (this.front == null) {
            this.stack1.push(value);
            this.front = this.stack1.top;
            this.rear = this.stack1.top;
        } else {
            this.stack1.push(value);
            this.rear = this.stack1.top;
            current = this.stack2.pop();
        }

        while (current != null) {
            this.stack1.push(current);
            current = this.stack2.pop();
        }
    }

    public T dequeue() {
        return this.stack1.pop();
    }

    public Node<T> peek() {
        return this.front;
    }
}
