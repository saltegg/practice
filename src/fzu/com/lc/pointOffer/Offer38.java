package fzu.com.lc.pointOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer38 {

    private void dfs(int cur, int n, List<String> sList,
                     StringBuilder sb, boolean[] visited, char[] chs) {
        if (cur == n) {
            sList.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (i > 0 && !visited[i - 1] && chs[i - 1] == chs[i]) continue;
                visited[i] = true;
                sb.append(chs[i]);
                dfs(cur + 1, n, sList, sb, visited, chs);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    public String[] permutation(String s) {
        List<String> sList = new ArrayList<>();
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        dfs(0, s.length(), sList, new StringBuilder(), new boolean[s.length()], chs);
        int pos = 0;
        String[] ans = new String[sList.size()];
        for (String v : sList) {
            ans[pos++] = v;
        }
        return ans;
    }
}
