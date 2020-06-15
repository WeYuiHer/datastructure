package hekui.leetcode.dp;

import java.util.Arrays;

/*
 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
 * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
 * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 *
 *500/5  200/3 300/4 350/3   400/5
 *   0-1背包
 * */
public class Question1 {
    static int[] v = {500, 200, 300, 350, 300};    //金矿的价值
    static int[] p = {5, 3, 4, 3, 5};              //需要的人数
    static int person = 10;                         // 总人数
    static int n = v.length;
    static int[][] dp = new int[n + 1][person + 1];

    public static int dp1() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= person; j++) {
                if (j >= p[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - p[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[n][person];
    }

    public static int[] getSelected() {
        int[] arr = new int[n];
        int i = n, j = person;
        while (i > 0 && j > 0) {
            int person = p[i - 1];
            int val = v[i - 1];
            if (dp[i][j] == (dp[i - 1][j - person] + val)) {
                //     System.out.println(i+"  "+j);
                arr[i - 1] = 1;
                j -= person;
            }
            i--;
        }
        return arr;
    }

    public static int dp2() {
        int[] dp = new int[person + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = person; j > 0; j--) {
                if (j >= p[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - p[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[person];
    }


    public static void main(String[] args) {
        int max = dp1();
        System.out.println(max);
        System.out.println(dp2());
        // System.out.println(Arrays.toString(getSelected()));
    }

}
