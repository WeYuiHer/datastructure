package newcoder.website.jzoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * */
public class Question27 {

    public static String PrintMinNumber(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
            list.add(numbers[i] + "");
        Collections.sort(list, (String s1, String s2) -> {
            int i = 0, j = 0;
            int pre = 9;
            while (i < s1.length() && j < s2.length()) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);

                if (ch1 == ch2) {
                    pre = ch1;
                    i++;
                    j++;
                } else
                    return ch1 - ch2;
            }
            if (i == s1.length() && j == s2.length())
                return 0;
            else if (i == s1.length()) {
                while (j < s2.length() && pre == s2.charAt(j))
                    j++;
                if (j == s2.length())
                    return 0;
                return pre - s2.charAt(j);
            } else {
                while (i < s1.length() && pre == s1.charAt(i))
                    i++;
                if (i == s1.length())
                    return 0;
                return s1.charAt(i) - pre;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        int[] num = {3,32,321};
        int[] num = {3, 323, 32123};
        String s = PrintMinNumber(num);
        System.out.println(s);

    }

}
