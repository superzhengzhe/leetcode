package easy;

import java.util.Arrays;

/**
 * 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @author zz
 * @date 2021/1/4 0:33
 */
public class 两数之和II输入有序数组_167 {

    /**
     * 做法：双指针
     * 一个指针指向头部，一个指针指向尾部
     * 如果指针所指的两个数大于目标值，则尾指针向前移动
     * 如果指针所指的两个数小于目标值，则头指针向后移动
     * 重复操作直到找到该数字为止
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }
        int [] res = new int[2];
        int start = 0, end = numbers.length - 1;
        while (start <= end) {
            res[0] = start + 1;
            res[1] = end + 1;
            if (numbers[start] + numbers[end] == target) {
                return res;
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] res = new 两数之和II输入有序数组_167().twoSum(nums, 9);
        for (int i : res) {
            System.out.println(i);
        }
    }

}
