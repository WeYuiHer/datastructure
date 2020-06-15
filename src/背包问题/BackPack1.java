package 背包问题;

import java.util.ArrayList;
import java.util.List;

//01背包 每种物品最多放一件
public class BackPack1 {
    //得到最大值
    public static int getMaxValue(int[] v, int[] w, int c) {
        int n = v.length;
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
            }
        }
        List<Integer> what = findWhat(dp, v, w, c);
        System.out.println(what);
        return dp[n][c];
    }

    //得到选择的物品下标
    public static List<Integer> findWhat(int[][] dp, int[] v, int[] w, int c) {
        int i = v.length;
        List<Integer> list = new ArrayList<>();
        while (i > 0 && c > 0) {
            if (dp[i][c] == dp[i - 1][c - w[i - 1]] + v[i - 1]) {
                list.add(i - 1);
                c -= w[i - 1];
            }
            i--;
        }
        return list;
    }

    //空间优化
    public static int getMaxValue2(int[] v, int[] w, int c) {
        int n = v.length;
        int[] dp = new int[c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = c; j > 0; j--) {
                if (j >= w[i])
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[c];
    }

    public static void main(String[] args) {
        System.out.println((92 ^ 500) % 11);
        int[] v = {3, 2, 4, 5, 1, 2, 4};
        int[] w = {2, 2, 3, 1, 2, 4, 4};
        int c = 10;
        int max = getMaxValue(v, w, c);
        System.out.println(max);
        System.out.println(getMaxValue2(v, w, c));
    }

}
