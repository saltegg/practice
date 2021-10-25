package fzu.com.test.co;

public class TestPC {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }
}

class Consumer extends Thread {

    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    // 消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("消费了" + container.pop().id + "只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    // 生产
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                container.push(new Chicken(i));
                System.out.println("生产了" + i + "只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {  // 缓冲区

    Chicken[] chickens = new Chicken[10];

    int count = 0; // 计数器

    // 生产者放入产品
    public synchronized void push(Chicken chicken) throws InterruptedException {
        // 如果容器满了，则等待消费
        if (count == chickens.length) {
            // 通知消费者消费，生产等待
            this.wait();
        }

        chickens[count++] = chicken;

        // 通知消费者消费
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized Chicken pop() throws InterruptedException {
        // 判断能否消费
        if (count == 0) {
            // 等待生产者生产，消费者等待
            this.wait();
        }

        Chicken chicken = chickens[--count];

        // 吃完了通知生产者生产
        this.notifyAll();
        return chicken;
    }
}