package fzu.com.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {

    private final List<List<Integer>> res = new ArrayList<>();

    private void dfs(int[] candidates, int target, int sum, int start, List<Integer> list) {

        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target, sum + candidates[i], i, list);
            list.remove(list.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
}
