package select.tree;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 16:33 2019/4/29
 */
public class TreeNode<E> {

    private E element;
    private TreeNode<E> parent;
    private TreeNode<E> leftChild;
    private TreeNode<E> rightChild;

    public TreeNode(E element, TreeNode<E> parent) {
        this.element = element;
        this.parent = parent;
    }

    public TreeNode() {
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}
