package fzu.com.codetop;

public class Solution459 {

    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        boolean res;
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                res = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        res = false;
                        break;
                    }
                }
                if (res) return true;
            }
        }
        return false;
    }
}
