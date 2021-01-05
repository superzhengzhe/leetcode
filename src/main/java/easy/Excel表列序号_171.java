package easy;

/**
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 * @author zz
 * @date 2021/1/5 13:51
 */
public class Excel表列序号_171 {

    /**
     * 做法：遍历
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++) {
            int num = chars[i] - 'A' + 1;
            count = count * 26 + num;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Excel表列序号_171().titleToNumber("A"));
        System.out.println(new Excel表列序号_171().titleToNumber("AB"));
        System.out.println(new Excel表列序号_171().titleToNumber("ZY"));
    }

}
