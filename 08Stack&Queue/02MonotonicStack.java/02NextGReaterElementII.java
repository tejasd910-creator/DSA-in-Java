import java.util.*;

class NextGreaterElement2 {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse array twice for circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {

            int current = nums[i % n];

            // Remove smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // Fill answer only for first pass
            if (i < n) {
                if (!stack.isEmpty()) {
                    result[i] = stack.peek();
                }
            }

            // Push current element
            stack.push(current);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        int[] ans = nextGreaterElements(nums);

        System.out.println(Arrays.toString(ans));
    }
}