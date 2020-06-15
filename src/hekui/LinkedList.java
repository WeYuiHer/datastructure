package hekui;

import org.w3c.dom.ls.LSException;

import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LinkedNode {
    int data;
    LinkedNode next;


}

public class LinkedList {
    LinkedNode head;
    Scanner sc = new Scanner(System.in);
    int length = 0;

    public LinkedList() {
        head = null;
        length = 0;
    }

    //头插
    public LinkedNode createListFromHead(int len) {
        LinkedNode p = null;
        int data = 0;
        for (int i = 0; i < len; i++) {
            data = sc.nextInt();
            p = new LinkedNode();
            p.data = data;
            if (head == null) {
                head = p;
                head.next = null;
            } else {
                p.next = head;
                head = p;
            }
        }
        this.length = len;
        return head;
    }

    //尾插法
    public LinkedNode createList(int len) {
        LinkedNode p = null;
        LinkedNode rear = null;
        int data = 0;
        for (int i = 0; i < len; i++) {
            data = sc.nextInt();
            p = new LinkedNode();
            p.data = data;
            p.next = null;
            if (head == null) {
                head = p;
                rear = head;
            } else {
                rear.next = p;
                rear = p;
            }

        }
        this.length = len;
        return head;
    }

    //尾插法
    public LinkedNode create(int[] datas) {
        LinkedNode p = null;
        LinkedNode rear = null;
        for (int i = 0; i < datas.length; i++) {
            p = new LinkedNode();
            p.data = datas[i];
            p.next = null;
            if (head == null) {
                head = p;
                rear = head;
            } else {
                rear.next = p;
                rear = p;
            }
        }
        this.length = datas.length;
        return head;
    }

    //print
    public void print() {
        LinkedNode p = head;
        while (p != null) {
            System.out.print(p.data + "  ");
            p = p.next;
        }
    }

    public void print(LinkedNode h) {
        LinkedNode p = h;
        while (p != null) {
            System.out.print(p.data + "  ");
            p = p.next;
        }
    }

    public LinkedNode reverse() {
        LinkedNode pre = null;
        LinkedNode p = head;
        LinkedNode q = head.next;
        while (q != null) {
            p.next = pre;
            pre = p;
            p = q;
            q = q.next;

        }
        p.next = pre;
        return p;
    }

    public LinkedNode reverse2() {
        LinkedNode p = head;
        LinkedNode h = head.next;
        LinkedNode q = null;
        p.next = null;
        while (h != null) {
            q = h.next;
            h.next = p;
            p = h;
            h = q;
        }
        return p;
    }

    //递归翻转链表
    public LinkedNode reverse(LinkedNode head) {
        if (head == null || head.next == null)
            return head;
        LinkedNode nextNode = head.next;
        head.next = null;
        LinkedNode newHead = reverse(nextNode);
        nextNode.next = head;
        return newHead;
    }

