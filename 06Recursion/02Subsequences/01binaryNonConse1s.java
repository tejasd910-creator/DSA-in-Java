import java.util.*;

class Solution {
    int[] dp;

    int solve(int n){
        if(n == 1) return 2;
        if(n == 2) return 3;
        if(dp[n] != -1) return dp[n];

        return dp[n] = solve(n-1) + solve(n-2);
    }
    // Using array to store previous data time complexity O(n)
    public int countStringsI(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    // directly solving time complexity O(2^n)
    int countStrings(int n) {
        // code here
        if(n <= 0)
           return 1;
        if(n == 1)
           return 2;
        
        return countStrings(n - 1) + countStrings(n - 2);
    
    }
}
