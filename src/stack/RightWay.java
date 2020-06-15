package stack;

import java.util.Arrays;
import java.util.Stack;

/*
 * 给定一个不含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近的且值比arr[i]小的位置。
 * 返回所有位置相应的信息。 时间复杂度O（n）
 * */
public class RightWay {

    public static int[][] rightWay(int[] arr) {
        int n = arr.length;
        int[][] ans = new int[n][2];
        Stack<Integer> stk = new Stack<>();
        int top;
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty() || arr[stk.peek()] < arr[i]) {
                stk.push(i);
            } else {
                while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                    top = stk.pop();
                    ans[top][0] = stk.isEmpty() ? -1 : stk.peek();
                    ans[top][1] = i;
                }
                stk.push(i);
            }
        }
        while (!stk.isEmpty()) {
            top = stk.pop();
            ans[top][0] = stk.isEmpty() ? -1 : stk.peek();
            ans[top][1] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[][] ans = rightWay(arr);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));

    }

}
