package fzu.com.lc.towpoint;

public class Solution680 {

    public boolean validPalindrome(String s) {

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                int k, m;
                for (k = i, m = j - 1; k < m; k++, m--){
                    if (s.charAt(k) != s.charAt(m)) break;
                }
                if (k >= m) return true;
                for (k = i + 1, m = j; k < m; k++, m--){
                    if (s.charAt(k) != s.charAt(m)) return false;
                }
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
