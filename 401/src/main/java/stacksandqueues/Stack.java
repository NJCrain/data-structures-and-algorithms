package stacksandqueues;

public class Stack {
    public Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int value) {
        this.top = new Node(value, top);
    }

    public int pop() {
        if (top != null) {
            Node temp = top;
            top = top.next;
            return temp.value;
        }
        System.out.println("Can not pop, the stack is currently empty");
        return 0;
    }

    public Node peek() {
        return top;
    }
}
