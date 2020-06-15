package sort;

import java.net.SocketTimeoutException;
import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] nums, int left, int right) {
        int[] temp = new int[right - left + 1];
        int mid = left + (right - left) / 2;
        int m = mid;
        mid++;
        int i = 0;
        while (left <= m && mid <= right) {
            if (nums[left] == nums[mid]) {
                temp[i++] = nums[left++];
                temp[i++] = nums[mid++];
            } else if (nums[left] < nums[mid]) {
                temp[i++] = nums[left++];
            } else
                temp[i++] = nums[mid++];
        }
        //   System.out.println(left+" , "+mid);
        while (left <= m)
            temp[i++] = nums[left++];
        while (mid <= right)
            temp[i++] = nums[mid++];
        //   System.out.println(Arrays.toString(temp)+"    ****");
        while (i-- > 0)
            nums[right--] = temp[i];
    }

    //迭代
    public static void merge(int[] nums) {
        int len = 1;
        int i = 0;
        while (len < nums.length) {
            for (i = 0; i + 2 * len - 1 < nums.length; i = i + 2 * len) {
                //  System.out.println("left "+i+"  right "+(i + 2 * len - 1));
                merge(nums, i, i + 2 * len - 1);
                //  System.out.println("**"+i);
            }
            System.out.println("**");
            if (i < nums.length)
                merge(nums, i, nums.length - 1);

            //    System.out.println("len = " + len + "  " + Arrays.toString(nums));
            len *= 2;
        }
    }

    //递归
    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, r);
    }


    public static void main(String[] args) {
        int[] nums = {7, 6, 1, 0, 3, 2, 4, 5};
        // merge(nums);
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

}
