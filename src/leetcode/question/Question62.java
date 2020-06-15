package leetcode.question;

/*
* 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
* */
public class Question62 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int uniquePaths2(int m, int n) {
        //boolean rowMore = m>n;
        int max = m > n ? m : n;
        int min = m < n ? m : n;
        int[] dp = new int[min];
        for (int i = 0; i < min; i++)
            dp[i] = 1;
        for (int i = 1; i < max; i++) {
            for (int j = 1; j < min; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[min - 1];
    }

    public static void main(String[] args) {
        int ans = uniquePaths(7, 3);
        System.out.println(ans);
        System.out.println(uniquePaths2(7, 3));
    }

}
