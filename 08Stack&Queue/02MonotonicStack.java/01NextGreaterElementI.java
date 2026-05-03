import java.util.*;

class Solution {
    public int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {
        
        for(int i = 0; i < nums1.length; i++){
            boolean flag = false;
            int cur = nums1[i];
            for(int j = 0; j < nums2.length; j++){
                if(cur == nums2[j]) flag = true;

                if(cur < nums2[j] && flag){
                    nums1[i] = nums2[j];
                    break;
                }

                else nums1[i] = -1;
            }
        }

        return nums1;
    }

    public int[] nextGreaterElementOptimized(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }

            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

}