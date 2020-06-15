package leetcode.contest;

import java.util.EnumSet;

/*
有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
* */
public class Question4 {

    public static int numWays(int steps, int arrLen) {
        int[][] dp = new int[steps + 1][arrLen + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 1; j <= arrLen; j++) {
                if (j == 1)
                    dp[i][j] = dp[i - 1][2];
                else if (j == arrLen)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j - 1] % 1000000007 + dp[i - 1][j + 1] % 1000000007;
                dp[i][j] = (dp[i][j] % 1000000007 + dp[i - 1][j] % 1000000007) % 1000000007;

            }
        }
        return dp[steps][1];
    }

    public static int numWays2(int steps, int arrLen) {
        int mod = 1000000007;
        int[] dp = new int[arrLen + 1];
        dp[1] = 1;
        for (int i = 1; i <= steps; i++) {
            int leftUp = dp[1];
            for (int j = 1; j <= arrLen; j++) {
                int temp = dp[j];
                int x = dp[j];
                if (j == 1)
                    dp[j] = (dp[2] + x) % mod;
                else if (j == arrLen)
                    dp[j] = (leftUp + x) % mod;
                else
                    dp[j] = ((leftUp + dp[j + 1]) % mod + x) % mod;
                leftUp = temp;
            }
        }
        return dp[1];
    }


    public int move(int rest, int cur, int arrLen) {
        if (rest == 0)
            return cur == 0 ? 1 : 0;
        else if (cur == 0)
            return move(rest - 1, 1, arrLen);
        else if (cur == arrLen - 1)
            return move(rest - 1, arrLen - 2, arrLen);
        else
            return (move(rest - 1, cur - 1, arrLen) + move(rest - 1, cur + 1, arrLen)) % 1000000007;
    }

    public static void main(String[] args) {
        //434
        //291270
        //500
        //969997
        int x = numWays2(500, 969997);
        System.out.println(x);
        //System.out.println(numWays(500  , 969997));
    }

}
