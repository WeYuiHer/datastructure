package hekui.leetcode;

/*
* 给定一个未排序的整数数组，找出最长连续序列的长度。
要求算法的时间复杂度为 O(n)。
示例:
输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
* */
public class Question128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int pre = nums[0], maxLen = 1;
        for (int i = 1; i < nums.length; i++) {

        }
        return maxLen;
    }

}
