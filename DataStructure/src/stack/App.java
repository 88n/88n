package stack;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 14:26 2019/4/17
 */
public class App {
    public static void main(String[] args) {
        SequenStack sequenStack = new SequenStack(10);
        LinkedStack linkedStack = new LinkedStack();
        nibolan(linkedStack);
    }


    /**
     * 用java（顺序）栈实现逆波兰算法[计算器]
     * @param linkedStack
     */
    public static void nibolan(LinkedStack linkedStack){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入逆波兰算法表达试：");
        String str = scanner.nextLine();
        String[] nbl = str.split(" ");
        int sum = 0;
        for (String s : nbl) {
            Pattern pattern = Pattern.compile("-?[0-9]*.?[0-9]*");
            Matcher matcher = pattern.matcher((CharSequence) s);
            boolean result = matcher.matches();
            int num1 =0;
            int num2 =0;
            switch (s){
                case "+":
                    num1 = Integer.parseInt(linkedStack.pop().toString());
                    num2 = Integer.parseInt(linkedStack.pop().toString());
                    linkedStack.push(num1 + num2);
                    sum = num1 + num2;
                    break;
                case "-":
                    num1 = Integer.parseInt(linkedStack.pop().toString());
                    num2 = Integer.parseInt(linkedStack.pop().toString());
                    linkedStack.push(num2 - num1);
                    sum = num1 - num2;
                    break;
                case "*":
                    num1 = Integer.parseInt(linkedStack.pop().toString());
                    num2 = Integer.parseInt(linkedStack.pop().toString());
                    linkedStack.push(num1 * num2);
                    sum = num1 * num2;
                    break;
                case "/":
                    num1 = Integer.parseInt(linkedStack.pop().toString());
                    num2 = Integer.parseInt(linkedStack.pop().toString());
                    linkedStack.push(num2 / num1);
                    sum = num1 / num2;
                    break;
                default:
                    linkedStack.push(s);
            }
        }
        System.out.println(sum);
    }


    /**
     * 使用（顺序）栈实现 2进制转10 进制
     * @param sequenStack
     */
    public static void convert(SequenStack sequenStack){
        System.out.println("==========进制的转换 2转10 ============");

        String str = "10111";
        for (int i = 0 ; i< str.length() ; i++){
            sequenStack.push(str.charAt(i));
        }

        int num = 0;
        StringBuffer test = new StringBuffer();
        int i = 0;
        while (!sequenStack.isEmpty()){
            char pop = sequenStack.pop();
            test.append(pop);
            num += Math.pow(2,i++)*Integer.parseInt(""+pop);
        }
        System.out.println(test.toString());
        System.out.println(num);
    }

    /**
     * 测试
     * @param sequenStack
     */
    public static void test(SequenStack sequenStack){
        String str = "人国中是我";
        for (int i = 0 ; i< str.length() ; i++){
            sequenStack.push(str.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        while (!sequenStack.isEmpty()){
            sb.append(sequenStack.pop());
        }

    }
}
