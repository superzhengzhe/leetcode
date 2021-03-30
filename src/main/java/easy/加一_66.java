package easy;

/**
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * 通过次数229,695提交次数503,5
 * @author zz
 * @date 2020/12/9 9:33
 */
public class 加一_66 {

    /**
     * 做法：
     * 从后向前遍历，依次加一，如果加后的值大于10，则进位
     * 如果最高位也进位，则扩容数组，并令最高位为1
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int tmp = 0;
        for (int i = digits.length - 1;i >= 0;i--) {
            digits[i]++;
            tmp = digits[i] - 10;
            if (tmp < 0) {
                return digits;
            }
            digits[i] -= 10;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
        int[] result = new 加一_66().plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        digits = new int[]{4,3,2,1};
        result = new 加一_66().plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        digits = new int[]{0};
        result = new 加一_66().plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        digits = new int[]{9};
        result = new 加一_66().plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        digits = new int[]{8,9,9,9};
        result = new 加一_66().plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
