package easy;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @author zz
 * @date 2020/12/14 10:28
 */
public class 爬楼梯_70 {

    /**
     * 解法1：递归
     * 第i步 == 第i-1步向前走1步或者第i-2步向前走1步
     * @param n
     * @return
     */
    public int climbStairs0(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 解法2：动态规划
     * 思路参考解法1
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int pre1 = 1, pre2 = 2;
        int res = 0;
        for (int i = 3;i <= n;i++) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
       return res;
    }

    public static void main(String[] args) {
        System.out.println(new 爬楼梯_70().climbStairs(0));
        System.out.println(new 爬楼梯_70().climbStairs(2));
        System.out.println(new 爬楼梯_70().climbStairs(3));
        System.out.println(new 爬楼梯_70().climbStairs(45));
    }

}
