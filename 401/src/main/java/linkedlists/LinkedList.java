package linkedlists;

public class LinkedList {

    public Node head;

    //Instantiation creates an empty list with a head value of null
    public LinkedList() {
        this.head = null;
    }

    public static Node mergeLists(LinkedList l1, LinkedList l2) {
        Node current = l1.head;
        Node insert = l2.head;
        int counter  = 0;

        while(current != null && insert != null) {
            if (counter % 2 == 0) {
                l1.insertAfter(current.value, insert.value);
                insert = insert.next;
            }
            current = current.next;
            counter++;
        }
        if (current == null && insert != null) {
            while (insert != null) {
                l1.append(insert.value);
                insert = insert.next;
            }
        }
        return l1.head;
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

    //Will add a new node at the end of the linked list
    public void append(int value) {
        Node current = this.head;
        while (current != null) {
            if (current.next == null) {
                current.next = new Node(value, null);
                break;
            }
            current = current.next;
        }
    }

    //Will add a new node to the list right before the Node with the value that is passed in, if a node includes that value
    public void insertBefore(int value, int newVal) {
        if (!includes(value)) {
            return;
        }
        Node current = this.head;

        if(value == current.value) {
            insert(newVal);
            return;
        }

        while (current.next != null) {
            if (current.next.value == value) {
                current.next = new Node(newVal, current.next);
                break;
            }
            current = current.next;
        }
    }

    //Will add a new Node to the list right after the Node with the value passed in
    public void insertAfter(int value, int newVal) {
        if (!includes(value)) {
            return;
        }

        Node current = this.head;

        while (current != null) {
            if (current.value == value) {
                current.next = new Node(newVal, current.next);
                break;
            }
            current = current.next;
        }
    }

    //Takes in an int k, and returns the value of the node k distance from the last node in the list
    public int findKFromEnd(int k) throws IndexOutOfBoundsException {
        Node current = this.head;

        while (current !=null) {
            Node kAway = current;
            for (int i = 0; i < k; i++) {
                if(kAway.next == null && i != k-1) {
                    throw new IndexOutOfBoundsException("Value entered is greater than total linked list length");
                }
                kAway = kAway.next;
            }
            if (kAway.next == null) {
                return current.value;
            }
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Value entered is greater than total linked list length");
    }
}
