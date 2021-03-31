package 数组.简单;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于n/2的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * @author zz
 * @date 2021/1/4 10:00
 */
public class 多数元素_169 {

    /**
     * 做法1：哈希表统计次数
     * @param nums
     * @return
     */
    public int majorityElement0(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int count = map.get(nums[i]);
                if (++count > nums.length / 2) {
                    return nums[i];
                }
                map.put(nums[i], count);
            }
        }
        return -1;
    }

    /**
     * 做法2：排序取众数
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 做法3：摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] == res) {
                count++;
            } else {
                if (--count == 0) {
                    res = nums[i];
                    count++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new 多数元素_169().majorityElement(nums));

        nums = new int[]{3,2,3};
        System.out.println(new 多数元素_169().majorityElement(nums));

        nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(new 多数元素_169().majorityElement(nums));
    }

}
