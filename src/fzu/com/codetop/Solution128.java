package fzu.com.codetop;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {

    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int num : nums) {
            if (set.remove(num)) {
                int curNum = num - 1;
                int curLongestLen = 1;
                while (set.remove(curNum)) curNum--;
                curLongestLen += num - curNum - 1;
                curNum = num + 1;
                while (set.remove(curNum)) curNum++;
                curLongestLen += curNum - num - 1;
                res = Math.max(res, curLongestLen);
            }
        }
        return res;
    }
}
