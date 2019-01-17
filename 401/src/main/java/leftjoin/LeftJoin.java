package leftjoin;

import hashtable.Hashtable;

import java.util.List;

public class LeftJoin {

    //Takes in two Hashtables and performs a left join on them. Returns the result of that left join in a 2d array
    //TODO: Make this work for any table, not just tables of String keys and values
    public static String[][] leftJoin(Hashtable<String, String> ht1, Hashtable<String, String> ht2) {
        List<String> keys = ht1.getKeys();
        String[][] joined = new String[keys.size()][3];

        for (int i = 0; i < keys.size(); i ++) {
            String key = keys.get(i);
            joined[i][0] = key;
            joined[i][1] = ht1.find(key);
            if (ht2.contains(key)) {
                joined[i][2] = ht2.find(key);
            } else {
                joined[i][2] = null;

            }
        }
        return joined;
    }
}
