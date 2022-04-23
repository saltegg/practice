package fzu.com.bytedance;

public class Solution165 {

    public int compareVersion(String version1, String version2) {


        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            int a = 0, b = 0;
            while (i < len1 && version1.charAt(i) != '.') {
                a = a * 10 + version1.charAt(i) - '0';
                i++;
            }
            while (j < len2 && version2.charAt(j) != '.') {
                b = b * 10 + version2.charAt(j) - '0';
                j++;
            }
            if (a > b) return 1;
            if (a < b) return -1;
        }
        return 0;
    }
}
