package easy;

/**
 * x的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * @author zz
 * @date 2020/12/11 20:30
 */
public class x的平方根_69 {

    /**
     * 做法：二分法，注意特殊案例
     * 后续待优化
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1, end = x, mid = 0;
        while (start < end) {
            mid = (start + end - 1) / 2;
            if (Math.pow(mid, 2) > x && Math.pow(mid - 1, 2) < x) {
                return mid - 1;
            }
            if (Math.pow(mid, 2) < x && Math.pow(mid + 1, 2) > x) {
                return mid;
            }
            if (Math.pow(mid, 2) > x) {
                end = mid - 1;
            } else if (Math.pow(mid, 2) < x) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println(new x的平方根_69().mySqrt(x));
        x = 8;
        System.out.println(new x的平方根_69().mySqrt(x));
        x = 15;
        System.out.println(new x的平方根_69().mySqrt(x));
        x = 16;
        System.out.println(new x的平方根_69().mySqrt(x));
        x = 17;
        System.out.println(new x的平方根_69().mySqrt(x));
        x = 6;
        System.out.println(new x的平方根_69().mySqrt(x));
    }

}
