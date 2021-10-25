package fzu.com.lc.test;

import fzu.com.lc.Solution5;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution5Test {

    @Test
    public void convert() {
        String s = "LEETCODEISHIRING";
        int numsRow = 3;
        Solution5 solution = new Solution5();
        String ans = solution.convert(s, numsRow);
        assertEquals("LCIRETOESIIGEDHN", ans);
    }
}