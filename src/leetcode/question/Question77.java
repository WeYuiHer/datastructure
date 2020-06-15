package leetcode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
* */
public class Question77 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[k];
        boolean[] visit = new boolean[n + 1];
        helper(n, k, 0, arr, visit);
        System.out.println(Arrays.toString(visit));
        return ans;
    }

    public void helper(int n, int k, int cur, int[] arr, boolean[] visit) {
        if (cur == k) {     //已经选够了k个
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < cur; j++)
                l.add(arr[j]);
            ans.add(l);
        } else {
            //	int i = cur==0?1:arr[cur]+1;
            for (int i = 1; i <= n; i++) {
                if (!visit[i] && (cur == 0 || i > arr[cur - 1])) {

                    visit[i] = true;
                    arr[cur] = i;
                    helper(n, k, cur + 1, arr, visit);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question77 q = new Question77();
        List<List<Integer>> list = q.combine(4, 2);
        for (List l : list)
            System.out.println(l);

    }

}
