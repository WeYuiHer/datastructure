package newcoder.book;
/*
 * 设计一个有getMin功能的栈
 * P1
 * */

import javax.sound.midi.Soundbank;
import java.util.Stack;

public class MyStack {
    private static Stack<Integer> dataStack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    public static void push(int x) {
        if (minStack.empty()) {
            minStack.push(x);
        } else if (minStack.peek() >= x)
            minStack.push(x);
        dataStack.push(x);
    }

    public static int pop() {
        if (minStack.peek() == dataStack.peek())
            minStack.pop();
        return dataStack.pop();
    }

    public static int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        push(3);
        System.out.println(getMin());
        push(4);
        System.out.println(pop());
        push(2);
        System.out.println(getMin());
        push(1);
        System.out.println(getMin());

    }

}
