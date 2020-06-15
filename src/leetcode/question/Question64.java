package leetcode.question;

public class Question64 {

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++)
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        for (int j = 1; j < n; j++)
            grid[0][j] = grid[0][j - 1] + grid[0][j];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i][j - 1] + grid[i][j], grid[i - 1][j] + grid[i][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        //  minPathSum()
        int[][] g = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int ans = minPathSum(g);
        System.out.println(ans);

    }

}
