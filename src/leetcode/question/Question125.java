package leetcode.question;

/*
* 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:
输入: "race a car"
输出: false
* */
public class Question125 {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int i = 0, j = s.length() - 1;
        char ch1, ch2;
        while (i < j) {
            ch1 = s.charAt(i);
            ch2 = s.charAt(j);
            if (!(Character.isAlphabetic(ch1) || ('0' <= ch1 && ch1 <= '9'))) {
                i++;
                continue;
            }
            if (!(Character.isAlphabetic(ch2) || ('0' <= ch2 && ch2 <= '9'))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome("race a car"));

    }

}
