package stack;

import java.util.LinkedList;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 15:51 2019/4/17
 */
public class LinkedStack {
    private LinkedList<Object> a = new LinkedList<Object>();

    public void push(Object o) {
        a.addFirst(o);
    }

    public Object pop() {
        return a.removeFirst();
    }

    public Object peek() {
        return a.getFirst();
    }

    public boolean empty() {

        return a.isEmpty();
    }

}
