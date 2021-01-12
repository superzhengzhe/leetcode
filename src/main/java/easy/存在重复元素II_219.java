package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素II
 * 给定一个整数数组和一个整数 k，
 * 判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * @author zz
 * @date 2021/1/11 10:49
 */
public class 存在重复元素II_219 {

    /**
     * 做法：set + 滑动窗口
     * 使用一个长度为k的set存储元素
     * 遍历数组，每次判断元素是否在set中，如果不存在则加入，如果存在则返回true
     * 每次插入后，都要判断set是否大于长度k，如果大于，则移除第1个元素
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set set = new HashSet();
        for (int i = 0;i < nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        System.out.println(new 存在重复元素II_219().containsNearbyDuplicate(nums, k));

        nums = new int[]{1,0,1,1};
        k = 1;
        System.out.println(new 存在重复元素II_219().containsNearbyDuplicate(nums, k));

        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        System.out.println(new 存在重复元素II_219().containsNearbyDuplicate(nums, k));
    }

}
