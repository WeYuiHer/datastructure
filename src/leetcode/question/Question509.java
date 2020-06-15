package leetcode.question;

//斐波拉切数
public class Question509 {
    public static int fib(int N) {
        int x = 0;
        int y = 1;
        if (N < 2)
            return N;
        for (int i = 2; i <= N; i++) {
            int t = y;
            y = x + y;
            x = t;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));

    }

}
