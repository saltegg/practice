package fzu.com.lc.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution934 {

    private static int[] dir = {-1, 0, 1, 0, -1};

    static class Node {
        int x;
        int y;
        int level;
        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

    private static void dfs(int[][] A, int n, int m, Queue<Node> queue, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || A[x][y] == 2) return;
        if (A[x][y] == 0) {
            queue.add(new Node(x, y, 1));
            return;
        }
        A[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int r = x + dir[i];
            int c = y + dir[i + 1];
            dfs(A, n, m, queue, r, c);
        }
    }

    public static int shortestBridge(int[][] A) {

        if (null == A || A.length == 0) return 0;
        boolean flag = false;
        int n = A.length, m = A[0].length; // n 行, m 列
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (flag) break;
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    dfs(A, n, m, queue, i, j);
                    flag = true;
                    break;
                }
            }
        }

        while (!queue.isEmpty()) {    // BFS 找最短路径, 从每个0开始
            int sizeOfQueue = queue.size();
            while (sizeOfQueue > 0) {
                Node node = queue.poll();
                sizeOfQueue--;
                for (int i = 0; i < 4; i++) {
                    assert node != null;
                    int r = node.x + dir[i];
                    int c = node.y + dir[i + 1];
                    if (r >= 0 && r < n && c >= 0 && c < m) {
                        if (A[r][c] == 1) {
                            return node.level;
                        } else if (A[r][c] == 0) {
                            queue.add(new Node(r, c, node.level + 1));
                            A[r][c] = 2;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] t1 = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };

        int[][] t2 = {
                {0,1},
                {1,0}
        };

        int[][] t3 = {
                {0,1,0},
                {0,0,0},
                {0,0,1}
        };

        int[][] t4 = {};

        System.out.println(shortestBridge(t3));
    }
}
