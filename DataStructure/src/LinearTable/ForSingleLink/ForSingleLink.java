package LinearTable.ForSingleLink;

import java.util.HashMap;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 17:03 2019/4/15
 */
public class ForSingleLink {
    /**
     * 头结点（头结点应该不存放数据的）
     */
    Node head = new Node(0);
    public void init(){
        head.next = head;
    }


    /**
     * 计算单链表的长度，也就是有多少个结点
     * @return    结点个数
     */
    public int length(){
        Node temp = head;
        int length = 0;
        while (temp.next != head){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 遍历单链表，打印所有data
     */
    public void print(){
        StringBuffer sb = new StringBuffer();
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
            sb.append( temp.data + ",");
        }
        String data = sb.toString();
        System.out.println(data.substring(0,data.length()-1));
    }


    /**
     * 得到指定下标的元素
     * @param index
     * @return
     * @throws Exception
     */
    public int getNode(int index) throws Exception {
        //判断给出的小标是否合法
        if(index < 1 || index > length()){
            throw new Exception("给出的链表下标不合法。");
        }
        Node temp = head.next;
        int length = 1;
        while (temp != head){
            if (index == length++){
                return temp.data;
            }
            temp = temp.next;
        }
        throw new Exception("未知异常。");
    }

    /**
     * 增加操作
     *         直接在链表的最后插入新增的结点即可
     *         将原本最后一个结点的next指向新结点
     */
    public boolean addNode(Node node){
        //链表中有结点，遍历到最后一个结点
        Node temp = head;    //一个移动的指针(把头结点看做一个指向结点的指针)
        while(temp.next != head){    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node;    //temp为最后一个结点或者是头结点，将其next指向新结点
        node.next = head;
        return true;
    }

    /**
     * insertNodeByIndex:在链表的指定位置插入结点。
     *         插入操作需要知道1个结点即可，当前位置的前一个结点
     * index:插入链表的位置，从1开始
     * node:插入的结点
     */
    public boolean insertNodeByIndex(int index, Node node){
        //首先需要判断指定位置是否合法，
        if(index<1||index>length()+1){
            System.out.println("插入位置不合法。");
            return false;
        }
        int length = 1;            //记录我们遍历到第几个结点了，也就是记录位置。
        Node temp = head;        //可移动的指针
        while(temp.next != head){//遍历单链表
            if(index == length++){        //判断是否到达指定位置。
                //注意，我们的temp代表的是当前位置的前一个结点。
                //前一个结点        当前位置        后一个结点
                //temp            temp.next     temp.next.next
                //插入操作。（修改节点的后继需要注意先后顺序）
                node.next = temp.next;
                temp.next = node;
                return true;
            }
            temp = temp.next;
        }
        if(length == index){
            temp.next = node;
            node.next = head;
            //或这用下面这种方式
            //node.next = temp.next;
            //temp.next = node;
            System.out.println("在单链表的尾部添加了一个元素");
            return true;
        }else {
            return false;
        }
    }

    /**
     * 通过index删除指定位置的结点,跟指定位置增加结点是一样的，先找到准确位置。然后进行删除操作。
     *             删除操作需要知道1个结点即可：和当前位置的前一个结点。
     * @param index：链表中的位置，从1开始
     *
     */
    public boolean delNodeByIndex(int index){
        //判断index是否合理
        if(index<1 || index>length()){
            System.out.println("给定的位置不合理");
            return false;
        }

        //步骤跟insertNodeByIndex是一样的，只是操作不一样。
        int length=1;
        Node temp = head;
        while(temp.next != head){
            if(index == length++){
                //删除操作。
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        System.out.println("未知异常");
        return false;
    }

    /**
     * 通过index修改指定位置的结点数据
     * @param index
     * @param data
     * @return
     * @throws Exception
     */
    public boolean updateNodeByIndex(int index, int data) throws Exception {
        //首先需要判断指定位置是否合法，
        if(index<1 || index>length()){
            System.out.println("需要修改的位置的下标不合法。");
            return false;
        }
        int length = 1;
        Node temp = head;
        while (temp.next != head){
            temp = temp.next;
            if(index == length++){
                temp.data = data;
                return true;
            }
        }
        throw new Exception("未知异常");
    }

    /**
     * 头插法
     * @param node
     * @return
     */
    public boolean addHead(Node node){
        node.next = head.next;
        head.next = node;
        return true;
    }

    /**
     * 尾插法
     * @param node
     * @return
     */
    public boolean addTail(Node node){
        Node temp = head;
        //从头节点遍历到尾节点
        while (temp.next != head){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        return true;
    }




}
