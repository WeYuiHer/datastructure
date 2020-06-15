package leetcode.question;

import java.util.Stack;

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。
每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
* */
public class Question84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0;
        int j, k;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                j = stk.pop();
                k = stk.isEmpty() ? -1 : stk.peek();
                int curMax = (i - k - 1) * heights[j];
                max = Math.max(curMax, max);
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            j = stk.pop();
            k = stk.isEmpty() ? -1 : stk.peek();
            int curMax = (heights.length - k - 1) * heights[j];
            max = Math.max(curMax, max);
        }
        return max;
    }

}
