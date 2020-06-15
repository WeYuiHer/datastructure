package leetcode.question;

/*
* 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。
* 我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
* 其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
为了尽快到达公主，骑士决定每次只向右或向下移动一步。

* */
public class Question174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = dungeon[0][0] - 1;
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + dungeon[i][0];
        for (int i = 1; i < n; i++)
            dp[0][i] = dp[0][i - 1] + dungeon[0][i];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + dungeon[i][j];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
        return Math.abs(traceBack(dp, dungeon, m, n));
    }

    public int traceBack(int[][] dp, int[][] dungeon, int m, int n) {
        int i = m - 1, j = n - 1;
        int min = dp[i][j];
        while (i != 0) {
            int x = dungeon[i][j];
            if (dp[i - 1][j] + x == dp[i][j]) {
                min = Math.min(dp[i - 1][j], min);
                i--;
            } else {
                min = Math.min(dp[i][j - 1], min);
                j--;
            }
        }
        return min;
    }


}
