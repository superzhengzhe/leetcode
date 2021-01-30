package 剑指offer;

/**
 * 在排序数组中查找数字I
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 限制：
 * 0 <= 数组长度 <= 50000
 * @author zz
 * @date 2021/1/30 15:38
 */
public class 在排序数组中查找数字I {

    /**
     * 做法：二分法
     * 先用二分法找到一个等于目标值的数
     * 然后在该数的左右两边查找等于目标值的数
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                break;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (nums[mid] != target) {
            return 0;
        }
        int count = 1;
        int left = mid - 1;
        while (left >= 0 && nums[left] == target) {
            left--;
            count++;
        }
        int right = mid + 1;
        while (right < nums.length && nums[right] == target) {
            right++;
            count++;
        }
        return count;
    }

}
