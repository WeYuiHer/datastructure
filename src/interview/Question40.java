package interview;

import leetcode.contest.Question4;

import java.util.Arrays;

public class Question40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k]; //大顶堆
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        //堆化
        for (int i = k / 2; i >= 0; i--)
            sift(ans, i);

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < ans[0]) {
                ans[0] = arr[i];
                sift(ans, 0);
            }
        }

        return ans;
    }

    public void sift(int[] nums, int x) {
        int t = nums[x];
        int n = nums.length;
        int l = x * 2 + 1;  //下标从0开始 左子树的下标为 x*2+1
        while (l < n) {
            if (l + 1 < n && nums[l] < nums[l + 1]) {
                l++;
            }
            if (t < nums[l]) {
                nums[x] = nums[l];
                x = l;
                l *= 2;
            } else
                break;
        }
        nums[x] = t;
    }

    public static void main(String[] args) {
        Question40 q = new Question40();
        int[] nums = {0, 1, 1, 2, 4, 4, 1, 3, 3, 2};

        int[] leastNumbers = q.getLeastNumbers(nums, 6);
        System.out.println(Arrays.toString(leastNumbers));
    }

}
