package leetcode.question2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Question0307 {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        Integer peek = queue.peek();
        System.out.println(peek);
        System.out.println(queue.poll());

        Deque<Integer> q2 = new LinkedList<>();
        String s1 = "1.1";
        String[] split = s1.split("\\.");
        System.out.println(Arrays.toString(split));
    }
}
