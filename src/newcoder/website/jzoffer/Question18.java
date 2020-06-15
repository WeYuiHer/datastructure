package newcoder.website.jzoffer;

/*
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * */
public class Question18 {

    public static String LeftRotateString(String str, int n) {
        if (str == null || str.equals("") || n <= 0) return str;
        n = n % str.length();
        StringBuffer s1 = new StringBuffer(str.substring(0, n));
        StringBuffer s2 = new StringBuffer(str.substring(n, str.length()));
        String s3 = s1.reverse().toString() + s2.reverse().toString();
        String ss = new StringBuffer(s3).reverse().toString();
        return ss;
    }

    public static String reverse(String str) {
        char[] chs = new char[str.length()];
        int index = 0;
        for (int i = str.length() - 1; i >= 0; i--)
            chs[index++] = str.charAt(i);
        return new String(chs);
    }

    public static void main(String[] args) {
        String ss = LeftRotateString("XYZdefabc", 3);
        System.out.println(ss);

        System.out.println(reverse("abc"));
    }

}
