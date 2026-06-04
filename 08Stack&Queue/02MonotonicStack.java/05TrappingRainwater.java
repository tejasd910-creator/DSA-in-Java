import java.util.*;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // Water cannot be trapped with fewer than 3 bars
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // The left side is lower, so the leftMax determines the water level
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                // The right side is lower/equal, so rightMax determines the level
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    public int trapStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {

                int bottom = stack.pop();

                // No left boundary
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();

                int width = i - left - 1;

                int boundedHeight =
                        Math.min(height[left], height[i]) - height[bottom];

                water += width * boundedHeight;
            }

            stack.push(i);
        }

        return water;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Total Water Trapped: " + sol.trap(input)); // Output: 6
    }
}
