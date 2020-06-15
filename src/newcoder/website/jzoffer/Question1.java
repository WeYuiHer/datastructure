package newcoder.website.jzoffer;

import org.w3c.dom.ls.LSOutput;

/*
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * */
public class Question1 {

    public static boolean find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            int x = array[i][j];
            if (x == target)
                return true;
            else if (x > target)
                i--;
            else
                j++;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] nums = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        boolean b = find(11, nums);

        System.out.println(b);

    }

}
