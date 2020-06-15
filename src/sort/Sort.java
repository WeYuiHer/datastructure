package sort;


import java.util.Arrays;

public class Sort {

    //插入排序
    public static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int k = nums[i + 1];
            int j = i;
            while (j >= 0 && k < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[++j] = k;
        }
    }

    //选择排序
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int m = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    m = j;
                }
            }
            if (m != i) {
                swap(nums, m, i);
            }
        }
    }

    public static void swap(int[] nums, int m, int n) {
        int t = nums[m];
        nums[m] = nums[n];
        nums[n] = t;
    }

    //冒泡排序
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean exchange = false;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    exchange = true;
                    swap(nums, j, j - 1);
                }
            }
            if (!exchange)
                break;
        }
    }

    //快速排序
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int r = right;
            int t = nums[left];
            while (left < right) {
                while (right > left && t <= nums[right])
                    right--;
                nums[left] = nums[right];
                while (right > left && t >= nums[left])
                    left++;
                nums[right] = nums[left];
            }
            nums[left] = t;
            quickSort(nums, 0, left - 1);
            quickSort(nums, left + 1, r);
        }
    }

    //堆排序
    public static void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i > 0; i--) {
            sift(nums, i, n);
        }
        System.out.println("堆化完成： " + Arrays.toString(nums));
        for (int i = 1; i < n; i++) {
            sift(nums, 1, n - i + 1);
            swap(nums, 1, n - i);
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void sift(int[] nums, int l, int n) {
        int k = l * 2;
        int t = nums[l];
        while (k < n) {
            if (k + 1 < n && nums[k] < nums[k + 1])
                k = k + 1;
            if (t < nums[k]) {
                nums[l] = nums[k];
                l = k;
                k = k * 2;
            } else
                break;
        }
        nums[l] = t;
    }

    //归并排序
    public static void merge(int[] nums, int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;
        int[] A = new int[len1];
        int[] B = new int[len2];
        int i, j;
        for (i = 0; i < len1; i++) {
            A[i] = nums[l + i];
        }
        for (j = 0; j < len2; j++) {
            B[j] = nums[m + j + 1];
        }

        i = 0;
        j = 0;
        int k = l;
        while (i < len1 && j < len2) {
            if (A[i] <= B[j])
                nums[k++] = A[i++];
            else
                nums[k++] = B[j++];
        }
        while (i < len1)
            nums[k++] = A[i++];
        while (j < len2)
            nums[k++] = B[j++];

        System.out.println(Arrays.toString(nums));

    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }


    public static void main(String[] args) {
        int[] nums = {-1, 5, 8, 1, 3, 2, 9, 7, 4, 6, 2, 5, 7};
        //insertSort(nums);
        //selectSort(nums);
        //bubbleSort(nums);
        //quickSort(nums,0,nums.length-1);
        //heapSort(nums);
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }


}
