import java.util.*;

class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        if(!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);
            insert(st, temp);
        }
    }
    
    public static void insert(Stack<Integer> stack, int temp){
        if(stack.isEmpty() || stack.peek() <= temp){
            stack.push(temp);
            return;
        }
        
        //if top greater than temp again pop()
        int val = stack.pop();
        insert(stack, temp);
        
        //push the poped element
        stack.push(val);
    }
}