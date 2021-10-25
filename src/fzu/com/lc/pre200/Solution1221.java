package fzu.com.lc.pre200;

public class Solution1221 {

    public int balancedStringSplit(String s) {

        int cnt = 0, cntL = 0, cntR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                cntL++;
            } else if (s.charAt(i) == 'R') {
                cntR++;
            }
            if (cntL == cntR) {
                cnt++;
                cntL = 0;
                cntR = 0;
            }
        }
        return cnt;

    }
}
