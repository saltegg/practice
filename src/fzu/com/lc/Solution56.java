package fzu.com.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

    public int[][] merge(int[][] intervals) {

        List<int[]> lists = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];  // 按区间的第一个元素进行升序排序
                return o1[0] - o2[0];                      // 如果相等，则按照区间的第二个元素进行升序排序
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                int[] list = new int[2];
                list[0] = intervals[0][0]; list[1] = intervals[0][1];   // 初始化第一个区间
                lists.add(list);
                continue;
            }
            int[] tmp = lists.get(lists.size() - 1);
            int[] list = new int[2];
            if (intervals[i][0] <= tmp[1] && intervals[i][1] > tmp[1]) {
                list[0] = tmp[0];
                list[1] = intervals[i][1];
                lists.remove(lists.size() - 1);
                lists.add(list);
            } else if (intervals[i][0] > tmp[1]){
                list[0] = intervals[i][0];
                list[1] = intervals[i][1];
                lists.add(list);
            }
        }
        int[][] res = new int[lists.size()][2];
        for(int i = 0; i < lists.size(); i++) {
            res[i][0] = lists.get(i)[0];
            res[i][1] = lists.get(i)[1];
        }
        return res;
    }
}
