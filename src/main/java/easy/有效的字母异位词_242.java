package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @author zz
 * @date 2021/1/17 23:42
 */
public class 有效的字母异位词_242 {

    /**
     * 做法：哈希表，但是使用数组替换，提高算法效率
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            hash[c - 'a']--;
        }
        for (int i = 0;i < 26;i++) {
            if (hash[i] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 做法：哈希表
     * 使用一个哈希表保存s出现的字母及次数
     * 遍历t，如果在哈希表中未出现，则返回false。如果出现，则次数减1。当次数为0时，在哈希表中移除该元素
     * 最后判断哈希表是否存在元素，存在返回false，否则返回true
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (Character c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        if (map.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new 有效的字母异位词_242().isAnagram(s, t));

        s = "rat";
        t = "car";
        System.out.println(new 有效的字母异位词_242().isAnagram(s, t));

        s = "ab";
        t = "a";
        System.out.println(new 有效的字母异位词_242().isAnagram(s, t));
    }

}
