class PalindromePartitioning {

    // Function to check if substring is palindrome
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Recursive function
    static int solve(String s, int start) {
        int n = s.length();

        // Base case
        if (start == n) {
            return -1; // important trick
        }

        int minCuts = Integer.MAX_VALUE;

        for (int end = start; end < n; end++) {
            if (isPalindrome(s, start, end)) {
                int cuts = 1 + solve(s, end + 1);
                minCuts = Math.min(minCuts, cuts);
            }
        }

        return minCuts;
    }

    // Main function
    public static int minCut(String s) {
        return solve(s, 0);
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s)); // Output: 1
    }
}