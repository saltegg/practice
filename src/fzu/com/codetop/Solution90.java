package fzu.com.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {


    List<List<Integer>> res = new ArrayList<>();

    private void dfs(int[] nums, int start, List<Integer> list, boolean[] used) {

        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, i + 1, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
}
