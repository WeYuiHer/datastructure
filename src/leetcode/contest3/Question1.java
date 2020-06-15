package leetcode.contest3;

/*
* A 和 B 在一个 3 x 3 的网格上玩井字棋。
井字棋游戏的规则如下：
玩家轮流将棋子放在空方格 (" ") 上。
第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
"X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
如果所有方块都放满棋子（不为空），游戏也会结束。
游戏结束后，棋子无法再进行任何移动。
给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），
* 它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。

* */
public class Question1 {
    public String tictactoe(int[][] moves) {
        char[][] map = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                map[i][j] = ' ';
        }
        int cnt = 1;
        boolean f = true;
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            char ch = f ? 'X' : 'O';
            map[x][y] = ch;
            boolean win = check(x, y, ch, map);
            if (win)
                return f ? "A" : "B";
            f = !f;
            cnt++;
            if (cnt > 9)
                break;
        }
        return cnt > 9 ? "Draw" : "Pending";
    }

    public boolean check(int x, int y, char ch, char[][] map) {
        int cnt = 1;
        //向左
        int i = x;
        int j = y - 1;
        while (j >= 0) {
            if (map[i][j] == ch) {
                cnt++;
                j--;
                if (cnt == 3)
                    return true;
            } else
                break;
        }
        //向右
        j = y + 1;
        while (j < 3) {
            if (map[i][j] == ch) {
                cnt++;
                j++;
                if (cnt == 3)
                    return true;
            } else
                break;
        }
        cnt = 1;
        //向下
        i = x + 1;
        j = y;
        while (i < 3) {
            if (map[i][j] == ch) {
                cnt++;
                i++;
                if (cnt == 3)
                    return true;
            } else
                break;
        }
        //向上
        i = x - 1;
        while (i >= 0) {
            if (map[i][j] == ch) {
                cnt++;
                i--;
                if (cnt == 3)
                    return true;
            } else
                break;
        }
        cnt = 1;
        //斜方向
        i = x + 1;
        j = y + 1;
        while (i < 3 && j < 3) {
            if (map[i][j] == ch) {
                cnt++;
                i++;
                j++;
                if (cnt == 3)
                    return true;
            } else
                break;
        }
        //斜方向
        i = x - 1;
        j = y - 1;
        while (i >= 0 && j >= 0) {
            if (map[i][j] == ch) {
                cnt++;
                i--;
                j--;
                if (cnt == 3)
                    return true;
            } else
                break;
        }
        cnt = 1;
        i = x - 1;
        j = y + 1;
        while (i >= 0 && j < 3) {
            if (map[i][j] == ch) {
                cnt++;
                i--;
                j++;
                if (cnt == 3)
                    return true;
            } else
                break;
        }
        i = x + 1;
        j = y - 1;
        while (i < 3 && j >= 0) {
            if (map[i][j] == ch) {
                cnt++;
                i++;
                j--;
                if (cnt == 3)
                    return true;
            } else
                break;
        }
        return false;
    }


}
