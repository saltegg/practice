package fzu.com.test;


// 多个线程同时操作一个对象
// 发现问题： 多个线程同时操作同一个资源时，线程不安全，数据紊乱
public class TestThread2 implements Runnable{

    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        TestThread2 ticket1 = new TestThread2();
        TestThread2 ticket2 = new TestThread2();
        new Thread(ticket1, "小明").start();
        new Thread(ticket1, "老师").start();
        new Thread(ticket2, "黄牛党").start();
    }
}
