package repeatedword;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static repeatedword.RepeatedWord.firstRepeat;

class RepeatedWordTest {

    @Test
    void testFirstRepeat() throws Exception {
        assertEquals("a", firstRepeat("Once upon a time, there was a ..."));
    }
}