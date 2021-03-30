package 数组.简单;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * 说明：
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。
 * 你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
 * 示例：
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出：[1,2,2,3,5,6]
 * 提示：
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 * 通过次数242,428提交次数494,3
 * @author zz
 * @date 2020/12/15 10:14
 */
public class 合并两个有序数组_88 {

    /**
     * 做法：遍历
     * 从两个数组的最后开始遍历，依次取最大值，放在较大的那个数组的最后某个位置，然后指针向前移动，依次判断即可
     * 这个最后某个位置为：数组1的长度 + 数组2的长度 - 1
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return;
        }
        int index = m + n - 1, n1 = m - 1, n2 = n - 1;
        while (n1 >= 0 || n2 >= 0) {
            if (n1 < 0) {
                nums1[index--] = nums2[n2];
                n2--;
                continue;
            }
            if (n2 < 0) {
                nums1[index--] = nums1[n1];
                n1--;
                continue;
            }
            if (Math.max(nums1[n1], nums2[n2]) == nums1[n1]) {
                nums1[index--] = nums1[n1];
                n1--;
            } else {
                nums1[index--] = nums2[n2];
                n2--;
            }
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1,2,3,0,0,0};
        int[] n2 = new int[]{2,5,6};
        new 合并两个有序数组_88().merge(n1, 3, n2, 3);
        for (int i : n1) {
            System.out.print(i + " ");
        }
    }

}
