package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int[] row = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i || j == 0) row[j] = 1;
                else row[j] = row[j] + row[j - 1];
            }
        }
        for (int v : row) {
            res.add(v);
        }
        return res;
    }
}
