package leetcode.question;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
示例:
输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
* */
public class Question51 {

    List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        int[][] q = new int[n][n];
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];
        helper(q, rows, cols, n, 0);

        return list;
    }

    public void helper(int[][] q, boolean[] rows, boolean[] cols, int n, int cur) {
        if (cur == n) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    //   System.out.print(q[i][j]);

                    if (q[i][j] == 1) {
                        sb.append('Q');
                    } else
                        sb.append('.');
                }
                //   System.out.println();
                System.out.println(sb.toString());
                l.add(sb.toString());
            }
            System.out.println("---------");
            list.add(l);
        } else {
            for (int i = cur; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!rows[i] && !cols[j] && q[i][j] == 0) {
                        boolean ok = check(i, j, q, n);

                        if (ok) {
                            rows[i] = true;
                            cols[j] = true;
                            q[i][j] = 1;

                            //      System.out.println(cur+"  "+i+" "+j);
                            helper(q, rows, cols, n, cur + 1);
                            q[i][j] = 0;
                            cols[j] = false;
                            rows[i] = false;
                        }
                    }
                }
            }
        }


    }

    public boolean check(int i, int j, int[][] q, int n) {
        boolean ok = true;
        int r = i - 1;
        int c = j - 1;
        while (r >= 0 && c >= 0 && ok) {
            if (q[r][c] == 1)
                ok = false;
            r--;
            c--;
        }
        r = i + 1;
        c = j - 1;
        while (r < n && c >= 0 && ok) {
            if (q[r][c] == 1)
                ok = false;
            r++;
            c--;
        }

        r = i + 1;
        c = j + 1;
        while (r < n && c < n && ok) {
            if (q[r][c] == 1)
                ok = false;
            r++;
            c++;
        }
        r = i - 1;
        c = j + 1;
        while (r >= 0 && c < n && ok) {
            if (q[r][c] == 1)
                ok = false;
            r--;
            c++;
        }
        return ok;
    }

    public static void main(String[] args) {
        Question51 q = new Question51();
        List<List<String>> l = q.solveNQueens(8);
        System.out.println(l.size());
      /*  for(List s :l){
            for(int i=0;i<s.size();i++)
                System.out.println(s.indexOf(i));
            System.out.println();
        }*/

    }

}
