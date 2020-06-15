package leetcode.question2;

import java.util.*;


public class Solution {
    /**
     * 输入一个整形数值，返回一个整形值
     *
     * @param n int整型 n>9
     * @return int整型
     */
    boolean ok = true;
    int min = Integer.MAX_VALUE;
    int minLen = Integer.MAX_VALUE;

    public int solution(int n) {
        if (n == 0)
            return 10;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(n, list);
        return ok ? min : -1;
    }

    public void dfs(int n, ArrayList<Integer> list) {
        if (n < 10) {
            list.add(n);
            if (list.size() < minLen) {
                minLen = list.size();
                Collections.sort(list);
                int xx = 0;
                for (int x : list)
                    xx = xx * 10 + x;
                System.out.println(list);
                System.out.println("xx = " + xx);
                min = Math.min(min, xx);
                System.out.println("min = " + min);
            }
        } else if (n > 10 && zhishu(n)) {
            ok = false;
        } else {
            for (int i = 2; i < 10; i++) {
                if (n % i == 0) {
                    list.add(i);
                    dfs(n / i, list);
                    list.remove(new Integer(i));
                }
            }
        }
    }

    //判断是否是质数
    public boolean zhishu(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(108);
        Deque<Integer> deque = new LinkedList<>();
    }
}
