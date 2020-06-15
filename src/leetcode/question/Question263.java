package leetcode.question;

/*
* 编写一个程序判断给定的数是否为丑数。
丑数就是只包含质因数 2, 3, 5 的正整数。
示例 1:
输入: 6
输出: true
解释: 6 = 2 × 3
示例 2:
输入: 8
输出: true
解释: 8 = 2 × 2 × 2
示例 3:
输入: 14
输出: false
解释: 14 不是丑数，因为它包含了另外一个质因数 7。
说明：
1 是丑数。
输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
* */
public class Question263 {

    public static boolean isUgly(int num) {
        if (num <= 0)
            return false;
        while (num != 1) {
            if (num % 2 == 0)
                num /= 2;
            else if (num % 3 == 0)
                num /= 3;
            else if (num % 5 == 0)
                num /= 5;
            else
                return false;
        }
        return true;
    }

    //找出第n个丑数
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            if (min == dp[i2] * 2)
                i2++;
            if (min == dp[i3] * 3)
                i3++;
            if (min == dp[i5] * 5)
                i5++;
            dp[i] = min;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
//		boolean f = isUgly(-1000);
//		System.out.println(f);

        System.out.println(nthUglyNumber(10));
    }

}
