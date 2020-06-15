package hekui.leetcode;

//通配符匹配
public class Question44 {
    short[][] dp;

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        dp = new short[n + 1][m + 1];
        return match(s, p, 0, 0);
    }

    public boolean match(String s, String p, int i, int j) {
        if (dp[i][j] != 0)
            return dp[i][j] == 1;
        if (i == s.length() && j == p.length()) {
            dp[i][j] = 1;
            return true;
        }
        if (i != s.length() && j == p.length()) {
            dp[i][j] = -1;
            return false;
        }
        if (i == s.length() && j != p.length()) {
            while (j < p.length() && p.charAt(j) == '*')
                j++;
            dp[i][j] = (short) (j == p.length() ? 1 : -1);
            return j == p.length();
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            boolean f = match(s, p, i + 1, j + 1);
            ;
            dp[i][j] = (short) (f ? 1 : -1);
            return f;
        }
        if (p.charAt(j) == '*') {
            boolean f = match(s, p, i, j + 1) || match(s, p, i + 1, j);
            dp[i][j] = (short) (f ? 1 : -1);
            return f;
        }
        return false;
    }

    public boolean match2(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        int i = 0, j = 0, i2 = -1, j2 = -1;
        while (i < len1) {
            if (j != len2 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j != len2 && p.charAt(j) == '*') {
                i2 = i + 1;
                j2 = ++j;
            } else {
                if (j2 != -1) {
                    i = i2++;
                    j = j2;
                } else
                    return false;
            }
        }
        while (j < len2 && p.charAt(j) == '*')
            j++;
        return j == len2;
    }


    public static void main(String[] args) {
        Question44 q = new Question44();
        String s = "aa";
        String p = "*";
        boolean match = q.isMatch(s, p);
        System.out.println(match + "  " + q.match2(s, p));
    }


}
