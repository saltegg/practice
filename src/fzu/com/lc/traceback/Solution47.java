package fzu.com.lc.traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {

    private static void dfs(int[] nums, boolean[] visited, int cur, List<List<Integer>> res, List<Integer> record) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(record));
            System.out.println(record);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // 去重的关键
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            visited[i] = true;
            record.add(nums[i]);
            dfs(nums, visited, cur + 1, res, record);
            visited[i] = false;
            record.remove(record.size() - 1);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], 0, res, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {

    }
}
