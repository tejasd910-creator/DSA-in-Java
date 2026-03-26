import java.util.*;

class Solution {
    static String[] keyword = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        pattern(digits, ans, "", 0);

        return ans;
    }

    private void pattern(String digits, List<String> ans, String combination, int idx) {

        if (idx == digits.length()) {
            ans.add(combination);
            return;
        }

        char num = digits.charAt(idx);
        String str = keyword[(num - '0') - 2];

        for (int i = 0; i < str.length(); i++) {

            pattern(digits, ans, combination + str.charAt(i), idx + 1);

        }
    }
}