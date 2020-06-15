package stack;

import java.util.Stack;

/*
 * 将栈中的元素按栈顶到栈底从大到小排序  可以申请另一个栈
 * */
public class StackSort {

    public static void sortStackByStack(Stack<Integer> stk) {
        Stack<Integer> stk2 = new Stack<>();
        while (!stk.isEmpty()) {
            int pop = stk.pop();
            if (stk2.isEmpty() || pop <= stk2.peek()) {
                stk2.push(pop);
            } else {
                while (!stk2.isEmpty() && stk2.peek() < pop) {
                    stk.push(stk2.pop());
                }
                stk2.push(pop);
            }
        }
        while (!stk2.isEmpty()) {
            stk.push(stk2.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(5);
        stk.push(4);
        stk.push(6);
        stk.push(1);
        stk.push(2);
        stk.push(3);
        sortStackByStack(stk);
        while (!stk.isEmpty())
            System.out.println(stk.pop());
    }

}
