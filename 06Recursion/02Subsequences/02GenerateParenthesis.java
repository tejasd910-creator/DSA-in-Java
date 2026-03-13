import java.util.*;

class generateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int n) {

        // Base case
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add '(' if we still have some left
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add ')' only if it keeps the string valid
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }
}