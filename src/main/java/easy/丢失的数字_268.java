package easy;

import java.util.Arrays;

/**
 * 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 进阶：
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 * @author zz
 * @date 2021/1/28 20:24
 */
public class 丢失的数字_268 {

    /**
     * 做法：排序
     * 先排序，再判断。这种方法简单粗暴，但是耗时
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != res) {
                return res;
            }
            res++;
        }
        return res;
    }

    /**
     * 做法：for循环
     * 先找到最大的那个数
     * 然后创建一个数组，长度为最大值+2
     * 接着将存在的值标记为1
     * 最后遍历数组，当找到数为0时，则数组的下标则为所求
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int max = nums[0];
        if (nums.length != 1) {
            for (int i = 1;i < nums.length;i++) {
                max = Math.max(max, nums[i]);
            }
        }
        int[] res = new int[max + 2];
        for (int i = 0;i < nums.length;i++) {
            res[nums[i]] = 1;
        }
        for (int i = 0;i < res.length;i++) {
           if (res[i] == 0) {
               return i;
           }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1};
        System.out.println(new 丢失的数字_268().missingNumber(nums));
    }

}
