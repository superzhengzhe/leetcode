package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数numRows，生成杨辉三角的前numRows行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @author zz
 * @date 2020/12/31 16:43
 */
public class 杨辉三角_118 {

    /**
     * 做法：for循环解决
     * @param numRows
     * @return
     */    
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        if (numRows == 1) {
            return Arrays.asList(Arrays.asList(1));
        }
        if (numRows == 2) {
            return Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1));
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        res.add(Arrays.asList(1, 1));
        for (int i = 3;i <= numRows;i++) {
            List<Integer> pre = res.get(i - 2);
            List<Integer> line = new ArrayList<>(i);
            line.add(pre.get(0));
            for (int j = 1;j < pre.size();j++) {
                line.add(pre.get(j - 1) + pre.get(j));
            }
            line.add(pre.get(pre.size() - 1));
            res.add(line);
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(new 杨辉三角_118().generate(num));
    }

}
