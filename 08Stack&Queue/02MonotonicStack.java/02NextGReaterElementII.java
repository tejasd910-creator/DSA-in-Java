import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] arr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;

        for (int i = n * 2 -1; i >= 0; i--) {
            int num = nums[i % n];

            while (!stack.isEmpty() && num >= stack.peek())
                stack.pop();

            if (i < n) {
                arr[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            
            stack.push(num);
        }

        

        return arr;
    }
}