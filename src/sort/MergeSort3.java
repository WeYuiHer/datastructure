package sort;

import java.util.Arrays;

public class MergeSort3 {

    public static void mergeSort(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int ans = merge(nums, temp, 0, n - 1);
        System.out.println(Arrays.toString(nums));
        System.out.println(ans);
    }

    public static int merge(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            int s1 = merge(nums, temp, left, mid);
            int s2 = merge(nums, temp, mid + 1, right);

            int i = left, j = mid + 1;
            int index = left;
            int cnt = 0;
            while (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    temp[index++] = nums[i++];
                } else {
                    cnt += mid - i + 1;
                    temp[index++] = nums[j++];
                }
            }
            while (i <= mid)
                temp[index++] = nums[i++];
            while (j <= right)
                temp[index++] = nums[j++];
            for (i = left; i <= right; i++) {
                nums[i] = temp[i];
            }
            return s1 + s2 + cnt;
        }
        return 0;
    }

    public int reversePairs(int[] nums) {
        int cnt = 0;

        return cnt;
    }

    public static void main(String[] args) {
//        int[] nums = {4,5,1,2,7,6,5,43,7,9,8,10,43,22,1};
        int[] nums = {7, 5, 6, 4};
        mergeSort(nums);
    }

}
