package leetcode.question;

/*
* 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。
说明：
给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:
输入: n = 3, k = 3
输出: "213"
示例 2:
输入: n = 4, k = 9
输出: "2314"
* */
public class Question60 {

    int cnt = 0;
    String ans = null;

    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        boolean[] visit = new boolean[n + 1];
        helper(arr, n, k, 0, visit);
        return ans;
    }

    public void helper(int[] arr, int n, int k, int cur, boolean[] visit) {
        if (ans != null) return;
        if (cur == n) {
            cnt++;
            if (cnt == k) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cur; j++)
                    sb.append(arr[j]);
                ans = sb.toString();
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    arr[cur] = i;
                    helper(arr, n, k, cur + 1, visit);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question60 q = new Question60();
        String s = q.getPermutation(3, 1);
        System.out.println(s);

    }

}
