package fzu.com.bytedance;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";
        int cnt = 0, start = 0, end = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    cnt++;
                }
                map.put(c, map.get(c) - 1);
            }
            while (cnt == t.length()) {
                if (end - start > r - l) {
                    end = r;
                    start = l;
                }
                if (map.containsKey(s.charAt(l)) ) {
                    if (map.get(s.charAt(l)) >= 0) {
                        cnt--;
                    }
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                }
                l++;
            }
        }
        return end == s.length()? "" : s.substring(start, end + 1);
    }
}
