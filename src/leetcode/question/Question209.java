package leetcode.question;

/*
* 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
* 如果不存在符合条件的连续子数组，返回 0。
示例: 
输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
* */
public class Question209 {
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int min = n + 1;
        int i = 0, j = 0;
        int sum = 0;
        while (j < n || sum >= s) {
            while (j < n && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                min = Math.min(min, j - i);
                System.out.println("i = " + i + " j = " + j);
            }
            while (i < j && sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i];
                i++;
                System.out.println("**  i = " + i + " j = " + j);
            }
            //System.out.println(min);
        }

        return min > n ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = minSubArrayLen(7, nums);
        System.out.println(i);
    }

}
