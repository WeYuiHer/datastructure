package leetcode.question2;

import java.util.*;

public class LFUcache {

    class Node {
        int freq;
        int key;
        int val;

        public Node(int freq, int key, int val) {

            this.freq = freq;
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    int size = 0;
    int min;
    HashMap<Integer, Node> cache;    //缓存
    HashMap<Integer, LinkedHashSet<Node>> freqMap;   //每个频次的set

    public LFUcache(int capacity) {
        this.min = 1;
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        else {
            incrFreq(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        node.val = value;
        if (node != null) {
            cache.put(key, node);
            incrFreq(node);
            return;
        } else {
            if (size == capacity) {
                LinkedHashSet<Node> minSet = freqMap.get(min);
                Node n = minSet.iterator().next();
                minSet.remove(n);
                Node remove = cache.remove(n.key);
                size--;
                System.out.println("canche remove  " + remove.key + "  " + cache.containsKey(n.key));
            }
            node = new Node(1, key, value);
            LinkedHashSet<Node> set = freqMap.get(1);
            if (set == null) {
                set = new LinkedHashSet<Node>();
                freqMap.put(1, set);
            }
            set.add(node);
            cache.put(key, node);
            min = 1;
            size++;
        }
    }

    public void incrFreq(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (set.size() == 0 && freq == min) {
            min++;
        }
        node.freq = freq + 1;
        LinkedHashSet<Node> set2 = freqMap.get(node.freq);
        if (set2 == null) {
            set2 = new LinkedHashSet<Node>();
            freqMap.put(node.freq, set2);
        }
        set2.add(node);
    }

    public static void main(String[] args) {
        /*   LFUcache lfUcache = new LFUcache(2);
         *//*
        * ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
        * *//*
        lfUcache.put(1,1);
        lfUcache.put(2,2);
        System.out.println("get 1 = "+lfUcache.get(1));
        lfUcache.put(3,3);
        System.out.println("get 2 = "+lfUcache.get(2));
        System.out.println("get 3 = "+lfUcache.get(3));
        lfUcache.put(4,4);
        lfUcache.get(1);
        lfUcache.get(3);
        lfUcache.get(4);*/

       /* PriorityQueue<String> strings = new PriorityQueue<>();
        strings.offer("2");
        strings.offer("1");
        strings.offer("10");
        while(!strings.isEmpty())
            System.out.println(strings.poll());*/
        ArrayList<String> list = new ArrayList<>();
        list.add("21");
        list.add("22");
        list.add("220");
        list.add("223");
        list.add("11");
        list.add("10");
        list.add("1");
        list.add("11");
        Collections.sort(list, (s1, s2) -> {
            int len1 = s1.length();
            int len2 = s2.length();
            boolean swap = false;
            if (len1 == len2)
                return s1.compareTo(s2);
            if (len1 < len2) {
                String t = s1;
                s1 = s2;
                s2 = t;
                len1 = s1.length();
                len2 = s2.length();
                swap = true;
            }
            int x = s1.substring(0, len2).compareTo(s2);
            if (x == 0) {
                char pre = s1.charAt(len2 - 1);
                int j = len2;
                while (j < len1) {
                    if (pre == s1.charAt(j))
                        j++;
                    else if (pre < s1.charAt(j))
                        return swap ? -1 : 1;
                    else
                        return swap ? 1 : -1;
                }
                return 0;
            } else
                return swap ? -x : x;
        });
        StringBuilder sb = new StringBuilder();
        for (String num : list)
            sb.append(num);
        System.out.println(sb.toString());

        PriorityQueue<String> strings = new PriorityQueue<>();
    }

}
