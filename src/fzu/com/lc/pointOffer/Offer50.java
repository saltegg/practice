package fzu.com.lc.pointOffer;

public class Offer50 {

    public char firstUniqChar(String s) {
        if (s.equals("") || s.length() == 0) return ' ';
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }
}
