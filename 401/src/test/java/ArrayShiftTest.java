import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayShiftTest {

    @Test
    public void insertShiftArray() {
        int[] numbers = {1, 2, 3, 4};
        int[] numbersShifted = ArrayShift.insertShiftArray(numbers, 5);
        //length should be 1 more than numbers
        //should contain the value at middle index
        //some value before the middle should be at the same index in both arrays
        //some value after the middle should be at an index 1 greater
        assertTrue("The length should be 1 greater than the original array", numbersShifted.length == numbers.length + 1);
        assertEquals(5, numbersShifted[numbers.length/2]);
        assertEquals(numbers[0], numbersShifted[0]);
        assertEquals(numbers[3], numbersShifted[4]);
    }
}