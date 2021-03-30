package 剑指offer;

/**
 * 二维数组中的查找
 * 在一个 n * m 的二维数组中
 * 每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序
 * 请完成一个高效的函数
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * 给定target=20，返回false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * @author zz
 * @date 2021/1/30 16:21
 */
public class 二维数组中的查找 {

    /**
     * 做法：双指针法
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                new int[]{1,2,3,4,5},
                new int[]{6,7,8,9,10},
                new int[]{11,12,13,14,15},
                new int[]{16,17,18,19,20},
                new int[]{21,22,23,24,25}};
        System.out.println(new 二维数组中的查找().findNumberIn2DArray(nums, 19));
    }

}
