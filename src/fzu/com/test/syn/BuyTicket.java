package fzu.com.test.syn;

public class BuyTicket implements Runnable {

    private int ticketNums = 10; // 票数

    boolean flag = true; // 外部停止方式

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(100); // 模拟延时
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }

    public static void main(String[] args) {
        BuyTicket t = new BuyTicket();

        new Thread(t, "小红").start();
        new Thread(t, "小明").start();
        new Thread(t, "小强").start();
    }
}
