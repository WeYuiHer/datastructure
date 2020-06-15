package basis.thread;

public class ThreadTest {

    public static void main(String[] args) {
        Account account = new Account("jack的账户", 0);
        DrawThread drawThread = new DrawThread("A取钱", account, 500);
        //	DrawThread drawThread2 = new DrawThread("B取钱", account, 500);
        DepositThread depositThread = new DepositThread("C存钱", account, 500);
        drawThread.start();
        //	drawThread2.start();
        depositThread.start();


    }

}
