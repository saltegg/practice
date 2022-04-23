package fzu.com.bytedance;

import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int k = -1;
        int[][] res = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if (k == -1 || interval[0] > res[k][1]) {
                res[++k] = interval;
            } else {
                res[k][1] = Math.max(res[k][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, k + 1);
    }
}
