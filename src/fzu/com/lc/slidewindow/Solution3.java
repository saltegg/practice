package fzu.com.lc.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.equals("")) return 0;
        int l = 0, r, mLen = 0;
        Set<Character> set = new HashSet<>();
        for (r = 0; r <  s.length(); r++) {
            if (set.contains(s.charAt(r))) {
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        set.remove(s.charAt(l));
                        l++;
                    } else {
                        break;
                    }
                }
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r));
            mLen = Math.max(mLen, r - l + 1);
        }
        return mLen;
    }

    public static void main(String[] args) {
        String t = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(t));
    }
}
