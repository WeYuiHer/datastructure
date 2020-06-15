package basis.thread;

public class DrawThread extends Thread {
    private Account acc;
    private int money;

    public DrawThread(String name, Account acc, int money) {
        super(name);
        this.acc = acc;
        this.money = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                acc.draw(money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
