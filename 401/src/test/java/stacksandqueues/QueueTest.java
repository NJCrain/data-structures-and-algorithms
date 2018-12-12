package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    Queue<Integer> test = new Queue<>();

    @Test
    public void testConstructor() {
        assertNotNull(test);
        assertNull(test.front);
        assertNull(test.rear);
    }

    @Test
    public void testEnqueue() {
        test.enqueue(1);

        assertEquals("The front should now point to this new Node", (Integer) 1, test.front.value);
        assertNull("The next of the new Node should be null", test.front.next);

        test.enqueue(2);

        assertEquals("The rear should now hold our new value", (Integer) 2, test.rear.value);
        assertEquals("The front should still hold the value of 1", (Integer) 1, test.front.value);
        assertNull("The rear Nodes next value should be null", test.rear.next);
        assertEquals("After adding two Nodes, front.next should point to the rear", test.rear, test.front.next);
    }

    @Test
    public void testDequeue() {
        test.enqueue(1);
        test.enqueue(2);

        assertEquals("Calling dequeue should give us the first value added", (Integer) 1, test.dequeue());
        assertEquals("The front should have now moved to the Node behind it", (Integer) 2, test.front.value);
        assertEquals("Dequeueing again should now give us the last value added", (Integer) 2, test.dequeue());
        assertNull("Dequeuing the empty queue should give back null (and a message)", test.dequeue());
    }

    @Test
    public void testPeek() {
        assertNull("Peeking an empty list should return null", test.peek());

        test.enqueue(1);

        assertEquals("Peeking should now give back the Node with value 1", (Integer) 1, test.peek().value);

        test.enqueue(2);

        assertEquals("Peeking should still give back the same Node", (Integer) 1, test.peek().value);
    }
}