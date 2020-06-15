package newcoder.website.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
* 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
* 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
* */
public class Question23 {
    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] visit = new boolean[len];
        char[] chs = new char[len];
        dfs(chars, visit, 0, chs);

        return list;
    }

    public void dfs(char[] chars, boolean[] visit, int cur, char[] chs) {
        int len = chars.length;
        if (cur == len) {
            String s = new String(chs);
            if (!list.contains(s))
                list.add(s);
        } else {
            for (int i = 0; i < len; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    chs[cur] = chars[i];
                    dfs(chars, visit, cur + 1, chs);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question23 q = new Question23();
        ArrayList<String> list = q.Permutation("baac");
        System.out.println(list);

        new HashMap<>();

    }

}
