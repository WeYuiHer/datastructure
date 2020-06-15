package sort;

import java.util.Arrays;

public class HeapSort {

    //大顶堆

    //从k开始向下堆化
    public void sift(int[] nums, int k, int n) {
        //  int n = nums.length;
        int t = nums[k];
        int l = k == 0 ? 1 : k * 2;
        while (l < n) {
            if (l + 1 < n && nums[l] < nums[l + 1])
                l++;
            if (t < nums[l]) {
                nums[k] = nums[l];
                k = l;
                l = k * 2;
            } else
                break;

        }
        nums[k] = t;
    }

    public void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--)
            sift(nums, i, n);

        for (int i = 1; i < n; i++) {
            swap(nums, 0, n - i);
            sift(nums, 0, n - i);
        }
        System.out.println(Arrays.toString(nums));

    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 7, 2, 4, 6, 9, 8, 1, 2};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);
    }

}
