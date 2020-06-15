package leetcode.question;

import java.util.Arrays;

/*
* 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
* 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。
示例:
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
* */
public class Question75 {
    public void sortColors(int[] nums) {
        int p0 = 0, cur = 0, p2 = nums.length - 1;
        int x;
        while (cur <= p2) {
            x = nums[cur];
            if (x == 0) {
                swap(nums, p0, cur);
                p0++;
                cur++;
            } else if (x == 2) {
                swap(nums, p2, cur);
                p2--;
            } else
                cur++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        Question75 q = new Question75();
        int[] nums = {0, 1, 2, 2, 1, 1, 0, 0, 2, 1, 0, 1, 0, 2};
        q.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
