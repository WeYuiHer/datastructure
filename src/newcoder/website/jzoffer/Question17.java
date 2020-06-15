package newcoder.website.jzoffer;

import java.lang.reflect.Array;
import java.util.*;

//滑动窗口的最大值
public class Question17 {

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            int x = num[i];
            if (deq.isEmpty()) {
                deq.addLast(x);
            } else {
                while (!deq.isEmpty() && deq.getLast() < x)
                    deq.removeLast();
                deq.addLast(x);
            }
            if (i >= size - 1) {
                int h = deq.getFirst();
                list.add(h);
                if (h == num[i - size + 1]) {
                    deq.removeFirst();
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> list = maxInWindows(num, 3);
        System.out.println(list);
    }
}
