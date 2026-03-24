import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        findSubsets(nums, nums.length, 0, ans, new ArrayList<>());

        return ans;
    }

    private void findSubsets(int[] nums, int n, int idx, List<List<Integer>> ans, List<Integer> ds){
        if(n == 0) return;
        if(idx == n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[idx]);
        findSubsets(nums, n, idx + 1, ans, ds);

        ds.remove(ds.size() - 1);
        findSubsets(nums, n, idx + 1, ans, ds);
    }
}