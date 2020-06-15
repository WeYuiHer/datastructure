package leetcode.contest2;

import org.w3c.dom.ls.LSException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question1 {
    /*
    * 给你一个 n 行 m 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
    每次「迁移」操作将会引发下述活动：
    位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
    位于 grid[i][m - 1] 的元素将会移动到 grid[i + 1][0]。
    位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]。
    请你返回 k 次迁移操作后最终得到的 二维网格。
    * */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> l = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                l.add(grid[i][j]);
            }
            lists.add(l);
        }
        int i = k % m;    //列向右移动数
        int j = k / m;    //行的上下移动数
        move1(lists, i);
        if (j > 0)
            move2(lists, j);
        for (int x = 0; x < i; x++)
            move3(lists, x);
        return lists;
    }

    //向右移动
    public void move1(List<List<Integer>> lists, int x) {
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> l = lists.get(i);
            for (int j = 0; j < x; j++) {
                l.add(0, l.remove(l.size() - 1));
            }
        }
    }

    //整体上下移动
    public void move2(List<List<Integer>> lists, int x) {
        for (int i = 0; i < x; i++)
            lists.add(0, lists.remove(lists.size() - 1));
    }

    //某一列向下移动一个
    public void move3(List<List<Integer>> lists, int col) {
        int t = lists.get(lists.size() - 1).get(col);
        for (int i = lists.size() - 1; i >= 0; i--) {
            lists.get(i).set(col, lists.get(i - 1).get(col));
        }
        lists.get(0).set(col, t);
    }


}
