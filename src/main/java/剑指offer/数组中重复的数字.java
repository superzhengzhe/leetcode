package 剑指offer;

import java.util.*;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 * 2 <= n <= 100000
 * 数组中重复的数字
 * @author zz
 * @date 2021/1/29 14:00
 */
public class 数组中重复的数字 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(new 数组中重复的数字().findRepeatNumber4(nums));
    }

    public int findRepeatNumber4(int[] nums) {
        int tmp;
        for (int i = 0;i < nums.length;i++) {
            if (nums[nums[i]] == nums[i]) {
                if (nums[i] == i) {
                    continue;
                }
                return nums[i];
            } else {
                tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return 0;
    }

    public int findRepeatNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < nums.length;i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        int res = nums[0];
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] == res) {
                return res;
            } else {
                res = nums[i];
            }
        }
        return 0;
    }

    public int findRepeatNumber1(int[] nums) {
        int max = nums[0];
        for (int i = 1;i < nums.length;i++) {
            max = Math.max(max, nums[i]);
        }
        int[] res = new int[max + 1];
        for (int i = 0;i < nums.length;i++) {
            if (res[nums[i]] == 0) {
                res[nums[i]] = 1;
            } else {
                return nums[i];
            }
        }
        return 0;
    }

    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }

}