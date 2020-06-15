package hekui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
* 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。
例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

* */
public class Question15<main> {
    /*
    * ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int max = Math.max(nums[nums.length - 1], Math.abs(nums[0]));
        //最大的值是2倍的max,即最大值是max,max+max
        int[] map = new int[max * 2 + 1];
        Arrays.fill(map, -1);
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + max] = i;
        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
        int target = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            int first = nums[i];
            if (i != 0 && first == nums[i - 1]) {
                continue;
            }
            if (first > target) {
                break;
            }
            for (int j = i + 1; j <= nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sencond = nums[j];
                if (first + sencond > target && sencond > 0) {
                    break;
                }

                int find = target - first - sencond;

                int index = find + max;
                if (index <= 2 * max && index >= 0 && map[index] > j) {
                    result.add(Arrays.asList(first, sencond, find));
                }

            }

        }
        return result;
    * */


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        //  System.out.println(Arrays.toString(nums));
        int sum = 0, len = nums.length;
        int l = 0, r = 0;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            l = i + 1;
            /*
            while (nums[l] != nums[l - 1] && l < len - 1) {
                l++;
            }
            */
            r = len - 1;
            sum = nums[i] + nums[l] + nums[r];
            while (l < r) {
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);

                    //     System.out.println(i+"  "+l+"   "+r);
                    while (l < len - 1 && nums[l + 1] == nums[l]) l++;
                    while (r > 1 && nums[r - 1] == nums[r]) r--;
                }
                if (l > r)
                    break;

                if (sum > 0) {
                    r--;
                } else
                    l++;
                sum = nums[i] + nums[l] + nums[r];


            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List list = threeSum(nums);
        System.out.println(list);
    }
}
