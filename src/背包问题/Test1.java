package 背包问题;

import java.util.Arrays;
import java.util.Collections;

public class Test1 {

    public static int maxSumOfSubarr(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < len; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {

//        int[] nums = {1, -3, 9, 10, -2, 3, -6, 5};
//        int i = maxSumOfSubarr(nums);
//        System.out.println(i);
//
//        int[][] arr = {{2,4},{0,1},{4,7},{3,7}};
//        Arrays.sort(arr,(int[] a,int[] b)->{return a[0]-b[0];});
//        for(int i=0;i<arr.length;i++)
//            System.out.println(Arrays.toString(arr[i]));
//
//
//        int[] nums = {1,2,3,4};
//        System.arraycopy();
        int a = 2;
        int b = 3;
//        double c = (double)a/b;
        double c = 1.0 * a / b;
        System.out.println(c);
        System.out.println(c * b == a);

    }

}
