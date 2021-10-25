package fzu.com.lc.pointOffer;

import java.util.HashSet;
import java.util.Set;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r, max = 0;
        Set<Character> set = new HashSet<>();
        for (r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r));
            max = Math.max(max, set.size());
        }
        return max;
    }
}
