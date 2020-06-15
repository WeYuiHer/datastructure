package leetcode.question;

/*
* 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
* 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
示例 1:
输入:
11110
11010
11000
00000
输出: 1
* */
public class Question200 {

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int m, int n, int i, int j) {
        grid[i][j] = '0';
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (Math.abs(x) + Math.abs(y) == 1) {
                    int i2 = i + x;
                    int j2 = j + y;
                    if (i2 < m && i2 >= 0 && j2 < n && j2 >= 0 && grid[i2][j2] == '1') {
                        dfs(grid, m, n, i2, j2);
                    }
                }

            }
        }


    }


}
