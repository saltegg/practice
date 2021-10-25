package fzu.com.lc.traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {


    public static void dfs(int cur, int n, List<List<Integer>> lists, int[] nums,
                           List<Integer> list, boolean[] visited) {
        if (cur == n) {
            lists.add(new ArrayList<>(list));
            System.out.println(list);
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(nums[i]);
                    dfs(cur + 1, n, lists, nums, list, visited);
                    visited[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) return lists;
        boolean[] visited = new boolean[100];
        List<Integer> list= new ArrayList<>();
        dfs(0, nums.length, lists, nums, list, visited);
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //permute(nums);
    }
}
