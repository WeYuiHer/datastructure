package newcoder.book.dp;

//矩阵的最小路径和
public class Question1 {

    public static int minPathSum(int[][] map) {
        int m = map.length;
        int n = map[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = map[0][0];
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + map[i][0];
        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + map[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
        }
        return dp[m - 1][n - 1];
    }

    public static int minPathSum2(int[][] map) {
        int m = map.length;
        int n = map[0].length;
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        int[] dp = new int[min];
        dp[0] = map[0][0];
        boolean rowMore = m > n;
        for (int i = 1; i < min; i++)
            dp[i] = dp[i - 1] + (rowMore ? map[0][i] : map[i][0]);
        for (int i = 1; i < max; i++) {
            dp[0] = dp[0] + (rowMore ? map[i][0] : map[0][i]);
            for (int j = 1; j < min; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + (rowMore ? map[i][j] : map[j][i]);
            }
        }
        return dp[min - 1];
    }


    public static void main(String[] args) {
        int[][] map = {{1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}};
        int sum = minPathSum(map);
        System.out.println(sum);

        int sum2 = minPathSum2(map);
        System.out.println(sum2);

    }

}
