class Solution {
    public int removeDuplicates(int[] nums) {

        int low = 0, high = 0, count = 1;

        while (high < nums.length) {
            if (nums[low] != nums[high]) {
                nums[++low] = nums[high];
                count++;
            }
            high++;
        }
        return count;
    }
}