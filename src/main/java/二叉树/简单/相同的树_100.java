package 二叉树.简单;

import base.TreeNode;

/**
 * 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 * 输出: true
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 * 输出: false
 * 示例3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 * 输出: false
 * @author zz
 * @date 2020/12/16 10:14
 */
public class 相同的树_100 {

    /**
     * 做法：树的遍历
     * 关键的点：不一定需要整棵树遍历完成，如果中途有值不同，提前返回false
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1,new TreeNode(2), new TreeNode(1));
        TreeNode q = new TreeNode(1,new TreeNode(2), new TreeNode(1));
        System.out.println(new 相同的树_100().isSameTree(p, q));
    }

}
