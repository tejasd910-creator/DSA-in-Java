import java.util.*;
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }

        // Remove remaining digits from the end
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        // Build result and skip leading zeros
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;

        while (!stack.isEmpty()) {
            char ch = stack.pollFirst();

            if (leadingZero && ch == '0') {
                continue;
            }

            leadingZero = false;
            result.append(ch);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}