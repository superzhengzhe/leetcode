package 剑指offer;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * @author zz
 * @date 2021/1/29 15:27
 */
public class 顺时针打印矩阵 {

    /**
     * 做法：
     * 模拟指针顺时针转动，这里需要使用一个数组来判断这个位置是否遍历过
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        if (matrix.length == 1) {
            return matrix[0];
        }
        int row = 0, col = 0, index = 0;
        int top = 0, buttom = matrix.length, left = 0, right = matrix[0].length;
        if (matrix[0].length == 1) {
            int[] res = new int[matrix.length];
            while (row <= matrix.length - 1) {
                res[index++] = matrix[row][col];
                row++;
            }
            return res;
        }
        int[] res = new int[matrix.length * matrix[0].length];
        while (row >= top && row < buttom && col >= left && col < right) {
            while (row >= top && row < buttom && col >= left && col < right) {
                res[index++] = matrix[row][col];
                col++;
            }
            col--;
            row++;
            top++;
            while (row >= top && row < buttom && col >= left && col < right) {
                res[index++] = matrix[row][col];
                row++;
            }
            row--;
            col--;
            right--;
            while (row >= top && row < buttom && col >= left && col < right) {
                res[index++] = matrix[row][col];
                col--;
            }
            col++;
            row--;
            buttom--;
            while (row >= top && row < buttom && col >= left && col < right) {
                res[index++] = matrix[row][col];
                row--;
            }
            row++;
            col++;
            left++;
        }
        return res;
    }

    /**
     * 做法：
     * 模拟指针顺时针转动，这里需要使用一个数组来判断这个位置是否遍历过
     * @param matrix
     * @return
     */
    public int[] spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        if (matrix.length == 1) {
            return matrix[0];
        }
        int row = 0, col = 0, index = 0;
        if (matrix[0].length == 1) {
            int[] res = new int[matrix.length];
            while (row <= matrix.length - 1) {
                res[index++] = matrix[row][col];
                row++;
            }
            return res;
        }
        int[][] use = new int[matrix.length][matrix[0].length];
        int[] res = new int[matrix.length * matrix[0].length];
        while (use[row][col] != -1) {
            while (col <= matrix[row].length - 1 && use[row][col] != -1) {
                res[index++] = matrix[row][col];
                use[row][col] = -1;
                col++;
            }
            col--;
            row++;
            while (row <= matrix.length - 1 && use[row][col] != -1) {
                res[index++] = matrix[row][col];
                use[row][col] = -1;
                row++;
            }
            row--;
            col--;
            while (col >= 0 && use[row][col] != -1) {
                res[index++] = matrix[row][col];
                use[row][col] = -1;
                col--;
            }
            col++;
            row--;
            while (row >= 0 && use[row][col] != -1) {
                res[index++] = matrix[row][col];
                use[row][col] = -1;
                row--;
            }
            row++;
            col++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9}};
        int[] res = new 顺时针打印矩阵().spiralOrder(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }

        nums = new int[][]{new int[]{1}};
        res = new 顺时针打印矩阵().spiralOrder(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }

        nums = new int[][]{new int[]{1},new int[]{2}};
        res = new 顺时针打印矩阵().spiralOrder(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

}