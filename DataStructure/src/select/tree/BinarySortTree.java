package select.tree;

import java.util.*;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 16:36 2019/4/29
 */
public class BinarySortTree<E> {
    // 根节点
    private TreeNode<E> root = null;

    // 树中元素的个数
    private int size = 0;

    // 空构造方法
    public BinarySortTree() {
    }

    // 统计二叉树中的节点数
    public int countSize() {
        return size;
    }

    // 获得节点元素的值
    public TreeNode<E> getRoot() {
        return root == null ? null : root;
    }
    // 设置节点元素的值
    public void setRoot(TreeNode<E> root) {
        this.root = root;
        size++;
    }

    /**
     * 首先查找二叉排序树，如果找不到指定元素 则插入到二叉树中
     */
    public boolean add(E element) {
        Map map = new HashMap();
        map.put("1","啊啊");
        map.put("10","ff");
        map.get("1");
        Object[] obj = new Object[10];
        Object o = obj[1 & 1];
        System.out.println(o);

        if (root == null) {
            root = new TreeNode<>(element, null);
            size ++;
            return false;
        }
        Comparable<? super E> e = (Comparable<? super E>)element;
        TreeNode<E>[] temp = new TreeNode[1];
        if (!searchBST(element, temp)) {
            // 没有查询到元素，插入元素
            TreeNode<E> newTreeNode = new TreeNode<E>(element, temp[0]);
            int cmp = e.compareTo(temp[0].getElement());
            if (cmp < 0) {
                temp[0].setLeftChild(newTreeNode);
            }else if (cmp > 0) {
                temp[0].setRightChild(newTreeNode);
            }
            size++;
            return true;
        }
        return false;
    }

    /**
     * 递归实现：查找指定元素element是否在书中存在，如果不存在确认其添加的位置
     * @param element   需要查找的对象
     * @param curr      开始查找的节点
     * @param par       开始查找的节点的父节点
     * @param last      如果找到了就是当前节点，否则是最后一个节点。
     * @return
     * @throws Exception
     */
    public boolean searchBST(Object element, TreeNode<E> curr,TreeNode<E> par, TreeNode<E> last) throws Exception {
        if(curr == null){
            last = par;
            return false;
        }
        Comparable<? super E> e = (Comparable<? super E>)element;
        int cmp = e.compareTo(curr.getElement());
        if (cmp < 0) {
            searchBST(element, curr.getLeftChild(), curr, last);
        }else if (cmp > 0) {
            searchBST(element, curr.getRightChild(), curr, last);
        }else {
            last = curr;
            return true;
        }
        throw new Exception();
    }

    /**
     * 非递归实现：查找指定元素element是否在书中存在，如果不存在确认其添加的位置
     * @param element
     * @param arr
     * @return
     */
    public boolean searchBST(Object element, TreeNode<E>[] arr) {
        Comparable<? super E> e = (Comparable<? super E>)element;
        TreeNode<E> parent = root;
        TreeNode<E> temp = null;
        while (parent != null) {
            int cmp = e.compareTo(parent.getElement());
            temp = parent;
            if (cmp < 0) {
                parent = parent.getLeftChild();
            }else if (cmp > 0) {
                parent = parent.getRightChild();
            }else {
                arr[0] = parent;
            }
        }
        // 没有查询到指定的节点，返回最后一个节点
        arr[0] = temp;
        return false;
    }

    // 前序遍历二叉树
    public void theFirstTraversal(TreeNode<E> root) {
        System.out.println(root.getElement());
        if (root.getLeftChild() != null) {
            theFirstTraversal(root.getLeftChild());
        }
        if (root.getRightChild() != null) {
            theFirstTraversal(root.getRightChild());
        }
    }

    /**
     * 二叉树的中序遍历
     * @param root
     */
    public void theInOrderTraversal(TreeNode<E> root) {
        if (root.getLeftChild() != null) {
            theInOrderTraversal(root.getLeftChild());
        }
        System.out.println(root.getElement());
        if (root.getRightChild() != null) {
            theInOrderTraversal(root.getRightChild());
        }
    }

    /**
     * 二叉树的后序遍历
     * @param root
     */
    public void thePostOrderTraversal(TreeNode<E> root) {
        if (root.getLeftChild() != null) {
            thePostOrderTraversal(root.getLeftChild());
        }
        System.out.println(root.getElement());
        if (root.getRightChild() != null) {
            thePostOrderTraversal(root.getRightChild());
        }
    }



    /**
     * 删除二叉排序树中的结点
     * 分为三种情况：（删除结点为*p ，其父结点为*f）
     * （1）要删除的*p结点是叶子结点，只需要修改它的双亲结点的指针为空
     * （2）若*p只有左子树或者只有右子树，直接让左子树/右子树代替*p
     * （3）若*p既有左子树，又有右子树
     *      用p左子树中最大的那个值（即最右端S）代替P，删除s，重接其左子树
     *      用p右子树中最小的那个值（即最左端S）代替P，删除s，重接其右子树
     * */
    public void delete(TreeNode<E> node){
        if (deleteBST(node)) {
            size--;
        }
    }

    private boolean deleteBST(TreeNode<E> node){
        TreeNode<E> temp = node;

        if (node.getLeftChild() == null) {   // 表示没有左子树
            node = node.getRightChild();
            return true;
        }else if (node.getRightChild() == null) {  // 表示没有右子树
            node = node.getLeftChild();
            return true;
        }else { //表示既有左子树也有右子树

            temp = node;
            TreeNode<E> s = node.getLeftChild();

            /** 采用方式一：转向左子树，然后向右走到“尽头” */
            while (s.getRightChild() != null) {
                s = s.getRightChild();
                temp = s;
            }
            node.setElement(s.getElement());
            if (node != temp) { // 表示当前在左子树的，右尽头。
                //temp = s.getLeftChild();
                //temp.setParent(s.getLeftChild());
                return true;
            }else { // 表示左子树下没有右子树了
                node = s;
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Map<Object, Object> linkedHashMap = new TreeMap<>();
        linkedHashMap.put("1","发送");
        linkedHashMap.put("a","faafd】啊");
        linkedHashMap.put("c","发斯蒂芬");
        linkedHashMap.put("b","ffdasf22”");
        linkedHashMap.put("3","房间打扫房间22");
        Iterator<Map.Entry<Object, Object>> iterator = linkedHashMap.entrySet().iterator();
        Hashtable hashtable = new Hashtable();

        while (iterator.hasNext()) {
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println(next.getKey() + "-----" + next.getValue());
        }
    }

}
