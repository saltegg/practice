package fzu.com.codetop;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {

    public String minWindow(String s, String t) {

        String res = "";
        int cnt = t.length(), sl = s.length(), max = Integer.MAX_VALUE;
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (int l = 0, r = 0; r < sl; r++) {
            char c = s.charAt(r);
            if (map2.containsKey(c) && cnt > 0) {
                if (map2.get(c) > 0) {
                    cnt--;
                }
                map2.put(c, map2.get(c) - 1);
            }
            while (cnt == 0) {
                if (r - l + 1 < max) {
                    res = s.substring(l, r + 1);
                    max = res.length();
                }
                char u = s.charAt(l);
                if (map2.containsKey(u)) {
                    int f = map2.get(u) + 1;
                    map2.put(u, f);
                    if (f > 0) {
                        cnt++;
                    }
                }
                l++;
                if (l > r) break;
            }
        }
        return res;
    }
}
