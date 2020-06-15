package newcoder.book;

import java.util.Arrays;

/*
 * 最长公共子序列
 * */
public class LCSE {

    public static int longestCommonSubsequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len2; i++) {
            if (ch1[0] == ch2[i]) {
                while (i < len2)
                    dp[0][i++] = 1;
            }
        }
        for (int i = 0; i < len1; i++) {
            if (ch2[0] == ch1[i]) {
                while (i < len1)
                    dp[i++][0] = 1;
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (ch1[i] == ch2[j])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        /*
         * 打印dp数组
         * */
		/*for(int i=0;i<len1;i++){
			for(int j=0;j<len2;j++){
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}*/
        return dp[len1 - 1][len2 - 1];
    }

    //空间优化
    public static int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        m++;
        n++;
        int[] arr = new int[n];
        char[] arr1 = ("#" + text1).toCharArray();
        char[] arr2 = ("#" + text2).toCharArray();
        int temp;
        int now;
        for (int i = 1; i < m; i++) {
            temp = 0;
            for (int j = 1; j < n; j++) {
                now = arr[j];
                if (arr1[i] == arr2[j]) {
                    arr[j] = temp + 1;
                } else {
                    arr[j] = Math.max(arr[j - 1], arr[j]);
                }
                temp = now;
            }
        }
        return arr[n - 1];
    }

    //以下有错
    public static int longestCommonSubsequence3(String text1, String text2) {
        text1 = "#" + text1;
        text2 = "#" + text2;
        int len1 = text1.length();
        int len2 = text2.length();
        int max = Math.max(len1, len2);
        int min = Math.min(len1, len2);
        int[] dp = new int[min];

        int temp;
        for (int j = 1; j < min; j++) {
            temp = 0;
            for (int i = 1; i < max; i++) {
                if (len1 > len2) {
                    dp[i] = Math.max(dp[i - 1], dp[i]);
                    if (text1.charAt(j) == text2.charAt(i)) {
                        dp[i] = Math.max(dp[i], temp + 1);
                    }
                } else {
                    dp[i] = Math.max(dp[i - 1], dp[i]);
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i] = Math.max(dp[i], temp + 1);
                    }
                }
            }
            temp = dp[j];
        }
        return dp[min - 1];
    }


    public static void main(String[] args) {
        //String text1 = "bsbininm", text2 = "jmjkbkjkv";
        String text1 = "abcde", text2 = "ace";

        int i = longestCommonSubsequence(text1, text2);
        System.out.println(i);
        System.out.println(longestCommonSubsequence2(text1, text2));
    }

}
