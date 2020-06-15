package newcoder.website.jzoffer;

import java.util.Arrays;

/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * */
public class Question13 {

    public static void reOrderArray(int[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            if ((array[j] & 1) == 1) {    //是奇数
                int t = array[j];
                int k = j - 1;
                while (k >= 0 && ((array[k] & 1) == 0)) { //是偶数才往后移
                    array[k + 1] = array[k];
                    k--;
                }
                array[k + 1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 8, 7, 5, 6};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

}
