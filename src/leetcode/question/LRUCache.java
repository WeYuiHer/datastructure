package leetcode.question;


import java.util.HashMap;

public class LRUCache {
    class Node {
        String key;
        int val;
        Node pre;
        Node next;
    }

    Node head, rear;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        rear = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            adjustTohead(node);
            return node.val;
        }
    }

    //将该节点调整到链表头
    public void adjustTohead(Node node) {
        Node pre = node.pre;
        if (pre == null) return; //已经是在第一个节点

        //如果node是最后一个节点
        if (node == rear) {
            pre.next = null;
            rear = pre;
        } else {
            node.next.pre = pre;
            pre.next = node.next;
        }
        head.pre = node;
        node.next = head;
        head = node;

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) { //不在缓存中，需要添加进去
            node = new Node();
            node.val = value;
            node.key = key + "" + value;
            if (map.size() < capacity) {    //缓存未满
                if (head == null) {
                    head = node;
                    rear = head;
                } else {
                    head.pre = node;
                    node.next = head;
                    head = node;
                }
            } else {                  //缓存满了需删除链表最后一个
                map.remove(rear.key);
                Node pre = rear.pre;
                if (pre == null) {  //只有一个节点
                    head = rear = node;
                } else {
                    pre.next = null;
                    rear = pre;
                }
            }
            map.put(key, node);
        } else {                  //在缓存中，调整到链表头
            node.val = value;
            Node pre = node.pre;
            if (pre == null)
                return;
            else {
                adjustTohead(node);
            }
        }
    }

    public void print(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p.val + "   ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
		/*
		    ["LRUCache","put","put","get","put","put","get"]
			[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
		* */
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.get(2);       // 返回  1
        cache.put(1, 1);    // 该操作会使得密钥 2 作废
        //	cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 1);    // 该操作会使得密钥 1 作废
        cache.get(2);       // 返回 -1 (未找到)
        //	cache.get(3);       // 返回  3
        //	cache.get(4);

    }

}
