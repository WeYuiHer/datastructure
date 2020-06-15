package leetcode.question;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
示例 1:
输入: [0,1,2,4,5,7]
输出: ["0->2","4->5","7"]
解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
示例 2:
输入: [0,2,3,4,6,8,9]
输出: ["0","2->4","6","8->9"]
解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
* */
public class Question228 {

    public static List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int st = nums[0], end = nums[0];
        int len = nums.length;
        List<String> list = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                if (st == end)
                    list.add(end + "");
                else
                    list.add(st + "->" + end);
                st = end = nums[i];
            }
        }
        if (st != end)
            list.add(st + "->" + end);
        else
            list.add(st + "");
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 4, 5, 7, 8, 9};
        List<String> list = summaryRanges(nums);
        System.out.println(list);
    }
}
