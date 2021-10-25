package fzu.com.lc.pre200;

public class Solution38 {

    public String countAndSay(int n) {
        String ans = "1";
        if (n == 1) return ans;
        for (int i = 2; i <= n; i++) {
            int count = 1;
            char c = ans.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < ans.length(); j++) {
                if (ans.charAt(j) == c) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    count = 1;
                    c = ans.charAt(j);
                }
            }
            sb.append(count).append(c);
            ans = sb.toString();
        }
        return ans;
    }
}
