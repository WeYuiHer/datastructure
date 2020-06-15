package newcoder.website.jzoffer;

/*
 * 不用 + 实现两数相加
 * */
public class Question20 {
    public static int Add(int num1, int num2) {
        int xor = num1 ^ num2;
        int and = (num1 & num2) << 1;
        while (and != 0) {
            int a = xor;
            xor = xor ^ and;
            and = (a & and) << 1;
        }
        return xor;
    }

    public static void main(String[] args) {
        int add = Add(31, 0);
        System.out.println(add);
    }

}
