package leetcode.question;

import java.util.HashMap;
import java.util.HashSet;

/*
* 给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
示例 1:
输入: s = "egg", t = "add"
输出: true
示例 2:
输入: s = "foo", t = "bar"
输出: false
示例 3:
输入: s = "paper", t = "title"
输出: true
* */
public class Question205 {

    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n == 0) return true;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        if (chars1[0] != chars2[0])
            map.put(chars1[0], chars2[0]);
        for (int i = 1; i < n; i++) {
            char ch1 = chars1[i];
            char ch2 = chars2[i];
            boolean f1 = ch1 == chars1[i - 1];
            boolean f2 = ch2 == chars2[i - 1];
            if (ch2 != ch1) {
                if (set.contains(ch1))
                    return false;
                if (map.get(ch1) != null) {
                    if (map.get(ch1) != ch2)
                        return false;
                } else
                    map.put(ch1, ch2);
            } else {
                set.add(ch1);
            }
            if (f1 != f2)
                return false;
        }
        return true;
    }
}
