package easy;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * @author zz
 * @date 2021/1/1 21:27
 */
public class 验证回文串_125 {

    /**
     * 做法：直接判断即可
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start != end){
            while (start < chars.length && !Character.isLetterOrDigit(chars[start])) {
                start++;
            }
            while (end > 0 && !Character.isLetterOrDigit(chars[end])) {
                end--;
            }
            if (start >= end) {
                return true;
            }
            if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new 验证回文串_125().isPalindrome(s));

        s = "race a car";
        System.out.println(new 验证回文串_125().isPalindrome(s));

        s = ".,";
        System.out.println(new 验证回文串_125().isPalindrome(s));
    }

}
