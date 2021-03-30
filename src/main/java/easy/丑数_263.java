package easy;

/**
 * 丑数
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数2, 3, 5的正整数。
 * 示例 1:
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 ×3
 * 示例 2:
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 ×2
 * 示例3:
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数7。
 * 说明：
 * 1是丑数。
 * 输入不会超过 32 位有符号整数的范围:[−231, 231− 1]。
 * @author zz
 * @date 2021/1/28 20:13
 */
public class 丑数_263 {

    /**
     * 做法：依次取出数字的值为2,3,5的因数。全部取出后，如果数字变为1，证明为丑叔，否则不是丑叔
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        int res = num;
        while (res != 0 && res % 2 == 0) {
            res /= 2;
        }
        while (res != 0 && res % 3 == 0) {
            res /= 3;
        }
        while (res != 0 && res % 5 == 0) {
            res /= 5;
        }
        if (res == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 6;
        System.out.println(new 丑数_263().isUgly(num));

        num = 8;
        System.out.println(new 丑数_263().isUgly(num));

        num = 14;
        System.out.println(new 丑数_263().isUgly(num));
    }

}
