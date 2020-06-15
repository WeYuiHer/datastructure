package leetcode.question;

//判断一个数是否是2的整数次幂
public class Question231 {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + "  " + Integer.MIN_VALUE);
        boolean powerOfTwo = isPowerOfTwo(-2147483648);
        System.out.println(powerOfTwo);
    }
}
