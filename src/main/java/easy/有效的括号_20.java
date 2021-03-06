package easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 * 输入：s = "{[]}"
 * 输出：true
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * @author zz
 */
public class 有效的括号_20 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack stack = new Stack();
        for (int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if ("(".equals(Character.toString(c)) || "[".equals(Character.toString(c)) || "{".equals(Character.toString(c)) ) {
                stack.push(c);
            }
            if (stack.size() == 0) {
                return false;
            }
            if (")".equals(Character.toString(c)) && !"(".equals(Character.toString((Character) stack.pop()))) {
                return false;
            }
            if ("]".equals(Character.toString(c)) && !"[".equals(Character.toString((Character) stack.pop()))) {
                return false;
            }
            if ("}".equals(Character.toString(c)) && !"{".equals(Character.toString((Character) stack.pop()))) {
                return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

}
