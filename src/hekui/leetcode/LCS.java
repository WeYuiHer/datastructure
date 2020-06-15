package hekui.leetcode;

public class LCS {
    //最长公共子串
    public static int getLCSLength(String str, String str2, String maxStr) {
        int len1 = str.length(), len2 = str2.length();
        int[][] temp = new int[len1 + 1][len2 + 1];
        char[] ch1 = str.toCharArray();
        char[] ch2 = str2.toCharArray();
        //  System.out.println(len1+" "+len2);
        int max = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                    if (max < temp[i][j]) {
                        maxStr = "";
                        max = temp[i][j];
                        int x = i - 1, cnt = max;
                        while (x >= 0 && cnt > 0) {
                            maxStr = ch1[x] + maxStr;
                            cnt--;
                            x--;
                        }
                        //System.out.println("maxstr = "+maxStr);
                    }
                } else
                    temp[i][j] = 0;

            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "acbcbcef", str2 = "abcbced";
        String sub = "";
        int max = getLCSLength(str, str2, sub);
        System.out.println(max + "  " + sub);

    }

}
