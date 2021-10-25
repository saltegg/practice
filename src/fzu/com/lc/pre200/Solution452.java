package fzu.com.lc.pre200;

import java.util.Arrays;

public class Solution452 {


    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0],o2[0]));
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= points[i - 1][1]){
                points[i][1] = Math.min(points[i][1], points[i][0]);
            } else {
                count++;
            }
        }
        return count;
    }
}
