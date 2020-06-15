package hekui.leetcode.top100;

/*
* 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
示例:
输入:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
输出: 4
* */
public class Question221 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }
        return max * max;
    }

    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0, pre = 0, temp = 0;
        int[] dp = new int[cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(dp[j], Math.min(dp[j - 1], pre)) + 1;
                    max = Math.max(max, dp[j]);
                } else
                    dp[j] = 0;
                pre = temp;
            }
        }
        return max * max;
    }

}
