package hekui.leetcode;

/*
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

* 示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

* 示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
* */
public class Question3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        else if (s.length() == 1) return 1;
        else {
            int max = 1;
            char[] chs = s.toCharArray();
            int len = chs.length;
            int cnt = 1, l = 0, r = 0, j = 0;
            for (int i = 1; i < len; i++) {
                cnt = 1;
                r = i;
                j = i - 1;
                while (j >= l && chs[j] != chs[i]) {
                    j--;
                    cnt++;
                }
                l = j + 1;
                max = max >= cnt ? max : cnt;
            }

            return max;
        }
    }

    public static void main(String[] args) {
        int len = lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
    }

}
