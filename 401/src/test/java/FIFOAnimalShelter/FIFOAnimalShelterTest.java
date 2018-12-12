package FIFOAnimalShelter;

import org.junit.Test;

import static org.junit.Assert.*;

public class FIFOAnimalShelterTest {
    FIFOAnimalShelter test = new FIFOAnimalShelter();

    @Test
    public void testEnqueueCats() {
        test.enqueue(new Cat("cat", 3, "Orange", true));
        test.enqueue(new Cat("kat", 1, "Black", false));
        test.enqueue(new Cat("kitty", 6, "Striped", true));

        assertEquals("The front of catQueue should be the first cat added", "cat", test.catQueue.front.value.name);
        assertEquals("The rear of catQueue should be the last cat added", "kitty", test.catQueue.rear.value.name);
        assertEquals("The next from the front should be the 2nd cat added", "kat", test.catQueue.front.next.value.name);
        assertNull(test.catQueue.rear.next);
    }

    @Test
    public void testEnqueueDogs() {
        test.enqueue(new Dog("dog", 3, "Brown", true));
        test.enqueue(new Dog("doge", 1, "Spotted", true));
        test.enqueue(new Dog("dawg", 6, "Striped", false));

        assertEquals("The front of dogQueue should be the first dog added", "dog", test.dogQueue.front.value.name);
        assertEquals("The rear of dogQueue should be the last dog added", "dawg", test.dogQueue.rear.value.name);
        assertEquals("The next from the front should be the 2nd dog added", "doge", test.dogQueue.front.next.value.name);
        assertNull(test.dogQueue.rear.next);
    }

    @Test
    public void testEnqueueBoth() {
        test.enqueue(new Dog("dog", 3, "Brown", true));
        test.enqueue(new Dog("doge", 1, "Spotted", true));
        test.enqueue(new Cat("cat", 6, "Striped", false));

        assertEquals("dogQueue front should match the first dog we added", "dog", test.dogQueue.front.value.name);
        assertNull("The value after dogQueue's rear should be null", test.dogQueue.rear.next);

        assertEquals("catQueue front and rear should point to the same cat", test.catQueue.front, test.catQueue.rear);
        assertNull(test.catQueue.rear.next);
    }

    @Test
    public void testDequeueCat() {
        test.enqueue(new Cat("cat", 3, "Orange", true));
        test.enqueue(new Cat("kat", 1, "Black", false));
        test.enqueue(new Cat("kitty", 6, "Striped", true));

        assertEquals("Calling dequeue should give back the first cat we added", "cat", test.dequeue("cat").name);
        assertEquals("Calling it again should give back the 2nd cat added", "kat", test.dequeue("cat").name);
        assertEquals("There should only be one item left in catQueue now", test.catQueue.front, test.catQueue.rear);
    }

    @Test
    public void testDequeueDog() {
        test.enqueue(new Dog("dog", 3, "Brown", true));
        test.enqueue(new Dog("doge", 1, "Spotted", true));
        test.enqueue(new Dog("dawg", 6, "Striped", false));

        assertEquals("Calling dequeue should give back the first dog we added", "dog", test.dequeue("dog").name);
        assertEquals("Calling it again should give back the 2nd cat added", "doge", test.dequeue("dog").name);
        assertEquals("There should only be one item left in catQueue now", test.dogQueue.front, test.dogQueue.rear);
    }

    @Test
    public void testDequeueBoth() {
        test.enqueue(new Dog("dog", 3, "Brown", true));
        test.enqueue(new Dog("doge", 1, "Spotted", true));
        test.enqueue(new Cat("cat", 6, "Striped", false));

        assertEquals("Calling dequeue should give back the first dog we added", "dog", test.dequeue("dog").name);
        assertEquals("Calling it again should give back the 2nd cat added", "cat", test.dequeue("cat").name);
    }

    @Test
    public void testDequeueNull() {
        assertNull("asking for something other than a cat or dog should return null", test.dequeue("horse"));
    }
}