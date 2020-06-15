package hekui.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

//最长上升子序列
public class Question2 {

    public static int LIS(int[] nums) {
        //   List<Integer> l = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int x = 0, max = 0, ans = 0;
        for (int i = 1; i < n; i++) {
            x = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < x)
                    max = Math.max(max, dp[j] + 1);
            }
            //System.out.println(max);
            dp[i] = max;
            ans = ans >= max ? ans : max;
            max = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 6, 5, 6};
        int lis = LIS(nums);
        System.out.println(lis);
    }

}
