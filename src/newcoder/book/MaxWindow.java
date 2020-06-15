package newcoder.book;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 生成窗口最大值数组
 * */
public class MaxWindow {

    public static int[] getMaxWindow(int[] arr, int w) {
        int n = arr.length;
        int[] d = new int[n - w + 1];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i])
                queue.pollLast();
            queue.offer(i);
            if (queue.peekFirst() == i - w)
                queue.pollFirst();
            if (i >= w - 1)
                d[index++] = arr[queue.peekFirst()];
        }

        return d;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] maxWindow = getMaxWindow(arr, 3);
        System.out.println(Arrays.toString(maxWindow));
    }

}
