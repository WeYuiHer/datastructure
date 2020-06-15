package 背包问题;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String s = sc.next();
            System.out.println(play(s));
        }
    }

    public static String play(String s) {
        int len = s.length();
        boolean[] vis = new boolean[len];
        if ((len & 1) == 1)
            return "NO";
        int pre = 0;
        int cur = 1;
        int cnt = 0;
        char[] chs = s.toCharArray();
        while (cur < len) {
            if (chs[cur] == chs[pre]) {
                cnt += 2;
                vis[pre] = true;
                vis[cur] = true;
                while (pre >= 0 && vis[pre])
                    pre--;
                cur++;
                if (pre < 0) {
                    pre = cur;
                    cur++;
                }
            } else {
                pre = cur;
                cur++;
            }
            System.out.println("pre = " + pre + "  cur = " + cur);
        }
        System.out.println("cnt = " + cnt);
        return cnt == len ? "YES" : "NO";
    }

}