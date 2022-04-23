package fzu.com.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        int c = 0;
        List<Integer> path = new ArrayList<>();
        path.add(c);
        for (int i = 0; i < len - 1; i++) {
            if (dp[i + 1][c] > dp[i + 1][c + 1]) {
                c = c + 1;
            }
            path.add(c);
        }
        /*for (int i = 0; i < path.size(); i++) {
            System.out.println(triangle.get(i).get(path.get(i)));
        }*/
        return dp[0][0];
    }
}
