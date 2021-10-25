package fzu.com.lc.pre200;

import java.util.Arrays;

public class Solution5856 {

    public int minSessions(int[] tasks, int sessionTime) {

        Arrays.sort(tasks);
        int i = 0, res = 0, sum = 0;
        while (i < tasks.length) {
            if (sum + tasks[i] > sessionTime) {
                res++;
                sum = tasks[i];
            } else {
                sum += tasks[i];
            }
            i++;
        }
        return res + 1;
    }
}
