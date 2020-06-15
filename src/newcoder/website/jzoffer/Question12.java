package newcoder.website.jzoffer;

/*
* 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0
* */
public class Question12 {
    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1d;
        int ex = Math.abs(exponent);
        double ans = 1;
        while (ex != 0) {
            if ((ex & 1) == 1)
                ans *= base;
            base *= base;
            ex >>= 1;
        }
        return exponent > 0 ? ans : 1 / ans;
    }

    public static void main(String[] args) {
        double base = -2.4;
        int exponent = -4;
        System.out.println(Power(base, exponent));
        System.out.println(Math.pow(base, exponent));
    }

}
