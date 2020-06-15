package leetcode.question;

/*
* 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

* */
public class Question63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else
                break;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0)
                dp[0][i] = 1;
            else
                break;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int max = m > n ? m : n;
        int min = m < n ? m : n;
        boolean rowMore = m > n;
        int[] dp = new int[min];
        for (int i = 0; i < min; i++) {
            if (rowMore) {
                if (obstacleGrid[0][i] == 0)
                    dp[i] = 1;
                else
                    break;
            } else {
                if (obstacleGrid[i][0] == 0)
                    dp[i] = 1;
                else
                    break;
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < min; j++) {
                if (rowMore && obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else if (!rowMore && obstacleGrid[j][i] == 1)
                    dp[j] = 0;
                else
                    dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[min - 1];
    }
}
