package leetcode.contest;

import java.util.Map;

/*
平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
你可以按照下面的规则在平面上移动：
每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
必须按照数组中出现的顺序来访问这些点。
*/
public class Question1 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int cnt = 0;
        int x = points[0][0], y = points[0][1];
        for (int i = 1; i < n; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            int maxX = Math.max(x, x2);
            int maxY = Math.max(y, y2);
            int minX = Math.min(x, x2);
            int minY = Math.min(y, y2);
            cnt += Math.max(maxX - minX, maxY - minY);
            x = x2;
            y = y2;
        }
        return cnt;
    }
}
