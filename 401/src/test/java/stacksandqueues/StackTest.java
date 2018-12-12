package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    Stack<Integer> test = new Stack<>();

    @Test
    public void testConstructor() {
        assertNotNull("Should give back an object", test);
        assertNull("The top should be null by default", test.top);
    }

    @Test
    public void testPush() {
        test.push(5);

        assertEquals("The top should now point to the new node", (Integer) 5, test.top.value);
        assertNull("The new Node's next should be null", test.top.next);

        test.push(4);

        assertEquals("top should now point to the newer node", (Integer) 4, test.top.value);
        assertEquals("The next node should be the one we added previously",(Integer) 5, test.top.next.value);
    }

    @Test
    public void testPop() {
        assertNull("Popping an empty list should give back null", test.pop());

        test.push(5);
        test.push(4);

        assertEquals("The first pop should give back the last value added", (Integer) 4, test.pop());
        assertEquals("Calling pop again should return the value added before 4", (Integer) 5, test.pop());
    }

    @Test
    public void testPeek() {
        assertNull("Peeking an empty list should give null back", test.peek());

        test.push(4);

        assertEquals("Peeking should now give us the Node we just pushed", 4, test.peek().value);

        test.push(5);

        assertEquals("Adding another Node should still be fine", 5, test.peek().value);
    }
}