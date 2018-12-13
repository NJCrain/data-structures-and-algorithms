package multibracketvalidation;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiBracketValidationTest {

    @Test
    public void testMultiBracketValidationBasic() {
        assertTrue(MultiBracketValidation.multiBracketValidation("()[]{}"));
        assertTrue(MultiBracketValidation.multiBracketValidation("({}[]){}"));
        assertFalse(MultiBracketValidation.multiBracketValidation("([]}"));
        assertFalse(MultiBracketValidation.multiBracketValidation("([]{)}"));
        assertFalse(MultiBracketValidation.multiBracketValidation("([]"));
    }

    @Test
    public void testMultiBracketValidationWithOtherCharacters() {
        assertTrue(MultiBracketValidation.multiBracketValidation("(ok)[yup]{fine}"));
        assertTrue(MultiBracketValidation.multiBracketValidation("(ni{cool}[sure]ce){legit}"));
        assertFalse(MultiBracketValidation.multiBracketValidation("(not[ok]ok}"));
        assertFalse(MultiBracketValidation.multiBracketValidation("(what[are]{you)doing}"));
        assertFalse(MultiBracketValidation.multiBracketValidation("(where[is]the end?"));
    }
}