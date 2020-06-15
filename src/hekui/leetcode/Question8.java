package hekui.leetcode;

public class Question8 {

    public static int myAtoi(String str) {
        boolean f = false, f2 = false;
        char[] chs = str.toCharArray();
        int i = 0, len = str.length();
        char c = ' ', c2 = ' ';
        int x = 0, pre = 0;

        while (i < len) {
            c = chs[i++];
            if (c == ' ' && !f2 && c2 == ' ') continue;
            else if (c == '+' && c2 == ' ') ;
            else if (c == '-' && c2 == ' ') {
                f = true;
            } else if (c >= '0' && c <= '9') {
                f2 = true;
                pre = x;
                x = x * 10 + c - '0';
                if (x / 10 != pre) return f ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                return f ? -x : x;
            }
            c2 = c;
        }
        return f ? -x : x;
    }

    public static void main(String[] args) {
        //  System.out.println(Integer.MIN_VALUE);
        int x = myAtoi(" + 1");
        System.out.println(x);
    }

}
