package newcoder.book;

public class Mincoins {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return 0;
        return process(coins, 0, amount);
    }

    public int process(int[] coins, int i, int rest) {
        if (i == coins.length) {
            return rest == 0 ? 0 : -1;
        }
        int x = -1;
        for (int j = 0; j * coins[i] <= rest; j++) {
            int next = process(coins, i + 1, rest - j * coins[i]);
            if (next != -1) {
                x = x == -1 ? next + j : Math.min(next + j, x);
            }
        }
        return x;
    }

    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i <= amount; i++)
            dp[n][i] = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = -1;
                if (dp[i + 1][j] != -1)
                    dp[i][j] = dp[i + 1][j];
                if (j >= coins[i] && dp[i][j - coins[i]] != -1) {
                    if (dp[i][j] == -1)
                        dp[i][j] = dp[i][j - coins[i]] + 1;
                    else
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
                }
            }
        }
        return dp[0][amount];
    }

}
