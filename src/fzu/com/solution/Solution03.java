package fzu.com.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution03 {


    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int res = 0, r = 0, l = 0;
        for (; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c) && map.get(c) >= l) {
                res = Math.max(res, r - l);
                l = map.get(c) + 1;
            }
            map.put(c, r);
        }
        return Math.max(res, r - l);
    }
}
