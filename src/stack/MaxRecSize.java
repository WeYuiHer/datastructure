package stack;

import java.nio.file.StandardWatchEventKinds;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/*
 * 给定一个整形矩阵map，其中的值只有0和1，求其中全是1的所有矩形区域中，最大的矩形区域中1的数量。
 * 如：
 *   1 1 1 0
 *   返回 3
 * 如：
 *   1 0 1 1
 *   1 1 1 1
 *   1 1 1 0
 * 返回6
 *
 * */


public class MaxRecSize {

    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0)
            return 0;
        int n = map[0].length;
        int[] height = new int[n];
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = map[i][j] == 1 ? height[j] + 1 : 0;
            }
            //	System.out.println(Arrays.toString(height));
            max = Math.max(max, maxRecFromBottom(height));
        }
        return max;
    }

    public static int maxRecFromBottom(int[] height) {
        Stack<Integer> stk = new Stack<>();
        int j, k;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stk.isEmpty() && height[stk.peek()] >= height[i]) {
                j = stk.pop();
                k = stk.isEmpty() ? -1 : stk.peek();
                int curMax = (i - k - 1) * height[j];
                max = Math.max(curMax, max);
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            j = stk.pop();
            k = stk.isEmpty() ? -1 : stk.peek();
            int curMax = (height.length - k - 1) * height[j];
            max = Math.max(curMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
		/*
		* Sample Input
		2 2
		0 0
		0 0
		4 4
		0 0 0 0
		0 1 1 0
		0 1 1 0
		0 0 0 0
		* */

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m, n;
            m = sc.nextInt();
            n = sc.nextInt();
            int[][] map = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int max = maxRecSize(map);
            System.out.println(max);
        }
		/*int[][] map2 = {{1,1,1,0}};

		int[][] map = {
				{1,1,0,1},
				{1,1,1,1},
				{1,1,1,0}
		};
		int max = maxRecSize(map);
		System.out.println(max);*/

    }

}
