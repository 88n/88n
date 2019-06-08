package select.tree;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 17:33 2019/4/29
 */
public class TsetTree {
    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        tree.setRoot(new TreeNode(50, null));
        tree.add(62);
        tree.add(15);
        tree.add(68);
        tree.add(12);
        tree.add(46);
        tree.add(65);
        tree.add(79);
        tree.add(35);
        tree.add(57);

        System.out.println("root=" + tree.getRoot());
        System.out.println("二叉树的中序遍历：");
        // 前序遍历
        tree.theFirstTraversal(tree.getRoot());

        // 删除
        tree.delete(tree.getRoot());

        // 前序遍历
        System.out.println("删除之后的=========");
        tree.theFirstTraversal(tree.getRoot());

        System.out.println();
        System.out.println(tree.countSize());

    }
}

