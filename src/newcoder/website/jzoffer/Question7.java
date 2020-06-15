package newcoder.website.jzoffer;

import java.util.Arrays;

//变态跳台阶
public class Question7 {
    public static int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] * 2;
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }

    //1     1
    //2     11 2
    //3     111 12 21 3
    //4     1111 112 121 211 22 31 13 4
    public static void main(String[] args) {
        int i = JumpFloorII(5);

    }

}
