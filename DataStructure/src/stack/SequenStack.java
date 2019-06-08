package stack;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 14:16 2019/4/17
 */
public class SequenStack {
    private int maxSize;
    private int top;
    private char[] arr;

    public SequenStack(int size){
        maxSize = size;
        top = -1;
        arr = new char[maxSize];
    }

    /**
     * 压入数据
     * @param value
     */
    public void push(char value){
        arr[++top] = value;
    }

    /**
     * 弹出数据
     * @return
     */
    public char pop(){
        return arr[top--];
    }

    /**
     * 访问栈顶元素
     * @return
     */
    public char peek(){
        return arr[top];
    }

    /**
     * 判断栈是否满了
     * @return
     */
    public boolean isFull(){
        return maxSize - 1 == top;
    }

    /**
     * 判断栈是否是空的
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 返回栈的当前长度
     * @return
     */
    public int length(){
        return top;
    }
}
