import java.util.*;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> leader = new ArrayList<>();
        
        int i = arr.length-1;
        int ctr = arr[i];
        
        while(i>=0){
            if(arr[i]>=ctr){
                ctr = arr[i];
                leader.add(ctr);
            }
            i--;
        }
        
        Collections.reverse(leader);
        
        return leader;
    }
}