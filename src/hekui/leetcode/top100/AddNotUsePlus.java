package hekui.leetcode.top100;

public class AddNotUsePlus {

    public static int add(int a, int b) {
        int c = a;
        while (b != 0) {
            c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int ans = add(31, 5);
        System.out.println(ans);
    }

}
