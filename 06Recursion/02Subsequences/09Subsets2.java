import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        findSubsets(nums, nums.length, 0, ans, new ArrayList<>());

        return ans;
    }

    private void findSubsets(int[] nums, int n, int idx, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));

        for (int i = idx; i < n; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;

            ds.add(nums[i]);
            findSubsets(nums, n, i + 1, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}