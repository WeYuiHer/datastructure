package leetcode.question;

import java.util.*;

//两个数组的交集
public class Question349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        int cnt = 0;
        for (int x : nums1) {
            set1.add(x);
        }
        for (int x : nums2) {
            if (set1.contains(x)) {
                set.add(x);
            }
        }
        cnt = set.size();
        int[] ans = new int[cnt];
        int index = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext())
            ans[index++] = it.next();
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 3};
        int[] A = intersection(nums1, nums2);
        System.out.println(Arrays.toString(A));
    }

}
