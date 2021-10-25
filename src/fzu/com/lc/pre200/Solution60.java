package fzu.com.lc.pre200;

public class Solution60 {

    private boolean[] visited;

    private int n, k;

    private int[] factorial;


    public String getPermutation(int n, int k) {

        this.n = n;
        this.k = k;

        factorial = new int[n + 1];
        visited = new boolean[n + 1];
        getFactorial(factorial);
        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        return sb.toString();
    }

    private void dfs(int cur, StringBuilder sb) {

        if (n == cur) {
            return;
        }
        int cnt = factorial[n - 1 - cur];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if (k > cnt) {
                k -= cnt;
                continue;
            }
            sb.append(i);
            visited[i] = true;
            dfs(cur + 1, sb);
            return;
        }
    }

    private void getFactorial(int[] factorial) {
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

}
