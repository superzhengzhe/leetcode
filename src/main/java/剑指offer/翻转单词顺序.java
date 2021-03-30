package 剑指offer;

/**
 * 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * 示例 2：
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @author zz
 * @date 2021/1/31 18:34
 */
public class 翻转单词顺序 {

    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println(new 翻转单词顺序().reverseWords1(str));

        str = "the sky is blue";
        System.out.println(new 翻转单词顺序().reverseWords1(str));
    }

    /**
     * 做法：双指针法
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int start = s.length() - 1, end = start;
        while (end >= 0) {
            while (end >= 0 && s.charAt(end) != ' ') {
                end--;
            }
            res.append(s.substring(end + 1, start + 1)).append(" ");
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            start = end;
        }
        return res.toString().trim();
    }

    /**
     * 做法：Java Api
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        StringBuilder res = new StringBuilder();
        String[] strings = s.trim().split(" ");
        for (int i = strings.length - 1;i >= 0;i--) {
            if (!strings[i].equals("")) {
                res.append(strings[i]).append(" ");
            }
        }
        return res.toString().trim();
    }

    public String reverseWords(String s) {
        String res = "";
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.trim().toCharArray();
        for (int i = 0;i < chars.length;i++) {
            char ch = chars[i];
            if (ch == ' ') {
                if (stringBuilder.length() != 0) {
                    if (res.length() == 0) {
                        res = stringBuilder.toString() + res;
                    } else {
                        res = stringBuilder.toString() + " " + res;
                    }
                    stringBuilder = new StringBuilder();
                }
            } else {
                stringBuilder.append(ch);
            }
        }
        if (stringBuilder.length() != 0) {
            if (res.length() == 0) {
                res = stringBuilder.toString() + res;
            } else {
                res = stringBuilder.toString() + " " + res;
            }
        }
        return res;
    }

}
