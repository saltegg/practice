package fzu.com.lc.pre200;

public class Solution165 {

    public int compareVersion1(String version1, String version2) {

        String[] a1 = version1.split(".");
        String[] a2 = version2.split(".");

        for (int p = 0; p < Math.max(a1.length, a2.length); p++) {
            int i = p < a1.length? Integer.parseInt(a1[p]) : 0;
            int j = p < a2.length? Integer.parseInt(a2[p]) : 0;
            if (i > j) return 1;
            else if (i < j) return -1;
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {

        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int a = 0, b = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                a = a * 10 + version1.charAt(i++) - '0';
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                b = b * 10 + version2.charAt(j++) - '0';
            }
            if (a > b) return 1;
            if (a < b) return -1;
            i++;
            j++;
        }
        return 0;
    }
}
