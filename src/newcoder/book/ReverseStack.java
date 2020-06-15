package newcoder.book;
/*
 * 递归逆序栈中的数
 * */

import java.util.Stack;

public class ReverseStack {

    public static int getAndRemoveLastElement(Stack<Integer> stk) {
        int top = stk.pop();
        if (!stk.isEmpty()) {
            int last = getAndRemoveLastElement(stk);
            stk.push(top);
            return last;
        } else
            return top;
    }

    public static void reverseStack() {

    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        //   reverseStack(stk);
        while (!stk.empty())
            System.out.println(stk.pop());

    }


}
