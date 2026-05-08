import java.util.*;

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        
        
        
        for(int i = 0; i < arr.length; i++) {
            ans.add(0);
        }
        
        
        for(int i = arr.length - 1; i >= 0; i--){
            int num = arr[i];
            
            while(!stack.isEmpty() && stack.peek() >= num)
                stack.pop();
                
            ans.set(i, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        
        return ans;
    }
}