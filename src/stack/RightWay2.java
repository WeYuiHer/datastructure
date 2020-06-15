package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * 给定一个含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近的且值比arr[i]小的位置。
 * 返回所有位置相应的信息。 时间复杂度O（n）
 * */
public class RightWay2 {

    public static int[][] rightWay2(int[] arr) {
        int n = arr.length;
        int[][] ans = new int[n][2];
        Stack<List<Integer>> stk = new Stack<>();
        int top;
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty() || arr[i] > arr[stk.peek().get(0)]) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stk.push(list);
            } else if (arr[i] == arr[stk.peek().get(0)]) {
                stk.peek().add(i);
            } else {
                while (!stk.isEmpty() && arr[i] < arr[stk.peek().get(0)]) {
                    List<Integer> l = stk.pop();
                    int leftLessIndex = stk.isEmpty() ? -1 : stk.peek().get(stk.peek().size() - 1);
                    for (int k : l) {
                        ans[k][0] = leftLessIndex;
                        ans[k][1] = i;
                    }
                }
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stk.push(list);
            }
        }
        while (!stk.isEmpty()) {
            List<Integer> l = stk.pop();
            int leftLessIndex = stk.isEmpty() ? -1 : stk.peek().get(stk.peek().size() - 1);
            for (int x : l) {
                ans[x][0] = leftLessIndex;
                ans[x][1] = -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 3, 5, 3, 2, 2};
        int[][] ans = rightWay2(arr);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
    }

}
