package sort;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 18:01 2019/5/8
 */
public class ChaRu {
    public static void main(String[] args) {
        int[] arr = PrintUtils.getArray();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }

        PrintUtils.printArray(arr);
    }
}
