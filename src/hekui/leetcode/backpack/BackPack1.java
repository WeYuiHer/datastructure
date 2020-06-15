package hekui.leetcode.backpack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackPack1 {
    /*private static int[] weight = {2,3,4,5};
    private static int[] value = {3,4,5,6};*/
    private static int[] weight = {2, 3, 4, 5, 3, 6, 1};
    private static int[] value = {3, 4, 5, 6, 3, 10, 1};


    private static int capacity = 12;
    private static int num = weight.length;
    private static int[][] dp = new int[num + 1][capacity + 1];

    //0-1背包 时间复杂度:O(mn) 空间复杂度：O(mn)
    public static int backPage1() {

        //dp[i][j] 表示前i个物品在容量为j时的最大价值
        for (int i = 1; i <= num; i++) {     //物品
            for (int j = 1; j <= capacity; j++) { //容量
                if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[num][capacity];
    }

    //优化空间的0-1背包
    public static int backPack() {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < num; i++) {
            for (int j = capacity; j > 0; j--) {
                if (j >= weight[i])
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[capacity];
    }

    //查看选择的是哪些物品
    public static int[] getThings() {
        int[] arr = new int[num];
        int j = capacity;
        for (int i = num; i > 0; i--) {
            if (dp[i][j] != dp[i - 1][j]) {
                arr[i - 1] = 1;     //选择了该物品
                j = j - weight[i - 1];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int max = backPage1();
        System.out.println(max);
        int[] arr = getThings();
        System.out.println(Arrays.toString(arr));
    }


}
