package newcoder.book;

/*
 * 机器人达到指定位置方法数
 * */
public class RobotWalk {

    // N个格子 cur当前位置 rest剩余步数 P为目标位置
    public static int walk(int N, int cur, int rest, int P) {
        if (rest == 0)
            return cur == P ? 1 : 0;
        if (cur == 0)
            return walk(N, 1, rest - 1, P);
        else if (cur == N - 1)
            return walk(N, N - 2, rest - 1, P);
        else
            return walk(N, cur - 1, rest - 1, P) + walk(N, cur + 1, rest - 1, P);
    }

    // N个格子 cur当前位置 rest剩余步数 P为目标位置
    public static int walk2(int N, int cur, int rest, int P) {
        int[][] dp = new int[rest + 1][N + 1];
        dp[0][P] = 1;
        for (int i = 1; i <= rest; i++) {
            for (int j = 1; j < N; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][1];
                else if (j == N - 1)
                    dp[i][j] = dp[i - 1][N - 2];
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
            }
        }
        return dp[rest][cur];
    }


    public static void main(String[] args) {
        int ans = walk(5, 2, 3, 3);
        int ans2 = walk2(5, 2, 3, 3);
        System.out.println(ans);
        System.out.println(ans2);
    }


}
