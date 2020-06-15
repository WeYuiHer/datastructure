package hekui.leetcode;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

/*
 * 二分查找系列
 * */
public class binarysearch {
    public static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m = l + (r - l) / 2, x;
        boolean find = false;
        while (l <= r) {
            m = l + (r - l) / 2;
            x = nums[m];
            if (x == target) {
                find = true;
                break;
            } else if (x > target)
                r = m - 1;
            else
                l = m + 1;
        }
        if (find)
            return m;
        else {
            System.out.println("未找到目标元素：" + target);
            return -1;
        }
    }

    //二分查找 第一个等于target的下标
    public static int binarySearch2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m = 0, x = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            x = nums[m];
            if (x >= target)
                r = m - 1;
            else
                l = m + 1;

        }
        return l;
    }

    //二分查找 最后一个等于target的下标
    public static int binarySearch3(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m = 0, x = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            x = nums[m];
            if (x <= target)
                l = m + 1;
            else
                r = m - 1;

        }
        return r;
    }

    //二分查找 第一个大于target的下标
    public static int binarySearch4(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m = 0, x = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            x = nums[m];
            if (x <= target)
                l = m + 1;
            else
                r = m - 1;

        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        // int index = binarySearch3(nums,2);
        int index = binarySearch4(nums, 0);
        System.out.println(index);
    }

}
