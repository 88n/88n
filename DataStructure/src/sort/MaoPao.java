package sort;

import java.util.ArrayList;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 17:22 2019/5/8
 */
public class MaoPao {
    public static void main(String[] args) {
        int[] arr = PrintUtils.getArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        PrintUtils.printArray(arr);
    }
}
