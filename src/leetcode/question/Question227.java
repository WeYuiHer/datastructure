package leetcode.question;

import java.util.Stack;

/*
* 实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
* */
public class Question227 {
    public static int calculate(String s) {
        Stack<Integer> numStk = new Stack<>();
        Stack<Character> opStk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            switch (ch) {
                case '(':
                    opStk.push(ch);
                    break;
                case ' ':
                    break;
                case '+':
                case '-':
                    while (!opStk.isEmpty() && opStk.peek() != '(') {
                        char c = opStk.pop();
                        sb.append(c);
                    }
                    opStk.push(ch);
                    break;
                case '*':
                case '/':
                    while (!opStk.isEmpty() && (opStk.peek() == '*' || opStk.peek() == '/')) {
                        char c = opStk.pop();
                        sb.append(c);
                    }
                    opStk.push(ch);
                    break;
                case ')':
                    while (!opStk.isEmpty()) {
                        char c = opStk.pop();
                        if (c != '(')
                            sb.append(c);
                        else
                            break;
                    }
                    break;
                default:
                    int x = ch - '0';
                    i++;
                    while (i < n && chars[i] >= '0' && chars[i] <= '9')
                        x = x * 10 + chars[i++] - '0';
                    //stk1.push(x);
                    sb.append(x + "#");
                    i--;
            }
        }
        while (!opStk.isEmpty())
            sb.append(opStk.pop());
        System.out.println("后缀表达式为： " + sb.toString());

        chars = sb.toString().toCharArray();
        n = chars.length;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch >= '0' && ch <= '9') {
                int x = ch - '0';
                i++;
                while (chars[i] != '#')
                    x = x * 10 + chars[i++] - '0';
                numStk.push(x);
            } else if (ch == '+')
                numStk.push(numStk.pop() + numStk.pop());
            else if (ch == '-')
                numStk.push(-numStk.pop() + numStk.pop());
            else if (ch == '*')
                numStk.push(numStk.pop() * numStk.pop());
            else if (ch == '/') {
                int a = numStk.pop();
                int b = numStk.pop();
                numStk.push(b / a);
            }
        }
        int ans = numStk.pop();
        System.out.println("ans = " + ans);
        return ans;
    }

    public static void main(String[] args) {
        int x = calculate("2+1*3*2/3");
        int y = calculate("3+5 / 2");
        //	System.out.println(x);
        //	System.out.println(y);
    }

}
