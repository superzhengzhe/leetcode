package 二叉树.简单;

import base.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明:叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @author zz
 * @date 2021/1/18 17:41
 */
public class 二叉树的所有路径_257 {

    private List<String> res = new ArrayList<>();

    /**
     * 做法：中序遍历（递归）
     * 传入list和stringbuilder，递归到子节点时打印
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        getBinaryTreePaths(root, "");
        return res;
    }

    public void getBinaryTreePaths(TreeNode node, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            getBinaryTreePaths(node.left, sb.toString());
            getBinaryTreePaths(node.right, sb.toString());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(5), null), new TreeNode(3));
        System.out.println(new 二叉树的所有路径_257().binaryTreePaths(root));
    }

}
