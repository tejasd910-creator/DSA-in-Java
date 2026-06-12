class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Min must be in right half
                low = mid + 1;
            } else {
                // Min is in left half (including mid)
                high = mid;
            }
        }

        return nums[low];
    }
}