class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        swap(0, n - 1, nums); // full reverse

        swap(0, k - 1, nums);  // first k reverse

        swap(k, n - 1, nums);  // k to nth element reverse
    }

    private void swap(int low, int high, int[] nums) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}