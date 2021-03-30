package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
 * @author zz
 * @date 2021/2/1 14:34
 */
public class 滑动窗口的最大值 {

    /**
     * 做法：单调队列
     * 使用一个单调队列，维护窗口的最值
     * 循环数组，如果队列为空，直接从队尾压入数据，否则从队尾将比他小的元素依次取出
     * 如果如果队列头部的数等于要被移除的数numms[i - k]，则将队列头部移除
     * 最后如果窗口形成了，依次输出队列头部的元素，即为所求的数组
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Deque<Integer> deque = new ArrayDeque();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0;i < nums.length;i++) {
            if (deque.isEmpty()) {
                deque.addLast(nums[i]);
            } else {
                Integer remove = deque.peekLast();
                while (remove != null) {
                    if (remove < nums[i]) {
                        deque.pollLast();
                        remove = deque.peekLast();
                    } else {
                        break;
                    }
                }
                deque.addLast(nums[i]);
            }
            if (i - k >=0 && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = deque.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = new 滑动窗口的最大值().maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        nums = new int[]{1};
        k = 1;
        res = new 滑动窗口的最大值().maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        nums = new int[]{1, -1};
        k = 1;
        res = new 滑动窗口的最大值().maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
