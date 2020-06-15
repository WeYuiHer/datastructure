package stack;

import java.util.LinkedList;

/*
 * 一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
 * 如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口最大值。
 * 输入：数组arr 窗口大小w
 * 输出；一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值
 * */
public class MaxWindow {

    public static int[] getMaxWindow(int[] arr, int w) {
        int n = arr.length;
        int[] ans = new int[n - w + 1];
        LinkedList<Integer> q = new LinkedList<>();
        int rear, index = 0;
        for (int i = 0; i < n; i++) {
            if (q.size() == 0) {
                q.addLast(i);
            } else {
                rear = arr[q.getLast()];
                if (rear > arr[i]) {
                    q.addLast(i);
                } else {
                    while (q.size() > 0 && arr[q.getLast()] < arr[i])
                        q.removeLast();
                    q.addLast(i);
                }
            }
            if (i >= w - 1) {
                while (q.getFirst() <= i - w)
                    q.removeFirst();
                ans[index++] = arr[q.getFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] ans = getMaxWindow(arr, 3);
        for (int i : ans)
            System.out.print(i + " ");
    }

}
