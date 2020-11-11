package fzu.com.sorts;

public class SortEaxmple {

    /**
     * 选择排序
     * 时间复杂度O(n²)，需要进行大约N²/2此比较和N次交换
     * @param a   参数需要实现comparable接口的
     */
    public static void selectSort(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    /**
     * 插入排序
     * 时间复杂度O(n²)，最坏情况下需要N²/2比较和N²/2次交换，最好情况下需要进行N-1次比较和0次交换
     * @param a    参数需要实现comparable接口的
     */
    public static void insertSort(Comparable[] a){
        for(int i = 1 ; i < a.length; i++){
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--){
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * 归并排序
     *
     * @param a 参数需要实现comparable接口的
     */
    public static void mergeSort(Comparable[] a){

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
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {3,5,7,8,4,6,10};
        selectSort(a);
        for(int i = 0; i < 7; i++){
            System.out.println(a[i]);
        }
    }
}
