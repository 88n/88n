package LinearTable.SingleLink;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 17:31 2019/4/15
 */
public class App {
    public static void main(String[] args) throws Exception {
        SingleLink singleLink = new SingleLink();

        singleLink.addNode(new Node(100));
        System.out.println("链表长度" + singleLink.length());

        singleLink.insertNodeByIndex(2, new Node(222));
        System.out.println("链表长度" + singleLink.length());

        System.out.println(singleLink.getNode(2));
        System.out.println(singleLink.delNodeByIndex(3));
        System.out.println(singleLink.updateNodeByIndex(2,200));

        singleLink.print();
    }
}
