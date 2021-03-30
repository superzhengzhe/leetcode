package 二叉树.简单;

import base.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @author zz
 * @date 2020/12/30 19:58
 */
public class 将有序数组转换为二叉搜索树_108 {

    /**
     * 做法：从数组中间开始遍历，使用中序遍历即可构建出高度平衡的二查搜索树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBSTTree(nums, 0, nums.length - 1);
    }

    public TreeNode createBSTTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = createBSTTree(nums, start, middle - 1);
        root.right = createBSTTree(nums, middle + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        System.out.println(new 将有序数组转换为二叉搜索树_108().sortedArrayToBST(nums));
    }

}
