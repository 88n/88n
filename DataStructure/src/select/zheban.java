package select;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 11:40 2019/4/29
 */
public class zheban {

    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i*3);
        }

        int key = 81*3;

        // 顺序查找
        long start = System.nanoTime();
        for (int i = 0 ; i < list.size() ; i++) {
            int num = Integer.parseInt(list.get(i).toString());
            if (num == key){
                System.out.println(i + "");
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("顺序查找运行时间" + (end - start) + "ns");


        // 折半算法
        int max = list.size() - 1;
        int min = 0;
        int mid = (max + min)/2;

        start = System.nanoTime();
        while ((int)list.get(mid) != key){
            int num = (int) list.get(mid);

            if(num > key){
                max = mid - 1;
            }else if (num < key){
                min = mid + 1;
            }

            if(min > max){
                throw new Exception("没有找到指定的值");
            }

            mid = (min + max)/2;
        }
        end = System.nanoTime();
        System.out.println("\n" + mid + "=======" + list.get(mid));
        System.out.println("折半算法运行时间" + (end - start) + "ns");


        // 插值查找
        start = System.nanoTime();
        int minNum = Integer.parseInt(list.get(min).toString());
        int maxNum = Integer.parseInt(list.get(max).toString());
        mid = min + (key - minNum)/(maxNum - minNum)*(max - min);
        while ((int)list.get(mid) != key){
            int num = (int) list.get(mid);

            if(num > key){
                max = mid - 1;
            }else if (num < key){
                min = mid + 1;
            }

            if(min > max){
                throw new Exception("没有找到指定的值");
            }

            mid =  min + (key - minNum)/(maxNum - minNum)*(max - min);
        }
        end = System.nanoTime();
        System.out.println("\n" + mid + "=======" + list.get(mid));
        System.out.println("插值查找运行时间" + (end - start) + "ns");

    }
}
