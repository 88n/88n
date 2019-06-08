package sort;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 17:55 2019/5/8
 */
public class XuanZhe {
    public static void main(String[] args) {
        int[] arr = PrintUtils.getArray();

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        PrintUtils.printArray(arr);
    }
}
