package easy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @author zz
 * @date 2021/1/1 21:46
 */
public class 只出现一次的数字_136 {

    /**
     * 做法：位运算
     * 异或运算：0与任何数异或等于它自己，两个一样的数异或等于0，异或交换律
     * 所以所有数异或，等于只有一个只出现一次的数
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0;i < nums.length;i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        System.out.println(new 只出现一次的数字_136().singleNumber(nums));

        nums = new int[]{4,1,2,1,2};
        System.out.println(new 只出现一次的数字_136().singleNumber(nums));
    }

}
