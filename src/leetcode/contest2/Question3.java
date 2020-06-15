package leetcode.contest2;

import java.util.Arrays;

/*
* 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
示例 1：
输入：nums = [3,6,5,1,8]
输出：18
解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
* */
public class Question3 {
    public int maxSumDivThree(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2, min3, min4;
        min2 = min3 = min4 = min1;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (n % 3 == 1) {
                if (n <= min1) {
                    min2 = min1;
                    min1 = n;
                } else if (n < min2)
                    min2 = n;
            } else if (n % 3 == 2) {
                if (n <= min3) {
                    min4 = min3;
                    min3 = n;
                } else if (n < min4)
                    min4 = n;
            }
        }
        if (sum % 3 == 1) {
            if (min3 < Integer.MAX_VALUE && min4 < Integer.MAX_VALUE)
                sum = min1 < min3 + min4 ? sum - min1 : sum - min3 - min4;
            else
                sum = sum - min1;
        } else if (sum % 3 == 2)
            if (min1 < Integer.MAX_VALUE && min2 < Integer.MAX_VALUE)
                sum = min1 + min2 < min3 ? sum - min1 - min2 : sum - min3;
            else
                sum = sum - min3;
        return sum;
    }
}
