package fzu.com.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> ad = new ArrayList<>();
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) ad.add(new ArrayList<>());
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++;
            ad.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            numCourses--;
            for (int id : ad.get(tmp)) {
                degree[id]--;
                if (degree[id] == 0) {
                    queue.add(id);
                }
            }
        }

        return numCourses == 0;
    }
}
