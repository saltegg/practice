package fzu.com.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

    List<List<Integer>> res = new ArrayList<>();

    private void dfs(int[] nums, int start, List<Integer> list) {

        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }
}
