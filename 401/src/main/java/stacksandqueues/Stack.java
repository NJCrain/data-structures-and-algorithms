package stacksandqueues;

public class Stack<T> {
    public Node<T> top;

    public Stack() {
        this.top = null;
    }


    //takes in a value and adds a new Node to the top of the stack with that value
    public void push(T value) {
        this.top = new Node<>(value, top);
    }

    //Will remove the top Node from the stack and return its value. Gives a message and returns 0 for an empty stack
    public T pop() {
        if (top != null) {
            Node<T> temp = top;
            top = top.next;
            return temp.value;
        }
        return null;
    }

    //returns the top node of the stack
    public Node peek() {
        return top;
    }
}
