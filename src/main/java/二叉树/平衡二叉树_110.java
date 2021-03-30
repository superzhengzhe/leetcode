package 二叉树;

import base.TreeNode;

/**
 * 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * @author zz
 * @date 2020/12/31 10:17
 */
public class 平衡二叉树_110 {

    /**
     * 做法：递归
     * 主要逻辑是判断左右子树的高度小于1，然后继续判断其左子树，右子树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        if (leftHeight - rightHeight > 1 || leftHeight - rightHeight < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }

}
