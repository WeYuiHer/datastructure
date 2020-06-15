package hekui.thread;

public class ThreadDemo2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + i);
            if (this.isInterrupted()) {
                System.out.println("已经是停止状态了，break");
                // break;
                return;
            }

        }
        System.out.println("****");
    }

    public static void main(String[] args) {
        ThreadDemo2 t = new ThreadDemo2();
        t.start();
        try {
            t.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }

}
