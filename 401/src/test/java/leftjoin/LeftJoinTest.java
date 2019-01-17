package leftjoin;

import hashtable.Hashtable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        for (String[] set : results) {
            System.out.println(Arrays.toString(set));
        }
    }
}