package leetcode.question;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class Question354_2 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 9};
        int i = Arrays.binarySearch(arr, 7);
        System.out.println(i);


        /*Question354_2 q = new Question354_2();
        int i = q.maxEnvelopes();
        System.out.println(i);*/
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                System.out.println("i = " + i);
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int maxEnvelopes() {
        // sort on increasing in first dimension and decreasing in second
        //[5,4],[6,4],[6,7],[2,3]
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) secondDim[i] = envelopes[i][1];

        return lengthOfLIS(secondDim);
    }
}

