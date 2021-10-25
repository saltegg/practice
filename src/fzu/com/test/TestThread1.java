package fzu.com.test;

public class TestThread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在执行多线程" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();
        TestThread1 testThread2 = new TestThread1();
        testThread2.start();
        testThread1.join();
        testThread2.join();
        //for (int i = 0; i < 2000; i++) {
            System.out.println("我是主线程");
        //}
    }
}
