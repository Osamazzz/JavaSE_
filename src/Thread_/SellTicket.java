package Thread_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class SellTicket {
    public static void main(String[] args) {
        //创建三个线程
        Sell01 sell01 = new Sell01();
        Sell01 sell02 = new Sell01();
        Sell01 sell03 = new Sell01();
        sell01.start();
        sell02.start();
        sell03.start();

        Sell02 sell021 = new Sell02();
        //创建三个线程
        new Thread(sell021).start();
        new Thread(sell021).start();
        new Thread(sell021).start();
    }
}

class Sell01 extends Thread {
    private static int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            //有可能三个线程同时进入，出现卖超的现象(票为负数)
            if (ticketNum <= 0) {
                System.out.println("卖光了...");
                break;
            }
            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName()
            + "售出一张票, 剩余票数=" + (--ticketNum));
        }
    }
}

class Sell02 implements Runnable {
    //这里就不用静态修饰了，因为只创建一个这个类对象
    private int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            //有可能三个线程同时进入，出现卖超的现象(票为负数)
            if (ticketNum <= 0) {
                System.out.println("卖光了...");
                break;
            }
            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName()
                    + "售出一张票, 剩余票数=" + (--ticketNum));
        }
    }
}
