package hekui.leetcode.top100;

/*
* 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，
* 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
* 同一个单元格内的字母不允许被重复使用。

示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
* */
public class Question79 {
    static boolean[][] visit;
    static boolean exist = false;

    public static boolean dfs(char[][] board, String word, int x, int y, int cur) {
        if (cur == word.length()) {
            exist = true;
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        int x2 = x, y2 = y;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                x2 = x + i;
                y2 = y + j;
                if (Math.abs(i) + Math.abs(j) == 1) {
                    if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && !visit[x2][y2] && board[x2][y2] == word.charAt(cur)) {
                        visit[x2][y2] = true;
                        dfs(board, word, x2, y2, cur + 1);
                        visit[x2][y2] = false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visit = new boolean[m][n];
        char st = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == st) {
                    visit[i][j] = true;
                    dfs(board, word, i, j, 1);
                    if (exist)
                        return true;
                    visit[i][j] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "FDASABCA";
        System.out.println(exist(board, word));
    }
}
