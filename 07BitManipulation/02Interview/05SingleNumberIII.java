class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find rightmost set bit
        int diff = xor & (-xor);

        // Step 3: Split into two groups
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}