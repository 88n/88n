package sort;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 10:19 2019/5/9
 */
public class Xier {

    public static void main(String[] args) {
        int[] arr = PrintUtils.getArray();

        // 朱辉希尔排序
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int j = 0; (j + gap) < arr.length; j++) {
                for (int k = 0; (k + gap) < arr.length; k = k + gap) {
                    if (arr[k] > arr[k+gap]) {
                        int temp = arr[k+gap];
                        arr[k+gap] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
        }

        PrintUtils.printArray(arr);
    }
}
