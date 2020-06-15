package hekui.leetcode;

import java.util.Arrays;

//快速排序
public class QuickSort {
    public static void quickSort(int[] nums, int l, int r) {
        int i = l, j = r;
        if (i < j) {
            int t = nums[i];
            while (i < j) {
                while (i < j && t <= nums[j]) j--;
                nums[i] = nums[j];
                while (i < j && t >= nums[i]) i++;
                nums[j] = nums[i];
            }
            nums[i] = t;
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 2, 4, 6, 0, 8, 7};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}

