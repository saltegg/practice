package fzu.com.lc.pre200;

public class Solution434 {
    public int countSegments(String s) {

        boolean flag = false;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && !flag) {
                cnt++;
                flag = true;
            }
            if (s.charAt(i) == ' ') {
                flag = false;
            }
        }
        return cnt;
    }
}
