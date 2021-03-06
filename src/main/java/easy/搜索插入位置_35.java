package easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * @author zz
 */
public class 搜索插入位置_35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = (start + end + 1) / 2;
        while (start < end) {
            if (nums[index] > target) {
                end = index - 1;
            } else if (nums[index] < target) {
                start = index + 1;
            } else {
                return index;
            }
            index = (start + end + 1) / 2;
        }
        if (start == end) {
            if (nums[start] < target) {
                return start + 1;
            }
            return start;
        }
        return Math.max(start, end);
    }

}
