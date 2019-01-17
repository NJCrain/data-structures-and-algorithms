package leftjoin;

import hashtable.Hashtable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static leftjoin.LeftJoin.leftJoin;
import static org.junit.jupiter.api.Assertions.*;

class LeftJoinTest {

    Hashtable<String, String> table1;
    Hashtable<String, String> table2;

    @BeforeEach
    public void setup() {
        table1  = new Hashtable<>(8);
        table2  = new Hashtable<>(8);

        table1.add("fond", "enamored");
        table1.add("wrath", "angered");
        table1.add("outfit", "garb");

        table2.add("fond", "averse");
        table2.add("wrath", "delight");
    }

    @Test
    void testLeftJoin() {

        String[][] results = leftJoin(table1, table2);
        String[][] expected = new String[][]{{"fond", "enamored", "averse"}, {"wrath", "angered", "delight"}, {"outfit", "garb", null}};
        assertEquals(table1.getKeys().size(), results.length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], results[i][j]);
            }
        }
    }

    @Test
    void testLeftJoin_NoMatches() {
        Hashtable<String, String> table3 = new Hashtable<>(8);
        table3.add("pond", "ocean");
        table3.add("stuff", "things");

        String[][] results = leftJoin(table1, table3);
        String[][] expected = new String[][]{{"fond", "enamored", null}, {"wrath", "angered", null}, {"outfit", "garb", null}};
        assertEquals(table1.getKeys().size(), results.length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], results[i][j]);
            }
        }
    }

    @Test
    void testLeftJoin_EmptyTable() {
        Hashtable<String, String> table3 = new Hashtable<>(8);

        String[][] results = leftJoin(table1, table3);
        String[][] expected = new String[][]{{"fond", "enamored", null}, {"wrath", "angered", null}, {"outfit", "garb", null}};
        assertEquals(table1.getKeys().size(), results.length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], results[i][j]);
            }
        }
    }

    @Test
    void testLeftJoin_BothTablesEmpty() {
        Hashtable<String, String> table3 = new Hashtable<>(8);
        Hashtable<String, String> table4 = new Hashtable<>(8);

        String[][] results = leftJoin(table4, table3);
        assertEquals(0, results.length);
    }
}