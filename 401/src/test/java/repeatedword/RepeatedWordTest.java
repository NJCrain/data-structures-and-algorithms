package repeatedword;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static repeatedword.RepeatedWord.firstRepeat;

class RepeatedWordTest {

    @Test
    void testFirstRepeat() throws Exception {
        assertEquals("a", firstRepeat("Once upon a time, there was a ..."));
        assertEquals("a", firstRepeat("Once upon a time, there was a..."), "It should still work even with the punctuation");
        assertThrows(Exception.class,  () -> firstRepeat("No repeats here"), "Should throw an exception if no words are repeated");
    }

    @Test
    void testFirstRepeat_WeirdSentences() throws Exception {
        assertEquals("the", firstRepeat("the, the"));
        assertEquals("the", firstRepeat("the,the"));
        assertEquals("the", firstRepeat("the,otherword, the"));
        assertEquals("word", firstRepeat("word, how about a...random word ellipsis"));
    }
}