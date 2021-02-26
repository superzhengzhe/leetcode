package 剑指offer;

/**
 * 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 * @author zz
 * @date 2021/2/26 14:47
 */
public class 替换空格 {

    /**
     * 做法1：Java Api
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * 做法2：遍历
     * 申请一个数组，容量为源字符串数组的3倍（保证容量是充足的）
     * 遍历原有字符串，匹配到非空则直接写入，匹配到空则写入%20，最后返回即可
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = new char[s.length() * 3];
        int index = 0;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            } else {
                chars[index++] = s.charAt(i);
            }
        }
        String result = new String(chars, 0, index);
        return result;
    }

    public static void main(String[] args) {
        //We%20are%20happy.
        System.out.println(new 替换空格().replaceSpace("We are happy."));
        System.out.println(new 替换空格().replaceSpace2("We are happy."));
    }

}
