package Thread_;

import org.junit.Test;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class SellTicket {
    public static void main(String[] args) {
        // 线程同步机制
        // 在多线程编程中一些敏感数据不允许被多个线程同时访问
        // 此时就使用同步访问机制保障数据在任何时刻最多有一个线程被访问
        // 保障数据的完整性
        // 即当有一个线程在对内存进行操作时其他线程都不可以对这个内存地址进行操作
        // 直到该线程完成操作其他线程才能进行操作
        // synchronized与对象的互斥锁联系，当某个对象用synchronized修饰
        // 表明该对象在任意时刻只能由一个线程访问，这会导致程序的执行效率变低
        // 非静态同步方法的锁可以是this可以是其他对象(但要求是同一对象)
        // 静态的方法的锁为当前类本身
        //创建三个线程
        Sell01 sell01 = new Sell01();
        Sell01 sell02 = new Sell01();
        Sell01 sell03 = new Sell01();
//        sell01.start();
//        sell02.start();
//        sell03.start();

        Sell02 sell021 = new Sell02();
        //创建三个线程
//        new Thread(sell021).start();
//        new Thread(sell021).start();
//        new Thread(sell021).start();

        Sell03 sell031 = new Sell03();
        new Thread(sell031).start();
        new Thread(sell031).start();
        new Thread(sell031).start();
    }
    @Test
    public void test3() {
        Sell03 sell031 = new Sell03();
        new Thread(sell031).start();
        new Thread(sell031).start();
        new Thread(sell031).start();
        System.out.println(123);
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

class Sell03 implements Runnable {
    //使用synchronized关键字
    private static int ticketNum = 100;
    private boolean flag = true;
    //同步方法，这时互斥锁在this对象上
    public synchronized void m1() {//同一时刻只能有一个线程执行这个方法
        if (ticketNum <= 0) {
            System.out.println("卖光了...");
            flag = false;//退出循环
            return;//退出方法
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
    public void m2() {
        // 同步代码块
        // 要保证这个this对象是大家共享的对象，所以使用runnable实现更好
        synchronized (this) {//这个锁是非公平锁
            if (ticketNum <= 0) {
                System.out.println("卖光了...");
                flag = false;//退出循环
                return;//退出方法
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
    //静态方法
    public static void m3() {
        // 同步代码块
        //默认锁对象为当前类.class
        synchronized (Sell03.class) {
            if (ticketNum <= 0) {
                System.out.println("卖光了...");
//                flag = false;退出循环
                return;//退出方法
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
    @Override
    public void run() {//同步方法,同一时刻只能有一个线程来执行方法
        while (flag) {
            m1();
        }
    }
}
