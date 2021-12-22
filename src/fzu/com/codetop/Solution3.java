package fzu.com.codetop;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        int res = 0, l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c) && map.get(c) >= l) {
                res = Math.max(res, r - l);
                l = map.get(c) + 1;
            }
            map.put(c, r++);
        }
        return Math.max(res, r - l);
    }
}
