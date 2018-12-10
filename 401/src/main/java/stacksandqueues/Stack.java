package stacksandqueues;

public class Stack {
    public Node top;

    public Stack() {
        this.top = null;
    }

    //takes in a value and adds a new Node to the top of the stack with that value
    public void push(int value) {
        this.top = new Node(value, top);
    }

    //Will remove the top Node from the stack and return its value. Gives a message and returns 0 for an empty stack
    public int pop() {
        if (top != null) {
            Node temp = top;
            top = top.next;
            return temp.value;
        }
        System.out.println("Can not pop, the stack is currently empty");
        return 0;
    }

    //returns the top node of the stack
    public Node peek() {
        return top;
    }
}
