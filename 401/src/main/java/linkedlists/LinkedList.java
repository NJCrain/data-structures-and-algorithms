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
}
