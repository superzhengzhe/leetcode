package 字符串.简单;

/**
 * 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 * @author zz
 * @date 2020/12/7 13:33
 */
public class 最后一个单词的长度_58 {

    /**
     * 做法：从最后开始遍历，先去掉空格，然后count++直到遇到空格，返回即可
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        for (int i = s.length() - 1;i >= 0;i--) {
            if (s.charAt(i) == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(new 最后一个单词的长度_58().lengthOfLastWord(s));
        s = "a ";
        System.out.println(new 最后一个单词的长度_58().lengthOfLastWord(s));
    }


}
