package leetcode.question;

import java.util.*;

/*
* 给定一个可包含重复数字的序列，返回所有不重复的全排列。
示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
* */
public class Question47 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList<>();

        helper(nums, list, visit);

        return ans;
    }

    public void helper(int[] nums, LinkedList<Integer> list, boolean[] visit) {
        if (list.size() == nums.length)
            ans.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])
                    continue;
                if (!visit[i]) {
                    visit[i] = true;
                    list.add(nums[i]);
                    helper(nums, list, visit);
                    visit[i] = false;
                    list.removeLast();
                }
            }
        }

    }

    public static void main(String[] args) {
        Question47 q = new Question47();
        int[] nums = {1, 1, 2};
        q.permuteUnique(nums);
        for (List l : q.ans)
            System.out.println(l);
    }

}
