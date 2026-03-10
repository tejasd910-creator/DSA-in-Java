import java.util.*;

class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(!st.isEmpty()){
            int temp = st.pop();
            reverseStack(st);
            insert(st, temp);
        }
    }
    
    public static void insert(Stack<Integer> stack, int temp){
        //insert element when stack is empty
        if(stack.isEmpty()){
            stack.push(temp);
            return;
        }
        
        //removing top till stack is empty
        int val = stack.pop();
        insert(stack, temp);
        
        //pushing the last top back
        stack.push(val);
    }
}