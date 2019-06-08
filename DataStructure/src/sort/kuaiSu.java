package sort;

import java.util.Arrays;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 11:17 2019/5/9
 */
public class kuaiSu {
    public static void main(String[] args) {
        int[] arr = PrintUtils.getArray();
        PrintUtils.printArray(arr);

        zhuhui(arr, 0, arr.length - 1);


        PrintUtils.printArray(arr);
    }


    public static void quickSort(int[] number, int left, int right){
        if(left > right)
            return;
        int i = left;//左下标
        int j = right;//右下标
        int temp = number[i];//存放基数

        while(i != j){
            //左边第一个比基数大的数的下标
            while(number[i] <= temp && i < j){
                i++;
            }
            //右边第一个比基数小的数的下标
            while(number[j] >  temp && i < j){
                j--;
            }
            //两数交换
            int t = number[i];
            number[i] = number[j];
            number[j] = t;
        }
        //现在i=j了,他们在数组的某个位置会和了,这个位置左边所有的数小于基准数,右边的数都大于基准数字
        //把基准数字从数组的左边移动到i和j会和的位置
        number[left] = number[i];
        number[i] = temp;


        //递归调用,让左右两边两个数组重复刚才的动作
        quickSort(number, left, j-1);
        quickSort(number,j+1, right);
    }

    public static void zhuhui(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;
        int key = arr[right];

        while (left < right) {
            while (left < right && arr[left] <= key) {
                left++;
            }

            while (left < right && arr[right] >= key) {
                right--;
            }

            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        arr[high] = arr[right];
        arr[right] = key;
        PrintUtils.printArray(arr);
        zhuhui(arr, low, left-1);
        zhuhui(arr, left + 1, high);
    }

    /**
     * 快速排序（左右指针法）
     *
     * @param arr  待排序数组
     * @param low  左边界
     * @param high 右边界
     */
    public static void sort2(int arr[], int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;

        int key = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, low, left);
        System.out.println("Sorting: " + Arrays.toString(arr));
        sort2(arr, low, left - 1);
        sort2(arr, left + 1, high);
    }

    public static void swap(int arr[], int low, int high) {
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }


    public void quickSortaaa(int array[], int top, int tail) {
        if (top >= tail) {
            return;
        }
        int left = top, right = tail;
        int temp = array[left];// 数组的第一作为中轴
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];// 比中轴小的记录移动到低端
            while (left < right && array[left] < temp) {
                left++;
            }
            array[right] = array[left];
        }
        if (left == right) {
            array[left] = temp;
        }
        if (left != top) {
            quickSort(array, 0, left - 1);
        }
        if (right != tail) {
            quickSort(array, right + 1, array.length - 1);
        }
    }
}
