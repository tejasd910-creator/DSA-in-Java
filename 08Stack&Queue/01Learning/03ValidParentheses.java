import java.util.*;

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1)
            return false;

        Stack<Character> s1 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[')
                s1.push(c);
            else if (s1.isEmpty())
                return false;
            else if (c == ')' && s1.peek() == '(')
                s1.pop();
            else if (c == '}' && s1.peek() == '{')
                s1.pop();
            else if (c == ']' && s1.peek() == '[')
                s1.pop();
            else
                return false;
        }

        return s1.isEmpty();
    }

    public boolean isValid_Cleaner(String s) {
        Stack<Character> s1 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                s1.push(')');
            else if (c == '{')
                s1.push('}');
            else if (c == '[')
                s1.push(']');
            else {
                if (s1.isEmpty() || s1.pop() != c)
                    return false;
            }
        }

        return s1.isEmpty();
    }
}