package newcoder.book;

import java.util.Stack;

/*
 * 使用两个栈实现队列
 * */
public class TwoStackOneQueue {
    private static Stack<Integer> inStack = new Stack<>();
    private static Stack<Integer> outStack = new Stack<>();

    public static void add(int x) {
        inStack.push(x);
    }

    public static int remove() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        add(1);
        System.out.println(remove());
        add(2);
        add(3);
        add(4);
        System.out.println(remove());
        System.out.println(remove());
        add(5);
        System.out.println(remove());
    }

}
