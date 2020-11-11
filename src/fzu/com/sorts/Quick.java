package fzu.com.sorts;

public class Quick {

    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }

    /**
     * 快速排序
     * 时间复杂度O(nlogn)
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi;
        Comparable v = a[lo];
        while (i < j){
            while(i < j && less(v, a[j])) j--;
            a[i] = a[j];
            while(i < j && less(a[i], v)) i++;
            a[j] = a[i];
        }
        a[i] = v;
        return i;
    }

    /**
     *
     * @param v
     * @param w
     * @return
     * public int compareTo(Object obj) ;
     * 该方法：
     * 返回 0 表示 this == obj
     * 返回整数表示 this > obj
     * 返回负数表示 this < obj
     */
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <= 0;
    }

    public static void main(String[] args) {
        Integer[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        sort(arr);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
