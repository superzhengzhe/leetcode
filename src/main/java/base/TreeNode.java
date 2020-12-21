package base;

/**
 * @author zz
 * @date 2020/12/21 16:46
 */
public class TreeNode {

   public int val;

   public TreeNode left;

   public TreeNode right;

   public TreeNode() {}

   public TreeNode(int val) {
       this.val = val;
   }

   public TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }

}
