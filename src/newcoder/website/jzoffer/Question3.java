package newcoder.website.jzoffer;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
    int val;
    boolean alive;

    public Node(int val) {
        this.val = val;
        this.alive = true;
    }
}

public class Question3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Node> list = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            Node node = new Node(i);
            list.add(node);
        }
        int cnt = n + 1;
        int st = 0;
        while (cnt > 1) {
            int x = 1;
            boolean b = true;
            for (int i = st; i < n + 1; i++) {
                if ((list.get(i).alive == true) && (x % 2 == 1)) {
                    list.get(i).alive = false;
                    x++;
                    cnt--;
                    System.out.println("*****");
                } else if (b && (list.get(i).alive == true) && (x % 2 == 0)) {
                    st = i;
                    b = false;
                }
            }
            System.out.println("cnt = " + cnt + "  st = " + st);
        }
        for (int i = 0; i < n + 1; i++) {
            if (list.get(i).alive == true) {
                System.out.println(list.get(i).val);
                break;
            }
        }

    }

}