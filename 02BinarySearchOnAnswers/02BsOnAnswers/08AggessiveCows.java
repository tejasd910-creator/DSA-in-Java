import java.util.*;

class Solution {
    private boolean canPlace(int[] arr, int dist, int cows){
        int count = 1, last = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            if((arr[i] - last) >= dist){
                count++;
                last = arr[i];
            }
            
            if(count >= cows) return true;
        }
        
        return false;
    }
    
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1, high = stalls[n-1] - stalls[0];
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canPlace(stalls, mid, k)) 
              low = mid + 1;
            else 
              high = mid - 1;
        }
        
        return  high;
    }
}