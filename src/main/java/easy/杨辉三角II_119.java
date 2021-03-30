package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角II
 * 给定一个非负索引k，其中 k≤33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * @author zz
 * @date 2021/1/1 14:52
 */
public class 杨辉三角II_119 {

    /**
     * 做法：for循环
     * 要实现空间复杂度为o(k)，则需要每次都覆盖上次计算的结果
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        if (rowIndex == 1) {
            return Arrays.asList(1, 1);
        }
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(1);
        for (int i = 3;i <= rowIndex + 1;i++) {
            res.add(i - 1, res.get(i - 2));
            for (int j = i - 2;j >= 1;j--) {
                res.set( j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 杨辉三角II_119().getRow(3));
    }

}
