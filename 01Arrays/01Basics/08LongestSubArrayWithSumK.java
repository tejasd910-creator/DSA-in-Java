// User function Template for Java
import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int sum = 0;
        int maxLen = 0;
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }
            
            int remSum = sum - k;
            if(map.containsKey(remSum)){
                int len = i - map.get(remSum);
                maxLen = Math.max(maxLen, len);
            }
            
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        
        return maxLen;
    }
}