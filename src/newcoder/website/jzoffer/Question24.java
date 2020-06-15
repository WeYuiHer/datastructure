package newcoder.website.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//数组中最小的k个数
public class Question24 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x1, x2) -> x1 - x2);
        for (int i = 0; i < input.length; i++) {
            int x = input[i];
            queue.offer(x);
        }
        while (k-- > 0 && !queue.isEmpty())
            list.add(queue.poll());
        return list;
    }

    public static void quickSort(int[] num, int l, int r) {
        if (l < r) {
            int i = l, j = r;
            int x = num[l];
            while (i < j) {
                while (i < j && num[j] >= x)
                    j--;
                num[i] = num[j];
                while (i < j && num[i] <= x)
                    i++;
                num[j] = num[i];
            }
            num[i] = x;
            // System.out.println(Arrays.toString(num));
            quickSort(num, l, i - 1);
            quickSort(num, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] num = {5, 6, 3, 1, 2, 4, 9, 8, 7, 5, 11};
        // quickSort(num,0,num.length-1);
        // System.out.println(Arrays.toString(num));
        ArrayList<Integer> list = GetLeastNumbers_Solution(num, 3);
        System.out.println(list);

        PriorityQueue<Integer> queue = new PriorityQueue<>((x1, x2) -> (x1 - x2));
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }

}
