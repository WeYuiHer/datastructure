package hekui.leetcode;

/*
* 编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1:
输入: ["flower","flow","flight"]
输出: "fl"
示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:
所有输入只包含小写字母 a-z 
* */
public class Quesion14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuffer prefix = new StringBuffer();
        char ch;
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i))
                    return prefix.toString();
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {

    }

}