    //递归翻转链表
    public LinkedNode reverse3(LinkedNode head) {
        if (head == null || head.next == null)
            return head;
        LinkedNode p = reverse3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    /*public LinkedNode reverseList(LinkedNode head) {
        if(head==null||head.next==null)
            return head;
        LinkedNode pre = null,cur = head,next = null;
        while(cur!=null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }*/
    public LinkedNode reverseList(LinkedNode head) {
        if (head == null || head.next == null)
            return head;
        LinkedNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /*
    * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    说明:
    1 ≤ m ≤ n ≤ 链表长度。
    示例:
    输入: 1->2->3->4->5->NULL, m = 2, n = 4
    输出: 1->4->3->2->5->NULL
    * */
    public LinkedNode reverseBetween(int m, int n) {
        LinkedNode h = new LinkedNode();
        h.next = head;
        LinkedNode pre = null, p = h, r = null, q = null, r1 = null;
        for (int i = 0; i < m; i++) {
            pre = p;
            p = p.next;
        }
        q = pre;

        for (int i = m; i <= n; i++) {
            r = p.next;
            if (r1 == null) {
                r1 = p;
            } else {
                p.next = pre;
            }
            pre = p;
            p = r;
        }
        q.next = pre;
        r1.next = r;
        return h.next;
    }


    /*
    * ListNode p = head,q=head;
            for(int i=0;i<n;i++){
                if(q!=null)
                    q=q.next;

            }
            if(q==null)
                return head.next;
            q=q.next;
            while(q!=null){
                p=p.next;
                q=q.next;
            }
            p.next=p.next.next;
            return head;
    * */
    //删除链表的倒数第n个节点
    public LinkedNode delLastN(int n) {
        LinkedNode fast = head;
        LinkedNode slow = null;
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
        if (fast != null) {
            slow = head;
            fast = fast.next;
        }
        if (fast == null)
            return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null)
            slow.next = slow.next.next;
        else
            slow.next = null;
        return head;
    }

    //两两交换链表节点
    public LinkedNode swapPairs() {
        LinkedNode p = head, r, rear = null, q, h = null;
        if (head == null || head.next == null)
            return head;
        while (p != null && p.next != null) {
            r = p.next;
            if (h == null) {
                h = r;
            }
            q = r.next;
            r.next = p;
            if (rear != null)
                rear.next = r;
            rear = p;
            p = q;
        }
        if (p != null) {
            p.next = null;
            rear.next = p;
        } else
            rear.next = null;
        return h;
    }

    /*
    * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
        你应当保留两个分区中每个节点的初始相对位置。
        示例:
        输入: head = 1->4->3->2->5->2, x = 3
        输出: 1->2->2->4->3->5
。
    * */
    public LinkedNode partition(int x) {
        LinkedNode p = head, h1 = null, h2 = null, r1 = null, r2 = null;
        int val;
        while (p != null) {
            val = p.data;
            if (val < x) {
                if (h1 == null) {
                    h1 = p;
                    r1 = p;
                } else {
                    r1.next = p;
                    r1 = p;
                }
            } else {
                if (h2 == null) {
                    h2 = p;
                    r2 = p;
                } else {
                    r2.next = p;
                    r2 = p;
                }
            }
            p = p.next;
        }
        if (r2 != null)
            r2.next = null;
        if (h1 == null)
            return h2;
        r1.next = h2;
        return h1;
    }
/*
* 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
示例 1:
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
* */

    public LinkedNode rotateRight(int k) {
        if (head == null || head.next == null) return head;
        int len = 0;
        LinkedNode p = head, rear = null;
        LinkedNode h = new LinkedNode();
        h.next = head;
        LinkedNode first, sconed;
        first = sconed = h;
        while (p != null) {
            len++;
            rear = p;
            p = p.next;
        }
        int lastN = k % len;
        if (lastN != 0) {
            while (lastN-- > 0)
                first = first.next;
            while (first.next != null) {
                first = first.next;
                sconed = sconed.next;
            }
            h = sconed.next;
            rear.next = head;
            sconed.next = null;
        } else
            return head;

        return h;
    }

    /*
    * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
    * 并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
    * */
    public LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
        int jw = 0;
        LinkedNode h = null, p1 = l1, p2 = l2, pre = null;
        int sum = 0;

        while (p1 != null && p2 != null) {
            sum = p1.data + p2.data + jw;
            if (sum >= 10) {
                jw = 1;
                sum -= 10;
            } else
                jw = 0;
            p1.data = sum;
            if (h == null) {
                h = p1;
            }
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            p1 = p2;
            pre.next = p1;
        }
        while (p1 != null) {
            sum = jw + p1.data;
            if (sum >= 10) {
                jw = 1;
                p1.data = sum - 10;
            } else {
                p1.data = sum;
                jw = 0;
                break;
            }
            pre = p1;
            p1 = p1.next;
        }
        if (jw == 1) {
            LinkedNode r = new LinkedNode();
            r.data = 1;
            pre.next = r;
        }

        return h;
    }

