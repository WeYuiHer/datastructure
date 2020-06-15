package leetcode.question;

import java.net.Inet4Address;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/*
* 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
* 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
示例 1:
输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:
输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:
输入: nums = [1,2,3,1,2,3], k = 2
输出: false
* */
public class Question219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null)
                map.put(nums[i], i);
            else {
                int j = map.get(nums[i]);
                if (i - j <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean b = containsNearbyDuplicate(nums, 2);
        System.out.println(b);
    }
}
