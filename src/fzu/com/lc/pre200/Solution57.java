package fzu.com.lc.pre200;

import java.util.Arrays;

public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = -1;
        int[][] res = new int[intervals.length + 1][2];
        int[][] ans = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }
        res[intervals.length][0] = newInterval[0];
        res[intervals.length][1] = newInterval[1];
        Arrays.sort(res, (o1, o2) -> o1[0] - o2[0]);
        for (int[] interval : res) {
            if (idx == -1 || interval[0] > ans[idx][1]) {
                ans[++idx] = interval;
            } else {
                ans[idx][1] = Math.max(ans[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(ans, idx + 1);
    }
}
