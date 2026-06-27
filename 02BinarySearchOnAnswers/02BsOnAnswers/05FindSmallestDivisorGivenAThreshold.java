class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for (int n : nums) {
            high = Math.max(high, n); // find max(nums)
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = 0;
            
            // Compute the sum using integer math (ceiling division)
            for (int n : nums) {
                sum += (n + mid - 1) / mid; 
                if (sum > threshold) break; // early stop optimization
            }

            if (sum <= threshold) {
                ans = mid;         // possible answer, try smaller divisor
                high = mid - 1;
            } else {
                low = mid + 1;     // divisor too small, increase it
            }
        }
        return ans;
    }
}