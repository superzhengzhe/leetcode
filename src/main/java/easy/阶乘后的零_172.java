package easy;

/**
 * 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释:3! = 6, 尾数中没有零。
 * 示例2:
 * 输入: 5
 * 输出: 1
 * 解释:5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为O(logn)。
 * @author zz
 * @date 2021/1/5 14:08
 */
public class 阶乘后的零_172 {

    /**
     * 做法：找5的倍数
     * 可以用暴力法，不过时间复杂度较高
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n/5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new 阶乘后的零_172().trailingZeroes(5));
        System.out.println(new 阶乘后的零_172().trailingZeroes(6));
    }

}
