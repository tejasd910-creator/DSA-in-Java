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

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Total Water Trapped: " + sol.trap(input)); // Output: 6
    }
}
