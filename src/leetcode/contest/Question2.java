package leetcode.contest;

/*
* 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
* */
public class Question2 {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    //up
                    boolean f = false;
                    int x = i - 1;
                    while (x >= 0) {
                        if (grid[x--][j] == 1) {
                            f = true;
                            break;
                        }
                    }
                    //down
                    x = i + 1;
                    while (x < n && !f) {
                        if (grid[x++][j] == 1) {
                            f = true;
                            break;
                        }
                    }
                    //left
                    x = j - 1;
                    while (j >= 0 && !f) {
                        if (grid[i][x--] == 1) {
                            f = true;
                            break;
                        }
                    }
                    //right
                    x = j + 1;
                    while (j < m && !f) {
                        if (grid[i][x++] == 1) {
                            f = true;
                            break;
                        }
                    }
                    if (f)
                        cnt++;

                }
            }
        }
        return cnt;
    }

}
