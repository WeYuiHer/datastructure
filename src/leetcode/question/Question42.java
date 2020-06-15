package leetcode.question;

/*
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * */
public class Question42 {
    public static int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int lmax = height[0], rmax = height[n - 1];
        for (int i = 1; i < n; i++) {
            if (lmax > height[i]) {
                leftMax[i] = lmax;
            } else {
                leftMax[i] = 0;
                lmax = height[i];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (rmax > height[i]) {
                rightMax[i] = rmax;
            } else {
                rightMax[i] = 0;
                rmax = height[i];
            }
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        return ans;
    }

    public static int trap2(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int n = height.length;
        int lmax = height[0];
        int rmax = height[n - 1];
        int l = 1, r = n - 2;
        int ans = 0;
        while (l <= r) {
            if (lmax <= rmax) {
                int x = height[l];
                if (x < lmax)
                    ans += lmax - x;
                else
                    lmax = x;
                l++;
            } else {
                int x = height[r];
                if (x < rmax)
                    ans += rmax - x;
                else
                    rmax = x;
                r--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap2(height);
        System.out.println(trap);
    }

}
