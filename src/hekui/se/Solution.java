package hekui.se;

public class Solution {
    class Node {
        int index;
        boolean alive;
        Node next;

        public Node(int index) {
            this.index = index;
            alive = true;
            next = null;
        }
    }

    public int LastRemaining_Solution(int n, int m) {
        Node head = null, pre = null, p = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            if (head == null) {
                head = node;
                pre = head;
            } else {
                pre.next = node;
                pre = node;
            }
            if (i == n - 1)
                pre.next = head;
        }
/*
        p = head;
        do{
            System.out.println(p.index+" "+p.alive);
            p = p.next;
        }while(p!=head);*/

        int cnt = n;
        p = head;
        while (cnt != 1) {
            int j = 0;
            while (j != m) {
                if (p.alive) {
                    j++;
                    if (j == m) {
                        System.out.println("删除了" + p.index);
                        break;
                    }
                }
                p = p.next;
            }
            cnt--;
            System.out.println("cnt = " + cnt);
            p.alive = false;
            p = p.next;
        }

        Node q = head;
        do {
            if (q.alive)
                return q.index;
            q = q.next;
        } while (q != head);

        return -1;
    }

    // 0 1 2 3 4
    public static void main(String[] args) {
        Solution solution = new Solution();
        int rest = solution.LastRemaining_Solution(5, 7);
        System.out.println("ans = " + rest);
    }

}