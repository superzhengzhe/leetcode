package easy;

import base.TreeNode;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * @author zz
 * @date 2020/12/23 9:47
 */
public class 对称二叉树_101 {

    /**
     * 做法：递归判断，判断的逻辑是左子树与右子树的镜像相等
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
         if (left == null && right == null) {
             return true;
         }
         if (left == null && right != null) {
             return false;
         }
         if (left != null && right == null) {
             return false;
         }
         if (left.val != right.val) {
             return false;
         }
         return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(new 对称二叉树_101().isSymmetric(root));
    }

}
