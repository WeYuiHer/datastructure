package 背包问题;

//完全背包 每种物品有无数件
public class BackPack2 {

    public static int getMaxValue(int[] v, int[] w, int c) {
        int[] dp = new int[c + 1];
        int n = v.length;
        for (int i = 0; i < n; i++)
            for (int j = w[i]; j <= c; j++)
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);

        return dp[c];
    }

    public static void main(String[] args) {
        int[] v = {3, 4, 2, 4, 2, 1, 5};
        int[] w = {3, 2, 4, 5, 3, 1, 3};
        int maxValue = getMaxValue(v, w, 10);
        System.out.println(maxValue);
    }

}
