package easy;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统。
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * @author zz
 * @date 2021/1/7 14:07
 */
public class 打家劫舍_198 {

    /**
     * 做法：动态规划
     * 如果只有一间房，则最大金额为f(1)=n(1)
     * 如果有两间房，则最大金额为f(2)=max(n(1),n(2))
     * 如果有n间房，则最大金额为f(n)=max(f(n-1), f(n-2)+n(n))
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = nums[0], res = Math.max(nums[0], nums[1]);
        int tmp = 0;
        for (int i = 2;i < nums.length;i++) {
            tmp = res;
            res = Math.max(pre + nums[i], res);
            pre = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,1};
        System.out.println(new 打家劫舍_198().rob(nums1));

        int[] nums2 = new int[]{2,7,9,3,1};
        System.out.println(new 打家劫舍_198().rob(nums2));
    }

}
