package easy;

import base.TreeNode;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @author zz
 * @date 2020/12/30 11:16
 */
public class 二叉树的层序遍历II_107 {

    /**
     * 做法:利用队列，通过两个指针last和nlast来判断是否打印到行末，nlast指向行末，last指向当前元素
     * 当last==nlast，此时需要换行
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode last = null;
        TreeNode nlast = root;
        TreeNode qlast = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> line = new ArrayList<>();

        queue.offer(root);
        TreeNode node = queue.poll();
        while (node != null) {
            line.add(node.val);
            last = node;
            if (node.left != null) {
                queue.offer(node.left);
                qlast = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                qlast = node.right;
            }
            if (last == nlast) {
                res.add(0, line);
                line = new ArrayList<>();
                nlast = qlast;
            }
            node = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new 二叉树的层序遍历II_107().levelOrderBottom(root));

        root = new TreeNode(1,new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(new 二叉树的层序遍历II_107().levelOrderBottom(root));

        root = new TreeNode(-8,new TreeNode(-6, new TreeNode(6, null, new TreeNode(5)), null), new TreeNode(7));
        System.out.println(new 二叉树的层序遍历II_107().levelOrderBottom(root));
    }

}
