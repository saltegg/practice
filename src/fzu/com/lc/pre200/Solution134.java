package fzu.com.lc.pre200;

public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            int haveGas = 0, time = 0;
            for (int j = i; ;j = (j + 1) % gas.length ) {
                if (j == i) time++;
                if (time > 1) return i;
                haveGas += gas[j];
                if (haveGas  >= cost[j]) {
                    haveGas -= cost[j];
                } else {
                    break;
                }
            }
        }
        return -1;
    }

}
