package leetcode.question;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
* */
public class Question46 {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        dfs(nums, 0, l, visit);

        return list;
    }

    public void dfs(int[] nums, int cur, List<Integer> l, boolean[] visit) {
        if (cur == nums.length) {
            list.add(new ArrayList<>(l));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    l.add(nums[i]);
                    dfs(nums, cur + 1, l, visit);
                    l.remove(l.size() - 1);
                    visit[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        Question46 q = new Question46();
        int[] nums = {1, 2, 3};
        q.permute(nums);
        for (List l : q.list)
            System.out.println(l);
    }

}
