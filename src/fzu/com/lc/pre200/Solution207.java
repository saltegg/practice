package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> ad = new ArrayList<>();
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            ad.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[1]]++;
            ad.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int id = queue.poll();
            numCourses--;
            for (Integer neighbor : ad.get(id)) {
                degree[neighbor]--;
                if (degree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return numCourses == 0;
    }
}
