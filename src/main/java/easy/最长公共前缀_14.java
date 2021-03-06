package easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * @author zz
 */
public class 最长公共前缀_14 {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1;i < strs.length;i++) {
            String str = strs[i];
            int j = 0;
            for (;j < prefix.length() && j <str.length();j++) {
                if (prefix.charAt(j) != str.charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
            if ("".equals(prefix)) {
                return prefix;
            }
        }
        return prefix;
    }

}
