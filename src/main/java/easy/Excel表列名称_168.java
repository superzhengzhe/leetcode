package easy;

/**
 * Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 * @author zz
 * @date 2021/1/4 1:18
 */
public class Excel表列名称_168 {

    /**
     * 做法：利用进制的思想
     * 这道题可以看出，将数转换为26进制即可
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char)('A' + --n%26));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 701;
        System.out.println(new Excel表列名称_168().convertToTitle(n));
    }

}
