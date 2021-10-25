package fzu.com.lc.traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {

    private static void dfs(int[] candidates, int target, int y, boolean[] visited,
                     List<List<Integer>> res, int sum, List<Integer> record) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(record));
            System.out.println(record);
        } else {
           for (int i = y; i < candidates.length; i++) {
               if (!visited[i]) {
                   if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) continue;
                   visited[i] = true;
                   sum += candidates[i];
                   record.add(candidates[i]);
                   dfs(candidates, target, i + 1, visited, res, sum, record);
                   record.remove(record.size() - 1);
                   sum -= candidates[i];
                   visited[i] = false;
               }
           }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new boolean[candidates.length], res, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
    }
}
