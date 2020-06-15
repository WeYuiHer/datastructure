package leetcode.question;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//滑动窗口的最大值
public class Question239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int w = n - k + 1;
        int[] window = new int[w];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.offerLast(i);
            if (deque.peekFirst() == i - k)
                deque.pollFirst();
            if (i >= k - 1)
                window[index++] = nums[deque.peekFirst()];
        }
        return window;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//		int[] nums = {1,-1};
        int[] window = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(window));
    }

}
