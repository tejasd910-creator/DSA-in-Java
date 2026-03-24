import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        findSum(k, n, 1, new ArrayList<>(), ans);

        return ans;
    }

    private void findSum(int k, int n, int num, List<Integer> ds, List<List<Integer>> ans) {
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (k < 0 || n < 0)
            return;

        for (int i = num; i <= 9; i++) {
            if (i > n)
                break;

            ds.add(i);
            findSum(k - 1, n - i, i + 1, ds, ans);

            ds.remove(ds.size() - 1);
        }
    }
}