package fzu.com.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {

    List<String> res = new ArrayList<>();

    private void dfs(String s, int cur, int start, StringBuilder ip) {

        if (cur == 4 && ip.length() - 4 == s.length()) {
            res.add(ip.substring(0, ip.length() - 1));
            return;
        }

        for (int i = start; i < 3 + start && i < s.length(); i++) {
            String t = s.substring(start, i + 1);
            if (Integer.parseInt(t) > 255) continue;
            ip.append(t).append(".");
            dfs(s, cur + 1, i + 1, ip);
            ip.delete(ip.length() - 1 - t.length(), ip.length());
            if (t.equals("0")) break;
        }
    }

    public List<String> restoreIpAddresses(String s) {

        if (s.length() < 4 || s.length() > 12) return res;
        dfs(s, 0, 0, new StringBuilder());
        return res;
    }
}
