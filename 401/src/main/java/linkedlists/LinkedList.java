package linkedlists;

public class LinkedList {

    public Node head;

    //Instantiation creates an empty list with a head value of null
    public LinkedList() {
        this.head = null;
    }

    //takes in a value for a new Node and inserts it at the head of the list
    public void insert(int value) {
        this.head = new Node(value, head);
    }

    //Traverses the list to find a given value, will return true if a node in the list contains that value
    public boolean includes(int value) {
        Node current = this.head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return  false;
    }

    //Prints all values in the LinkedList between < > as a comma separated list
    public void print() {
        String printString = "<";
        Node current = this.head;
        while (current != null) {
            if (current.next == null) {
                printString = printString + current.value;
            }
            else {
                printString = printString + current.value + ", ";
            }
            current = current.next;
        }
        System.out.println(printString + ">");
    }

    //Will add a new node to the list right before the Node with the value that is passed in
    public void addBefore(int value, int before) {
        Node current = this.head;

        if(before == current.value) {
            insert(value);
            return;
        }

        while (current.next != null) {
            if (current.next.value == before) {
                current.next = new Node(value, current.next);
                break;
            }
            current = current.next;
        }
    }

    //Will add a new Node to the list right after the Node with the value passed in
    public void addAfter(int value, int after) {

        Node current = this.head;

        while (current != null) {
            if (current.value == after) {
                current.next = new Node(value, current.next);
                break;
            }
            current = current.next;
        }
    }
}
