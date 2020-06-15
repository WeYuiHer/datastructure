package hekui.thread;

class MyThread implements Runnable {
    int i = 500;

    public MyThread() {

    }

    @Override
    public void run() {
        while (i-- > 0)
            System.out.println(i);
    }
}

public class ThreadDemo {

    public static void main(String[] args) {
        MyThread my = new MyThread();
        Thread t1 = new Thread(my, "a");
        Thread t2 = new Thread(my, "b");
        Thread t3 = new Thread(my, "c");

       /*
        MyThread t1 = new MyThread("A");
        MyThread t2 = new MyThread("B");
        MyThread t3 = new MyThread("C");*/
        t1.start();
        t2.start();
        t3.start();

    }


}
