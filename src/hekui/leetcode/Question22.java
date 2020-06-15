package hekui.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
* */
public class Question22 {
    List<String> list = new ArrayList<>();

    public void generate(StringBuilder s, int n, int l, int r) {
        if (l == n) {
            StringBuilder s2 = new StringBuilder(s.toString());
            int r2 = r;
            while (r2 < n) {
                s2.append(")");
                r2++;
            }
            list.add(s2.toString());
            return;
        } else {
            generate(s.append("("), n, l + 1, r);
            s = s.deleteCharAt(s.length() - 1);
            if (r < l) {
                generate(s.append(")"), n, l, r + 1);
                s = s.deleteCharAt(s.length() - 1);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(), n, 0, 0);

        return list;
    }

    public static void main(String[] args) {
        Question22 q = new Question22();
        System.out.println(q.generateParenthesis(3));
    }
}
