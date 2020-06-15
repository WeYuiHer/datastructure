package hekui.leetcode.top100;

/*
* 给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:
可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

* */
public class LCS2 {

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int x = 0, max = 0;
        for (int i = 1; i < len; i++) {
            x = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] < x)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            dp[i] = Math.max(1, dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int x = 0, index = 1, k;
        for (int i = 1; i < len; i++) {
            x = nums[i];
            if (x <= dp[0])
                dp[0] = x;
            else if (x > dp[index - 1])
                dp[index++] = x;
            else {
                k = binarySearch(dp, index - 1, x);
                dp[k] = x;
            }
        }
        return index;
    }

    public static int binarySearch(int[] dp, int end, int target) {
        int l = 0, r = end, m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (dp[m] == target)
                return m;
            else if (dp[m] > target)
                r = m - 1;
            else
                l = m + 1;
        }
        return r > l ? r : l;
    }

    public static void main(String[] args) {
      /* int[] nums = {1,3,5,7,8,9,11,12,15};
       int i = binarySearch(nums,nums.length-1,17);
       System.out.println(i);*/
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int len = lengthOfLIS(nums);
        System.out.println(len);
    }


}
