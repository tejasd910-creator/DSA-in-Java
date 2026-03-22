import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combination = new ArrayList<>();

        backtracking(candidates, target, new ArrayList<>(), 0, 0, combination);

        return combination;
    }

    private void backtracking(int[] candidates, int target, List<Integer> list, int sum, int idx,
            List<List<Integer>> combination) {
        if (sum == target) {
            combination.add(new ArrayList<>(list));
            return;

        }
        if (sum > target || idx == candidates.length) {
            return;
        }

        list.add(candidates[idx]);
        backtracking(candidates, target, list, sum + candidates[idx], idx, combination);

        list.removeLast();
        backtracking(candidates, target, list, sum, idx + 1, combination);
    }
}