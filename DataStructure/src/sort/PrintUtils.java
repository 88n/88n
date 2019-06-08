package sort;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 17:35 2019/5/8
 */
public class PrintUtils {

    public static int[] getArray() {
        return new int[]{100, 32, 11, 512, 6};
                //, 78, 3, 22, 451, 62, 4};
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        System.out.println();
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i + ", ");
        }
        String str = sb.toString();
        System.out.println(str.substring(0,str.lastIndexOf(",")));
    }
}
