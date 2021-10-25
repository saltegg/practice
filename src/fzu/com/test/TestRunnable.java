package fzu.com.test;

public class TestRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在执行多线程" + i);
        }
    }

    public static void main(String[] args) {

        TestRunnable testRunnable = new TestRunnable();

        new Thread(testRunnable).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("我是主线程" + i);
        }
    }
}
