package multibracketvalidation;

import stacksandqueues.Stack;

public class MultiBracketValidation {
    public boolean multiBracketValidation(String s) {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                brackets.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                char toExpect = ' ';
                switch (brackets.pop()) {
                    case '(': toExpect = ')';
                              break;
                    case '[': toExpect = ']';
                              break;
                    case '{': toExpect = '}';
                              break;
                }

                if (toExpect != s.charAt(i)) {
                    return false;
                }
            }
        }

        if (brackets.pop() != null) {
            return false;
        }
        return true;
    }
}
