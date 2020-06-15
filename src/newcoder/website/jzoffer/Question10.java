package newcoder.website.jzoffer;

/*
 矩形覆盖
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
* */
public class Question10 {
    int cnt = 0;

    public int RectCover(int target) {
        // int[][] dp= new int[2][target];
        dfs(0, 0, target);
        return cnt;
    }

    public void dfs(int i, int j, int n) {
        if (i == n && j == 0) {
            cnt++;
        } else if (i >= n || j >= 2) return;
        if (j == 0) {   //可以横着或竖着
            //横
            dfs(i + 1, 0, n);
            //竖
            dfs(i, j + 1, n);
        } else {  //竖
            dfs(i + 2, 0, n);
        }

    }

    public int RectCover2(int target) {
        if (target <= 2)
            return target;
        int pre1 = 1, pre2 = 2;
        int ans = 0;
        for (int i = 3; i <= target; i++) {
            ans = pre1 + pre2;
            pre1 = pre2;
            pre2 = ans;
        }
        return ans;
    }

    // 2*4
    public static void main(String[] args) {
        Question10 q = new Question10();
        int i = q.RectCover(22);
        int j = q.RectCover2(22);
        System.out.println(i);
        System.out.println(j);
    }

}
