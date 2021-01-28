package easy;

/**
 * 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * @author zz
 * @date 2021/1/28 19:48
 */
public class 各位相加_258 {

    /**
     * 做法：数学方法
     * 通过%9等到想要的结果或者0，0的原因是因为9也被模。改造一下即可
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 做法：循环
     * 常规做法
     * @param num
     * @return
     */
    public int addDigits1(int num) {
        int res = num, tmp;
        while (res >= 10) {
            tmp = res;
            res = 0;
            while (tmp != 0) {
                res += tmp % 10;
                tmp /= 10;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 各位相加_258().addDigits(38));
    }

}
