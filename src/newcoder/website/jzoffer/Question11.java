package newcoder.website.jzoffer;

/*
 * 二进制中一的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * */
public class Question11 {

    public static int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int number = NumberOf1(-8);
        System.out.println(number);
    }


}
