package leetcode.question;

/*
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * */
public class Question223 {
    //x1    y1      x2      y2      x3  y3      x4      y4
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s1 = (C - A) * (D - B);
        int s2 = (G - E) * (H - F);
        int s3 = 0;
        if (E >= C || G <= A || F >= D || H <= B) {
            return s1 + s2;
        } else {
            int x = 0;
            if (G >= C && E >= A && E <= C)
                x = C - E;
            else if (E <= A && G >= A && G <= C)
                x = G - A;
            else if (E <= A && G >= C)
                x = C - A;
            else
                x = G - E;
            int y = 0;
            if (F >= B && F <= D && H >= D)
                y = D - F;
            else if (F <= B && H >= B && H <= D)
                y = H - B;
            else if (F <= B && H >= D)
                y = D - B;
            else
                y = H - F;
            System.out.println("x = " + x + " y = " + y);
            s3 = x * y;
            return s1 + s2 - s3;
        }
    }

    //返回(x1,x2),(x3,x4)交集的长度
    public int count(int x1, int x2, int x3, int x4) {
        if (x3 >= x2 || x4 <= x1)
            return 0;
        else {

            return 1;
        }
    }


    public static void main(String[] args) {
        //	int i = computeArea(0, 0, 0, 0, -1, -1, 1, 1);
        int i = computeArea(-2, -2, 2, 2, 1, -3, 3, 3);
        System.out.println(i);
    }
}
