package 字符串.简单;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 同构字符串
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * @author zz
 * @date 2021/1/10 18:09
 */
public class 同构字符串_205 {

    /**
     * 做法：优化，仅使用一个数组
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] res = new int[256];
        for (int i = 0;i <res.length;i++) {
            res[i] = -1;
        }
        char source, target;
        for (int i = 0;i < s.length();i++) {
            source = s.charAt(i);
            target = t.charAt(i);
            int val = res[source];
            if (val == -1) {
                for (int j = 0;j <res.length;j++) {
                    if (res[j] == target) {
                        return false;
                    }
                }
                res[source] = target;
            } else if (val != target) {
                return false;
            }
        }
        return true;
    }

    /**
     * 做法：使用两个数组替换两个哈希表
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic1(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] res = new int[256];
        int[] arr = new int[256];
        for (int i = 0;i <res.length;i++) {
            res[i] = -1;
            arr[i] = -1;
        }
        char source, target;
        for (int i = 0;i < s.length();i++) {
            source = s.charAt(i);
            target = t.charAt(i);
            int val = res[source];
            if (val == -1) {
                if (arr[target] != -1) {
                    return false;
                }
                arr[target] = target;
                res[source] = target;
            } else if (val != target) {
                return false;
            }
        }
        return true;
    }

    /**
     * 做法：双哈希表法
     * 需要做到互相映射，a映射b，同时b映射a，可以使用两个哈希表解决
     * 另外，根据题意，b可以不映射到a，只需要保证b不重复出现即可，因此一个map可以使用set结构替代
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic0(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet();
        char source, target;
        for (int i = 0;i < s.length();i++) {
            source = s.charAt(i);
            target = t.charAt(i);
            Character val = map.get(source);
            if (val == null) {
                if (set.contains(target)) {
                    return false;
                }
                set.add(target);
                map.put(source, target);
            } else if (val != target) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        //true
        System.out.println(new 同构字符串_205().isIsomorphic(s, t));

        s = "foo";
        t = "bar";
        //false
        System.out.println(new 同构字符串_205().isIsomorphic(s, t));

        s = "paper";
        t = "title";
        //true
        System.out.println(new 同构字符串_205().isIsomorphic(s, t));

        s = "badc";
        t = "baba";
        //false
        System.out.println(new 同构字符串_205().isIsomorphic(s, t));
    }

}
