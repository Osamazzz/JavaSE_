package Thread_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ThreadExercise02 {
    public static void main(String[] args) {
        Money money = new Money();
        new Thread(money).start();
        new Thread(money).start();
    }
}

class Money implements Runnable {
    private static int money = 10000;
    private boolean flag = true;

    public synchronized void costMoney() {
        if (money < 1000) {
            System.out.println("没钱啦");
            flag = false;
            return;
        }
        money -= 1000;//一次取1000
        System.out.println("卡内剩余余额为" + money);
        try {
            Thread.sleep(1000);//1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (flag) {
            costMoney();
        }
    }

}