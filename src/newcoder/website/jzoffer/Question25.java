package newcoder.website.jzoffer;

/**
 * 从1 到 n 中1出现的次数
 * 1~13中包含1的数字有1、10、11、12、13因此共出现6次
 */

public class Question25 {

    public static int numberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        int pre = 0;
        while (n != 0) {
            int x = n % 10;
            if (x >= 1) {
                if (cnt == 0)
                    cnt = (x + 1) * cnt + pre + 1;
                else
                    ;
            }
            pre = x;
            n /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int cnt = numberOf1Between1AndN_Solution(10);
        System.out.println(cnt);
    }

}
