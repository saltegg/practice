package fzu.com.codetop;

import java.util.Arrays;

public class Solution56 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][0]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
