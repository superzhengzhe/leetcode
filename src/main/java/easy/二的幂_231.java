package easy;

/**
 * 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 示例1:
 * 输入: 1
 * 输出: true
 * 解释: 20= 1
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 24= 16
 * 示例 3:
 * 输入: 218
 * 输出: false
 * @author zz
 * @date 2021/1/12 17:51
 */
public class 二的幂_231 {

    /**
     * 做法：二进制
     * 获取当前数字的二进制1的个数
     * 一个代表二的幂，否则不满足
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        int res = 0;
        while (n > 0) {
            n &= n - 1;
            if (++res == 2) {
                return false;
            }
        }
        return res == 1;
    }

    public static void main(String[] args) {
        System.out.println(new 二的幂_231().isPowerOfTwo(1));
        System.out.println(new 二的幂_231().isPowerOfTwo(16));
        System.out.println(new 二的幂_231().isPowerOfTwo(218));
    }

}
