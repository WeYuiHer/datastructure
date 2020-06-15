package newcoder.book;

import java.util.Arrays;

/*
 * 最长上升序列
 * */
public class LIS {

    public static int[] getdp1(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int[] getdp2(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] A = new int[n];
        A[0] = arr[0];
        dp[0] = 1;
        int l = 0, r = 0, right = 0;
        for (int i = 1; i < n; i++) {
            l = 0;
            r = right;
            int mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (A[mid] < arr[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            A[l] = arr[i];
            dp[i] = l + 1;
            right = Math.max(l, right);
        }
        return dp;
    }


    public static int[] generateLIS(int[] dp, int[] arr) {
        int len = 0;
        int end = 0;
        for (int i = 1; i < dp.length; i++) {
            if (len < dp[i]) {
                len = dp[i];
                end = i;
            }
        }
        System.out.println("len = " + len);
        int[] LIS = new int[len];
        LIS[--len] = arr[end];
        int i = end;
        int j = i - 1;
        while (len > 0) {
            if (arr[i] > arr[j] && dp[i] == dp[j] + 1) {
                LIS[--len] = arr[j];
                i = j;
            }
            j--;
        }
        return LIS;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 3, 4, 5, 2, 8};
        System.out.println(Arrays.toString(arr));
        int[] dp = getdp1(arr);
        int[] dp2 = getdp2(arr);
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dp2));
		/*
		int[] lis = generateLIS(dp, arr);
		System.out.println(Arrays.toString(lis));
		*/
    }

}
