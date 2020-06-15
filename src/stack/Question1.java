package stack;

import java.util.Stack;

public class Question1 {

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stk = new Stack<>();
        int i = 0, j = 0;
        int n = pushA.length;
        while (j < n && (i < n || !stk.isEmpty())) {
            if (i < n && pushA[i] == popA[j]) {
                i++;
                j++;
            } else if (!stk.isEmpty() && stk.peek() == popA[j]) {
                int x = stk.pop();
                j++;
            } else {
                while (i < n && pushA[i] != popA[j]) {
                    stk.push(pushA[i++]);
                }
                i++;
                j++;

            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4, 5};
        int[] out = {1, 2, 5, 3, 4};
        System.out.println(IsPopOrder(in, out));
    }
}
