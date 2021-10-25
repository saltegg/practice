package fzu.com.lc.pointOffer;

public class Offer46 {

    private int res;

    private void dfs(int cur, int n, char[] numArray) {
        if (cur == n) {
            res++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                dfs(cur + 1, n, numArray);
            } else {
                if (cur < n - 1 && numArray[cur] != '0') {
                    int tmp = (numArray[cur] - '0') * 10 +  (numArray[cur + 1] - '0');
                    if (tmp > 25) return;
                    dfs(cur + 2, n, numArray);
                }
            }
        }
    }

    public int translateNum(int num) {
        char[] numArray = String.valueOf(num).toCharArray();
        dfs(0, numArray.length, numArray);
        return res;
    }
}
