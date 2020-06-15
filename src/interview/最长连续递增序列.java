package interview;

import java.util.Arrays;

public class 最长连续递增序列 {

    public static int[] longestIncreaseSubArr(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        int end = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                if (max < dp[i]) {
                    max = dp[i];
                    end = i;
                }
            } else
                dp[i] = 1;
        }
        System.out.println("maxLen = " + max);
        //找到该序列
        return Arrays.copyOfRange(arr, end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 4, 5, 0, 1, 2, 3, 4, 5};
        int[] subArr = longestIncreaseSubArr(arr);
        System.out.println(Arrays.toString(subArr));
    }

}
