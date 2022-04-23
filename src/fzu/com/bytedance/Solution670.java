package fzu.com.bytedance;

import java.util.Arrays;

public class Solution670 {

    public int maximumSwap(int num) {

        char[] chs = String.valueOf(num).toCharArray();
        int[] last = new int[10];
        Arrays.fill(last, -1);
        for (int i = 0; i < chs.length; i++) {
            last[chs[i] - '0'] = i;
        }
        for (int i = 0; i < chs.length; i++) {
            for (int j = 9; j > chs[i] - '0'; j--) {
                if (last[j] > i) {
                    char ch = chs[i];
                    chs[i] = chs[last[j]];
                    chs[last[j]] = ch;
                    return Integer.parseInt(String.valueOf(chs));
                }
            }
        }
        return Integer.parseInt(String.valueOf(chs));
    }
}
