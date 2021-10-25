package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        list.sort((a, b) -> a[0] - b[0]); // 按capital大小升序排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a); // 降序排序
        int i = 0;
        while (k-- > 0) {
            while (i < n && list.get(i)[0] <= w) {
                priorityQueue.add(list.get(i++)[1]);
            }
            if (priorityQueue.isEmpty()) break;
            w += priorityQueue.poll();
        }
        return w;
    }
}
