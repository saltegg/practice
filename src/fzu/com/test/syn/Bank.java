package fzu.com.test.syn;

public class Bank {

    public static void main(String[] args) {

        Account account = new Account(100, "基金");

        Drawing you = new Drawing(account, 50, "you");
        Drawing girl = new Drawing(account, 100, "girl");

        you.start();
        girl.start();
    }
}

class Account {

    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {

    Account account; // 账户
    int drawingMoney; // 取了多少钱
    int nowMoney; // 现在手里有多少钱

    public Drawing(Account aAccount, int aDrawingMoney, String name) {
        super(name);
        account = aAccount;
        drawingMoney = aDrawingMoney;
    }

    @Override
    public void run() {

        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money -= drawingMoney;
            nowMoney += drawingMoney;

            System.out.println(account.name + "余额为：" + account.money);
            System.out.println(this.getName() + "手里的钱：" + nowMoney);
        }
    }
}
