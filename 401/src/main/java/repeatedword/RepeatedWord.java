package repeatedword;

import java.util.HashSet;
import java.util.Set;

public class RepeatedWord {

    //TODO: Make this handle cases where the first repeated word has punctuation at the end of it
    public static String firstRepeat(String s) throws Exception {
        Set<String> words = new HashSet<>();
        int lastChar = 0;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ') {
                String word = s.substring(lastChar, i);
                lastChar = i + 1;
                if (words.contains(word.toLowerCase())) {
                    return word;
                } else {
                    words.add(word.toLowerCase());
                }
            }

        throw new Exception("No repeating words found");
    }
}
