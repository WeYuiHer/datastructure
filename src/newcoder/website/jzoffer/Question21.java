package newcoder.website.jzoffer;

public class Question21 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        return false;
    }

    public boolean dfs(boolean[][] v, char[] matrix, int r, int c, int row, int col, char[] str, int cur) {
        if (cur == str.length) {
            return true;
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((Math.abs(i) + Math.abs(j)) == 1) {
                    int r1 = r + 1;
                    int c1 = c + 1;
                    /*if(!v[r1][c1]&&matrix[r1][c1]==str[cur]){

                    }*/
                }
            }
        }

        return false;
    }

}
