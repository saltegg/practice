package fzu.com.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {

    private boolean[] visited;

    private List<List<Integer>> res;

    private void dfs(int[] nums, int cur, List<Integer> s) {
        if (cur == nums.length) {
            res.add(new ArrayList<Integer>(s));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                s.add(nums[i]);
                dfs(nums, cur + 1, s);
                s.remove(s.size() - 1);
                visited[i] = false;
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>());
        return res;
    }
}
