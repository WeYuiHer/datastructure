import java.util.Arrays;

public class Main {

    //插入排序
    public static void insertSort(int[] nums) {
        int i = 0, j = 0, t = 0;
        for (i = 1; i < nums.length; i++) {
            j = i - 1;
            t = nums[i];
            while (j >= 0 && nums[j] > t) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = t;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] nums) {
        int temp = 0;
        boolean exchange = false;
        for (int i = 0; i < nums.length; i++) {
            exchange = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    exchange = true;
                }
            }
            if (!exchange)
                break;
        }
    }

    //快速排序
    public static int partition(int[] nums, int l, int r) {
        int p = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= p)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= p)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = p;
        return l;
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }
    }

    //归并排序
    public static void merge(int[] A, int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;
        int[] L = new int[len1];
        int[] R = new int[len2];
        int i = 0, j = 0;
        for (i = l, j = 0; i <= m; i++, j++)
            L[j] = A[i];
        for (i = m + 1, j = 0; i <= r; i++, j++)
            R[j] = A[i];
        i = 0;
        j = 0;
        int index = l;
        while (i < len1 && j < len2) {
            if (L[i] <= R[j]) {
                A[index++] = L[i++];
            } else
                A[index++] = R[j++];
        }
        while (i < len1)
            A[index++] = L[i++];
        while (j < len2)
            A[index++] = R[j++];
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    //堆排序
    public static void sift(int[] nums, int low, int high) {
        int temp = nums[low], i = low, j = low * 2;
        while (j < high) {
            if (j + 1 < high) {
                if (nums[j + 1] > nums[j])
                    j++;
            }
            if (temp < nums[j]) {
                nums[i] = nums[j];
                i = j;
                j = i * 2;
            } else
                break;
        }
        nums[i] = temp;

        //    System.out.println("** "+Arrays.toString(nums));
    }

    public static void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i > 0; i--)
            sift(nums, i, n);
        int temp;
        for (int i = n - 1; i > 1; i--) {
            temp = nums[i];
            nums[i] = nums[1];
            nums[1] = temp;
            sift(nums, 1, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 4, 3, 5, 1, 0, 8, 7};
//        merge(nums,0,1,3);
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
//        int[] nums = {5,1,2,3,4};
      /*  int[] nums = {3,0,4,5,1,2,6,8,7,9};
       // insertSort(nums);
      //  bubbleSort(nums);
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));*/
    }
}
