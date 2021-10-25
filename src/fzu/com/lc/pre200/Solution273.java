package fzu.com.lc.pre200;

public class Solution273 {

    static String[] low = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    static String[] mid = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] high = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public static String numberToWords(int num) {

        if (num == 0) return "Zero";

        int part1 = num % 1000;
        num /= 1000;
        int part2 = num % 1000;
        num /= 1000;
        int part3 = num % 1000;
        num /= 1000;
        int part4 = num;
        String ans = "";

        if (part4 != 0) {
            ans = build(part4) + "Billion ";
        }
        if (part3 != 0) {
            ans = ans + build(part3) + "Million ";
        }
        if (part2 != 0) {
            ans = ans + build(part2) + "Thousand ";
        }
        if (part1 != 0) {
            ans = ans + build(part1);
        }
        return ans.trim();
    }

    private static String build(int num) {
        int a = num%10;
        num = num/10;
        int b = num%10;
        num = num/10;
        int c = num;
        String ans = "";
        if(c!=0){
            ans = low[c] + " " + "Hundred ";
        }
        if(b==1){
            ans = ans + mid[a];
        }else if(b==0){
            ans = ans + low[a];
        }else {
            ans = ans + high[b] + " " + low[a];
        }
        return ans.trim() + " ";
    }

    public static void main(String[] args) {
        numberToWords(101);
    }
}
