package newcoder.book;

import java.util.Stack;

public class StackSort {

    //栈排序
    public static Stack sortStack(Stack<Integer> stk) {
        Stack<Integer> stk2 = new Stack<>();
        int x;
        while (!stk.isEmpty()) {
            x = stk.pop();
            if (stk2.isEmpty())
                stk2.push(x);
            else {
                while (!stk2.isEmpty() && x > stk2.peek()) {
                    stk.push(stk2.pop());
                }
                stk2.push(x);
            }
        }
        //System.out.println("size = "+stk.size()+"  "+stk2.size());
        return stk2;
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(3);
        stk.push(4);
        stk.push(1);
        stk.push(6);
        stk.push(2);

        stk = sortStack(stk);

        while (!stk.isEmpty())
            System.out.println(stk.pop());

    }

}