    /*
    * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
示例 :
给定这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5
说明 :
你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    * */
    public LinkedNode reverseKGroup(LinkedNode head, int k) {
        LinkedNode h = new LinkedNode();
        h.next = head;
        LinkedNode pre = h, end = h;
        LinkedNode start, next;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            if (end == null)
                break;

            start = pre.next;
            next = end.next;
            end.next = null;
            pre.next = reverse(start);

            start.next = next;
            pre = start;
            end = pre;

        }
        return h.next;
    }

    /*
    * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
    示例 1:
    输入: 1->2->3->3->4->4->5
    输出: 1->2->5
    示例 2:
    输入: 1->1->1->2->3
    输出: 2->3
    * */
    public LinkedNode deleteDuplicates(LinkedNode head) {
        if (head == null || head.next == null) return head;
        LinkedNode h = new LinkedNode();
        h.next = head;
        LinkedNode fast = head, slow = h;
        while (fast != null) {
            if (fast.next == null || fast.next.data != fast.data) {
                if (slow.next == fast)
                    slow = fast;
                else
                    slow.next = fast.next;
            }
            fast = fast.next;
        }
        return h.next;
    }


    /*
     * P41 打印两个有序链表的公共部分
     * */
    public void printCommonPart(LinkedNode head1, LinkedNode head2) {
        int val1, val2;
        while (head1 != null && head2 != null) {
            val1 = head1.data;
            val2 = head2.data;
            if (val1 < val2)
                head1 = head1.next;
            else if (val1 > val2)
                head2 = head2.next;
            else {
                System.out.print(val1 + "  ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
    /*
     *
     * */

    public LinkedNode removeLastKthNode(LinkedNode head, int lastKth) {
        if (head == null || lastKth < 0) return null;
        LinkedNode p = head;
        LinkedNode node = null;
        while (p != null) {
            lastKth--;
            p = p.next;
        }
        if (lastKth == 0) {
            node = head;
            this.head = head.next;
            return node;
        }
        p = head;
        while (++lastKth != 0) {
            p = p.next;
        }
        node = p.next;
        p.next = p.next.next;
        return node;
    }

    /*
    * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
        示例:
        输入:
        [
          1->4->5,
          1->3->4,
          2->6
        ]
        输出: 1->1->2->3->4->4->5->6
    * */
    public LinkedNode mergeKLists(LinkedNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        List<LinkedNode> list = new java.util.LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            list.add(lists[i]);
        }
        while (list.size() > 1) {
            list.add(mergeTwoLists(list.remove(0), list.remove(1)));
        }
        return list.get(0);
    }

    public LinkedNode mergeTwoLists(LinkedNode h1, LinkedNode h2) {
        LinkedNode head = new LinkedNode();
        LinkedNode rear = head;
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                rear.next = h1;
                rear = h1;
                h1 = h1.next;
            } else {
                rear.next = h2;
                rear = h2;
                h2 = h2.next;
            }
        }
        if (h1 != null)
            rear.next = h1;
        if (h2 != null)
            rear.next = h2;
        return head.next;
    }

    /*
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * */
    public LinkedNode sortList(LinkedNode head) {
        LinkedNode dummyHead = new LinkedNode();
        dummyHead.next = head;
        LinkedNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        for (int i = 1; i < len; i <<= 1) {
            LinkedNode cur = dummyHead.next;
            LinkedNode tail = dummyHead;
            while (cur != null) {
                LinkedNode left = cur;
                LinkedNode right = cut(cur, i);
                cur = cut(right, i);
                tail.next = merge2(left, right);
                while (tail.next != null) {
                    tail = tail.next; // 保持最尾端
                }
            }
        }

        return dummyHead.next;
    }

    /*
     * 将链表切割为两个链表，第一个链表包含n个节点，返回剩余的链表
     * */
    public LinkedNode cut(LinkedNode head, int n) {
        LinkedNode h = new LinkedNode();
        h.next = head;
        LinkedNode p = h;
        while (p != null && n-- > 0) {
            p = p.next;
        }
        if (p == null) return null;
        LinkedNode node = p.next;
        p.next = null;
        return node;
    }

    public LinkedNode merge2(LinkedNode h1, LinkedNode h2) {
        LinkedNode head = new LinkedNode();
        LinkedNode rear = head;
        LinkedNode p1 = h1, p2 = h2;
        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                rear.next = p1;
                rear = p1;
                p1 = p1.next;
            } else {
                rear.next = p2;
                rear = p2;
                p2 = p2.next;
            }
        }
        if (p1 != null)
            rear.next = p1;
        else
            rear.next = p2;
        return head.next;
    }

    /**
     * Question328 奇偶链表
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public LinkedNode oddEvenList(LinkedNode head) {
        if (head == null || head.next == null)
            return head;
        LinkedNode h1 = null, h2 = null, r1 = null, r2 = null;
        boolean even = false;
        LinkedNode p = head;
        while (p != null) {
            if (even) {  //偶数
                if (h2 == null) {
                    h2 = p;
                    r2 = p;
                } else {
                    r2.next = p;
                    r2 = p;
                }
            } else {
                if (h1 == null) {
                    h1 = p;
                    r1 = p;
                } else {
                    r1.next = p;
                    r1 = p;
                }
            }
            even = !even;
            p = p.next;
        }
        r2.next = null;
        r1.next = h2;
        return h1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 7, 8, 10, 12};
        LinkedList list = new LinkedList();
        list.create(nums);
        LinkedNode head = list.reverseList(list.head);
        list.print(head);
//        LinkedNode head = list.oddEvenList(list.head);
//        list.print(head);
       /* int[] nums2 = {1,3,4,5,8,10,13,14,15};
        LinkedList list2 = new LinkedList();
        list2.create(nums2);
        //list.printCommonPart(list.head,list2.head);
        LinkedNode x = list.removeLastKthNode(list.head, 7);
        System.out.println(x.data);
        list.print();*/

    }


}
