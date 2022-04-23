package fzu.com.bytedance;

import java.util.Arrays;
import java.util.Comparator;

public class Solution179 {

    public String largestNumber(int[] nums) {

        String[] sts = new String[nums.length];
        for (int i = 0; i < nums.length; i++) sts[i] = String.valueOf(nums[i]);
        Arrays.sort(sts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : sts) sb.append(str);
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
}
