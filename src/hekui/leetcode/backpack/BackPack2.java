package hekui.leetcode.backpack;

import java.util.Arrays;

public class BackPack2 {
    private static int[] weight = {7, 3, 4, 5, 3, 6, 1};
    private static int[] value = {11, 4, 5, 6, 3, 10, 1};
    private static int capacity = 12;
    private static int num = weight.length;
    private static int[][] dp = new int[num + 1][capacity + 1];

    //完全背包
    public static int backPack1() {
        int max = 0;
        int w = 0, v = 0;
        //dp[i][j] 表示前i个物品在容量为j时的最大价值
        for (int i = 1; i <= num; i++) {     //物品
            w = weight[i - 1];
            v = value[i - 1];
            for (int j = 1; j <= capacity; j++) { //容量
                if (j >= w) {
                    for (int k = 0; k * w <= j; k++) {
                        max = Math.max(dp[i - 1][j - k * w] + k * v, max);
                    }
                    dp[i][j] = max;
                }
                max = 0;
            }
        }
        return dp[num][capacity];
    }

    //完全背包 优化空间
    public static int backPack2() {
        int[] dp = new int[capacity + 1];
        int max = 0;
        int w = 0, v = 0;
        //dp[i][j] 表示前i个物品在容量为j时的最大价值
        for (int i = 1; i <= num; i++) {     //物品
            w = weight[i - 1];
            v = value[i - 1];
            for (int j = capacity; j >= w; j--) { //容量
                for (int k = 0; k * w <= j; k++) {
                    max = Math.max(dp[j - k * w] + k * v, max);
                }
                dp[j] = max;
                max = 0;
            }
        }
        return dp[capacity];
    }


    //查看选择的是哪些物品
    public static int[] getThings() {
        int[] arr = new int[num];
        int j = capacity, i = num;
        while (j > 0) {
            if (dp[i][j] == dp[i][j - weight[i - 1]] + value[i - 1]) {
                arr[i - 1]++;
                j = j - weight[i - 1];
            } else
                i--;
        }
        return arr;
    }

    public static void main(String[] args) {
      /*  String a = "abc";
        String b = a.replace('a','A');
        System.out.println(b);
        System.out.println(a);
*/
       /* int max = backPack2();
        System.out.println(max);
        System.out.println(backPack1());*/
//        int[] arr = getThings();
//        System.out.println(Arrays.toString(arr));
    }


}
