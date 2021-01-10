package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @author zz
 * @date 2021/1/10 23:02
 */
public class 存在重复元素_217 {

    /**
     * 做法1：排序
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1;i < nums.length;i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 做法2：哈希表
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(new 存在重复元素_217().containsDuplicate(nums));

        nums = new int[]{1,2,3,4};
        System.out.println(new 存在重复元素_217().containsDuplicate(nums));

        nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(new 存在重复元素_217().containsDuplicate(nums));
    }

}
