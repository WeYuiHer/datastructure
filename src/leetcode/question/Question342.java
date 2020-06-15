package leetcode.question;

public class Question342 {
    //判断一个数是否是4的次幂

    /**
     * 100       4
     * 10000     16
     * 1000000   64
     */
    public static boolean isPowerOfFour(int num) {
        if ((num & (num - 1)) != 0)
            return false;
        num = num - 1;
        int x = 0;
        while (num != 0) {
            num = num >> 1;
            x++;
        }
        return (x & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(-4));
    }

}
