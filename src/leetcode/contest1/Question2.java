package leetcode.contest1;

import java.util.Stack;

/*
* 给出一个字符串 s（仅含有小写英文字母和括号）。
请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
注意，您的结果中 不应 包含任何括号。

示例 1：
输入：s = "(abcd)"
输出："dcba"
示例 2：
输入：s = "(u(love)i)"
输出："iloveu"
示例 3：
输入：s = "(ed(et(oc))el)"
输出："leetcode"
示例 4：
输入：s = "a(bcdefghijkl(mno)p)q"
输出："apmnolkjihgfedcbq"
提示：
0 <= s.length <= 2000
s 中只有小写英文字母和括号
我们确保所有括号都是成对出现的
* */
public class Question2 {

    public static String reverseParentheses(String s) {
        Stack<String> stk = new Stack<>();
        stk.push("");
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(')
                stk.push("");
            else if (ch == ')') {
                String pop = stk.pop();
                StringBuffer pop2 = new StringBuffer(stk.pop());
                for (int j = pop.length() - 1; j >= 0; j--) {
                    pop2.append(pop.charAt(j));
                }
                stk.push(pop2.toString());
            } else {
                String str = stk.pop();
                str += ch;
                stk.push(str);
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        String s = reverseParentheses("(ed(et(oc))el)");
        System.out.println(s);
    }

}
