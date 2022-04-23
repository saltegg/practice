package fzu.com.solution.sort;

public class Sort {


    // 1. 插入排序
    // 2. 选择排序
    // 2. 冒泡排序
    // 3. 快速排序
    // 4. 归并拍戏
    // 5. 堆排序

    public static void BubbleSort(int[] arr) {

        /**
         * 基本思路：循环n次（数组长度），每次确定一个最大值或者最小值 以升序为例子
         * 1. 从头至尾比较相邻的元素。如果第一个元素比第二个元素大，就交换。
         * 2. 重复步骤1，每次遍历都将冒出一个最大数，直到排序完成
         * 时间复杂度：O(n2) 空间复杂度：O(1)
         */

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        /**
         * 快速排序的基本思想是:通过一趟排序算法把所需要排序的序列的元素分割成两大块，
         * 其中，一部分的元素都要小于或等于另外一部分的序列元素，然后仍根据该种方法对划分后的这两块序列的元素分别再次实行快速排序算法，
         * 排序实现的整个过程可以是递归的来进行调用，最终能够实现将所需排序的无序序列元素变为一个有序的序列
         */

        if (l < r) {
            int tmp = arr[l], i = l, j = r;
            while (i < j) {
                while (i < j && arr[j] >= tmp) j--;
                if (i < j) arr[i++] = arr[j];
                while (i < j && arr[i] < tmp) i++;
                if (i < j) arr[j--] = arr[i];
            }
            arr[i] = tmp;
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        /**
         * 归并排序算法就是把序列递归划分成为一个个短序列，以其中只有1个元素的直接序列或者只有2个元素的序列作为短序列的递归出口，
         * 再将全部有序的短序列按照一定的规则进行排序为长序列。归并排序融合了分治策略，即将含有n个记录的初始序列中的每个记录均视为长度为1的子序列，
         * 再将这n个子序列两两合并得到n/2个长度为2(当凡为奇数时会出现长度为l的情况)的有序子序列；
         * 将上述步骤重复操作，直至得到1个长度为n的有序长序列。
         * 需要注意的是，在进行元素比较和交换时，若两个元素大小相等则不必刻意交换位置，因此该算法不会破坏序列的稳定性，即归并排序也是稳定的排序算法。
         */

        /**
         * （1）稳定性
         *      　归并排序是一种稳定的排序。
         * （2）存储结构要求
         *     　可用顺序存储结构。也易于在链表上实现。
         * （3）时间复杂度
         *     　对长度为n的文件，需进行趟二路归并，每趟归并的时间为O(n)，故其时间复杂度无论是在最好情况下还是在最坏情况下均是O(nlgn)。
         * （4）空间复杂度
         *    　 需要一个辅助向量来暂存两有序子文件归并的结果，故其辅助空间复杂度为O(n)，显然它不是就地排序。
         */

        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= r) {
            tmp[k++] = arr[j++];
        }
        for (int p = 0; i < tmp.length; i++) {
            arr[l + p] = tmp[p];
        }
    }

    public static void heapSort(int[] arr) {

        /**
         * 构建初始堆，将待排序列构成一个大顶堆(或者小顶堆)，升序大顶堆，降序小顶堆；
         * 将堆顶元素与堆尾元素交换，并断开(从待排序列中移除)堆尾元素。
         * 重新构建堆。
         * 重复2~3，直到待排序列中只剩下一个元素(堆顶元素)。
         */
        // 创建堆
        for (int i = arr.length / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;

            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int parent, int length) {
        int tmp = arr[parent];
        int lChild = 2 * parent + 1; // 左孩子
        while (lChild < length) {
            int rChild = lChild + 1;
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild = rChild;
            }
            if (tmp >= arr[lChild]) {
                break;
            }
            arr[parent] = arr[lChild];
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = tmp;
    }

}
