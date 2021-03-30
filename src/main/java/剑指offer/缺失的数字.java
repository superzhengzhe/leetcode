package 剑指offer;

/**
 * 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * 限制：
 * 1 <= 数组长度 <= 1000
 * @author zz
 * @date 2021/1/30 15:54
 */
public class 缺失的数字 {

    /**
     * 做法：二分（时间复杂度o(logn),空间复杂度o(1)）
     * 每次找中间的数，如果中间值等于索引，证明这个数在右边
     * 如果中间值大于索引，证明数在左边
     * 最后退出二分查找后，start即为所求
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int start = 0, end = nums.length - 1,mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == mid) {
                start = mid + 1;
            } else if (nums[mid] > mid) {
                end = mid -1;
            }
        }
        return start;
    }

    /**
     * 做法：遍历（时间复杂度o(n),空间复杂度o(1)）
     * 定义一个标志位res从0开始，然后遍历数组，判断当前值是否等于标志位
     * 等于就将标志位res+1，然后继续遍历。否则返回res
     * 如果for循环结束后仍然未找到，证明是最后一个位置缺失，直接返回res
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int res = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == res) {
                res++;
                continue;
            } else {
                return res;
            }
        }
        return res;
    }

    /**
     * 做法：常规做法（需要创建数组，额外的空间）
     * 先找到最大的一个数字，然后建立一个容量为最大数字 + 2的数组
     * 然后将使用过的标记为1
     * 最后遍历这个数组，值为0的位置即为所求
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int max = nums[0];
        for (int i = 0;i < nums.length;i++) {
            max = Math.max(max, nums[i]);
        }
        int[] exist = new int[max + 2];
        for (int i = 0;i < nums.length;i++) {
            exist[nums[i]] = 1;
        }
        for (int i = 0;i < exist.length;i++) {
            if (exist[i] == 0) {
                return i;
            }
        }
        return 0;
    }

}
