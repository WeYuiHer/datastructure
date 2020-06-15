package leetcode.question;
/*
* 一.最长公共子序列问题(LCS问题)
给定两个字符串A和B，长度分别为m和n，要求找出它们最长的公共子序列，并返回其长度。
* */

public class LCS {

    public static int lcs(String A, String B) {
        int len1 = A.length();
        int len2 = B.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= len2; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }

    /*
    * 最长公共子串问题
    给定两个字符串A和B，长度分别为m和n，要求找出它们最长的公共子串，并返回其长度
    * */
    public static int lcs2(String A, String B) {
        int len1 = A.length();
        int len2 = B.length();
        int max = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= len2; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }
        return max;
    }

    /*
     *最长回文子串
     * */
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > max) {
                max = len;
                //   System.out.println("len : "+max+"");
                start = i - (len - 1) / 2;
                end = i + len / 2;
                //   System.out.println("i  start  end ="+i+" "+ start+" "+end);
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
      /*  String a = "appleabcd";
        String b = "asplceabc";
        int x = lcs2(a,b);
        System.out.println(x);*/

        String str = "abcdaaddbabddaa";
        String s = longestPalindrome(str);
        System.out.println(s);

    }


}
