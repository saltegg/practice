package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.List;

public class Competition263 {

    public boolean areNumbersAscending(String s) {

        String[] tokens = s.split(" ");
        int tmp = 0;
        for (String token : tokens) {
            if (token.charAt(0) >= '0' && token.charAt(0) <= '9') {
                int k = Integer.parseInt(token);
                if (tmp == 0) {
                   tmp = k;
                } else {
                    if (k <= tmp) return false;
                    else tmp = k;
                }
            }
        }
        return true;
    }


    //private boolean[] visited;
    private int ans = Integer.MIN_VALUE;
    private int cnt = 1;
    private List<Integer> subset = new ArrayList<>();

    private void dfs(int[] nums, int start) {

        int tmp = 0;
        for (int v : subset) {
            tmp |= v;
        }
        if (tmp > ans) {
            ans = tmp;
            cnt = 1;
        } else if (tmp == ans) {
            cnt++;
        }

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        //this.visited = new boolean[nums.length];
        dfs(nums, 0);
        return cnt;
    }


}
