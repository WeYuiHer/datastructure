package basis.thread;

public class DepositThread extends Thread {
    private Account acc;
    private int money;

    public DepositThread(String name, Account acc, int money) {
        super(name);
        this.acc = acc;
        this.money = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                acc.deposit(money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
