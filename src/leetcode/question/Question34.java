package leetcode.question;

import java.util.Arrays;

/*
* 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
* */
public class Question34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums == null || nums.length == 0) {
            ans[0] = ans[1] = -1;
            return ans;
        }
        int l = 0;
        int r = nums.length - 1;
        int mid;
        //开始位置
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l < nums.length && l >= 0 && nums[l] == target) {
            ans[0] = l;
        } else {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        r = nums.length - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        ans[1] = r;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 4, 5, 6, 7, 8, 8};
        int[] ints = searchRange(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}
