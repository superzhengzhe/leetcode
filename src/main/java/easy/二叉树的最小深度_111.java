package easy;

import base.TreeNode;

/**
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 * @author zz
 * @date 2020/12/31 10:29
 */
public class 二叉树的最小深度_111 {

    /**
     * 做法：递归
     * 计算左右子树的高度，然后取最小高度+1即可
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftMinDepth = minDepth(root.left);
        if (leftMinDepth == 1) {
            return 2;
        }
        int rightMinDepth = minDepth(root.right);
        if (rightMinDepth == 1) {
            return 2;
        }
        if (leftMinDepth == 0 && rightMinDepth == 0) {
            return 1;
        }
        if (leftMinDepth == 0) {
            return 1 + rightMinDepth;
        }
        if (rightMinDepth == 0) {
            return 1 + leftMinDepth;
        }
        return 1 + Math.min(leftMinDepth, rightMinDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
        System.out.println(new 二叉树的最小深度_111().minDepth(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(new 二叉树的最小深度_111().minDepth(root));
    }

}
