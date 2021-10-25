package fzu.com.test;

public class TestHero {
    /*
    产生的问题：加血量可能会超过1000，因为当血量到达1000的时候，当前线程可能继续唤醒一条加血线程，此时被唤醒的这个线程在上次停止的位置继续执行，
    由于此时血量已经是1000，它在加1就超过了。
    解决方法， 将加血线程中的唤醒操作去掉
     */
    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        Thread[] addThreads = new Thread[2];
        Thread[] reduceThreads = new Thread[5];
        for (int i = 0; i < reduceThreads.length; i++) {
            Thread t = new Thread("reduce" + i) {
                public void run() {
                    while (true) {
                        gareen.hurt();

                        try {
                            //减慢掉血的速度
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                }
            };
            t.start();
            //addThreads[i] = t;
        }

        for (int i = 0; i < addThreads.length; i++) {
            Thread t = new Thread("add" + i) {
                public void run() {
                    while (true) {
                        gareen.recover();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            };
            t.start();
            //reduceThreads[i]=t;
        }

    }
}
