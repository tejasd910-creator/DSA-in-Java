// User function Template for Java

class Solution {
    public static boolean checkSubsequenceSumI(int N, int[] arr, int K) {
        // code here
        return(subSequence(N,arr,K,0,0));
    }
    
    //RECURSION
    public static boolean subSequence(int n, int[] arr, int k, int idx, int sum){
        if(idx == n){
            if(sum == k)
              return true;
            return false;
        }
        
        if(subSequence(n, arr, k, idx + 1, sum + arr[idx]))
          return true;
        
        
        if(subSequence(n, arr, k, idx + 1, sum))
          return true; 
          
        return false;
    }

    //DP
    public static boolean checkSubsequenceSumII(int N, int[] arr, int K) {
        boolean[] dp = new boolean[K + 1];
        dp[0] = true; // sum 0 is always possible
        
        for(int i = 0; i < N; i++){
            for(int j = K; j >= arr[i]; j--){
                if(dp[j - arr[i]]){
                    dp[j] = true;
                }
            }
        }
        
        return dp[K];
    }
}
