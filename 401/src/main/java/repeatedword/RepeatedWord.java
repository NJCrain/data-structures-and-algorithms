package repeatedword;

import java.util.HashSet;
import java.util.Set;

public class RepeatedWord {

    //TODO: Make this handle more cases of punctuation
    //Takes in a string, and will return the first repeated word in the string.
    //Accomplished without using any extra library methods in Java aside from a HashSet to track seen words.
    public static String firstRepeat(String s) throws Exception {
        Set<String> words = new HashSet<>();
        int lastChar = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || s.charAt(i) == '.' || s.charAt(i) == ',') {
                if (s.charAt(i - 1) != '.' && s.charAt(i - 1) != ',') {
                    String word = s.substring(lastChar, i);
                    lastChar = i + 1;
                    if (words.contains(word.toLowerCase())) {
                        return word;
                    } else {
                        words.add(word.toLowerCase());
                    }
                }
                else {
                    lastChar++;
                }
            }

        }
        if (words.contains(s.substring(lastChar).toLowerCase())) {
            return s.substring(lastChar);
        } else {
            throw new Exception("No repeating words found");
        }
    }
}
