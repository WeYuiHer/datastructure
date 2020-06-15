package basis.thread;

public class Account {
    private String countID;
    private int balance;
    private boolean flag = false;

    public Account() {
    }

    public Account(String countID, int balance) {
        this.countID = countID;
        this.balance = balance;
    }

    //取钱
    public synchronized void draw(int money) throws InterruptedException {
        if (flag) {
            System.out.println(Thread.currentThread().getName() + "取钱" + money);
            this.balance -= money;
            System.out.println("余额：" + this.balance);
            flag = false;
            notifyAll();
        } else {
            wait();
        }
    }

    //存钱
    public synchronized void deposit(int money) throws InterruptedException {
        if (!flag) {
            System.out.println(Thread.currentThread().getName() + "存钱" + money);
            this.balance += money;
            System.out.println("余额：" + this.balance);
            flag = true;
            notifyAll();
        } else {
            wait();
        }

    }

}
