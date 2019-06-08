package sort;

import java.util.Arrays;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 19:11 2019/5/9
 */
public class BinGui {

    public static void main(String[] args) {
        System.out.println(1>>1);
        System.out.println(2>>1);
        System.out.println(3>>1);
        System.out.println(4>>1);
        System.out.println(5>>1);
        System.out.println(6>>1);
        System.out.println(7>>1);
        System.out.println(8>>1);
        System.out.println(9>>1);
        System.out.println(10>>1);

        int[] arr = PrintUtils.getArray();

        arr = sort(arr);

        PrintUtils.printArray(arr);
    }

    public static int[] sort(int[] arr) {
        if (arr.length <= 1){
            return arr;
        }
        int num = arr.length >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, num);
        int[] right = Arrays.copyOfRange(arr, num, arr.length);
        return mergeArrays(sort(left), sort(right));
    }


    public static int[] mergeArrays(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[a.length + b.length]; // 申请额外空间保存归并之后数据

        while (i < a.length && j < b.length) { //选取两个序列中的较小值放入新数组
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) { //序列a中多余的元素移入新数组
            result[k++] = a[i++];
        }
        while (j < b.length) {//序列b中多余的元素移入新数组
            result[k++] = b[j++];
        }
        return result;
    }
}
