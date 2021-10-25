package fzu.com.lc.traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {

    private static void dfs(int[] candidates, int target, int y,
                            List<List<Integer>> res, int sum, List<Integer> record) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(record));
            System.out.println(record);
        } else {
            for (int i = y; i < candidates.length; i++) {
                sum += candidates[i];
                record.add(candidates[i]);
                dfs(candidates, target, i, res, sum, record);
                record.remove(record.size() - 1);
                sum -= candidates[i];
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, res, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        combinationSum(nums, 7);
    }
}
