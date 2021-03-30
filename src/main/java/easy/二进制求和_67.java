package easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字1和0。
 * 示例1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * @author zz
 * @date 2020/12/9 9:51
 */
public class 二进制求和_67 {

    /**
     * 做法：
     * 1. 计算出a和b的最大长度，然后遍历最大长度次，从最后一位开始遍历
     * 2. 每次遍历，a和b的最后一位相加，如果大于2，则进位，否则不进位
     * 3. 将每次相加的结果%2拼接到字符串中，最后反序，即得到结果
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int tmp = 0, carry = 0;
        int tmpA = a.length() - 1, tmpB = b.length() - 1;
        for (int i = 0;i < len;i++) {
            tmp = tmpA >= 0 ? tmp + ((int)a.charAt(tmpA) - (int)('0')) : tmp;
            tmp = tmpB >= 0 ? tmp + ((int)b.charAt(tmpB) - (int)('0')) : tmp;
            tmpA--;
            tmpB--;
            if (carry == 1) {
                tmp += 1;
                carry = 0;
            }
            if (tmp >= 2) {
                carry = 1;
                sb.append(tmp%2);
            } else {
                sb.append(tmp);
            }
            tmp = 0;
        }
        if (carry == 1) {
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(new 二进制求和_67().addBinary(a, b));

        a = "1010";
        b = "1011";
        System.out.println(new 二进制求和_67().addBinary(a, b));
    }

}
