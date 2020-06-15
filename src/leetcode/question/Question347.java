package leetcode.question;

import java.util.*;

// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
public class Question347 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> cnt.get(n1) - cnt.get(n2));
        Set<Integer> keySet = cnt.keySet();
        for (int x : keySet) {
            heap.offer(x);
            if (heap.size() > k)
                heap.poll();
        }
        while (!heap.isEmpty() && k-- > 0)
            ans.add(0, heap.poll());

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3};
        System.out.println(topKFrequent(nums, 2));
    }

}
