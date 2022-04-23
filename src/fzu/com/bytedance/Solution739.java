package fzu.com.bytedance;

public class Solution739 {

    public int[] dailyTemperatures(int[] temperatures) {

        int k = temperatures.length - 1;
        int[] ans = new int[temperatures.length];
        ans[k] = 0;
        for (int i = k - 1;i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                ans[i] = 1;
            } else {
                int j = i + 1;
                while (ans[j] != 0 && temperatures[j] <= temperatures[i]) {
                    j = j + ans[j];
                }
                if (temperatures[j] > temperatures[i]) ans[i] = j - i;
                if (ans[j] == 0) ans[i] = 0;
            }
        }
        return ans;
    }
}
