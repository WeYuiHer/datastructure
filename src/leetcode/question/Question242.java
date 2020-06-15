package leetcode.question;

/*
* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例 1:
输入: s = "anagram", t = "nagaram"
输出: true
示例 2:
输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。
* */
public class Question242 {
    public static boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        if (s.length() != t.length())
            return false;
        int index;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            cnt[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            index = t.charAt(i) - 'a';
            cnt[index]--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("q", "e"));
    }

}
