package fzu.com.test.syn;

public class DeadLock {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0, "公主");
        MakeUp g2 = new MakeUp(1, "王子");
        g1.start();
        g2.start();
    }
}


class Lipstick {

}

class Mirror {

}

class MakeUp extends Thread {

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice; // 选择
    String girlName; // 使用者


    public MakeUp(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(Thread.currentThread().getName() + "获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror) {
                    System.out.println(Thread.currentThread().getName() + "获得镜子的锁");
                }
            }
        } else {
            synchronized (mirror) {
                System.out.println(Thread.currentThread().getName() + "获得镜子的锁");
                Thread.sleep(1000);
                synchronized (lipstick) {
                    System.out.println(Thread.currentThread().getName() + "获得口红的锁");
                }
            }
        }
    }
}