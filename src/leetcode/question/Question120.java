package leetcode.question;

import org.w3c.dom.ls.LSException;

import java.util.List;

/*
* 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
* */
public class Question120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                if (j == 0)
                    dp[0] = dp[0] + list.get(0);
                else if (j == list.size() - 1)
                    dp[j] = dp[j - 1] + list.get(j);
                else
                    dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);

            }
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
