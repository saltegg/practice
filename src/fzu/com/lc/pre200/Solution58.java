package fzu.com.lc.pre200;

public class Solution58 {

    public int lengthOfLastWord(String s) {

        int n = s.length() - 1, cnt = 0;
        while (s.charAt(n) == ' ') {
            n--;
        }
        for (int i = n; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            else cnt++;
        }
        return cnt;
    }
}
