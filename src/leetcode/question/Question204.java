package leetcode.question;

/*
统计所有小于非负整数 n 的质数的数量。
示例:
输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
* */
public class Question204 {

    public static int countPrimes(int n) {
        boolean[] A = new boolean[n + 1];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!A[i]) {
                boolean f = check(i);
                if (f) {
                    cnt++;
                }
                for (int j = 2 * i; j <= n; j += i)
                    A[j] = true;
            }
        }
        return cnt;
    }

    public static int countPrimes2(int n) {
        int cnt = 0;
        boolean[] A = new boolean[n];
        double x = Math.sqrt(n);
        for (int i = 2; i < x; i++) {
            if (!A[i]) {
                for (int j = i * i; j < n; j += i)
                    A[j] = true;
            }
        }
        for (int i = 2; i < n; i++) {
            if (!A[i])
                cnt++;
        }
        return cnt;
    }


    public static boolean check(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int i = countPrimes2(2);
        System.out.println(i);
    }

}
