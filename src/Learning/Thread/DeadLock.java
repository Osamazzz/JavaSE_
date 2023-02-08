package Learning.Thread;

/**
 * @author Obamazzz
 * @version 1.0
 * 模拟线程死锁
 */
public class DeadLock {
    public static void main(String[] args) {
        //多个线程都占用了对方的锁资源，导致死锁现象发生，
        // 在编程中要避免这种情况的发生
        DeadLockDemo A = new DeadLockDemo(true);
        DeadLockDemo B = new DeadLockDemo(false);
        A.setName("A");
        B.setName("B");
        //启动线程后，出现死锁现象，程序无法退出了...
        A.start();
        B.start();
        //  以下操作会释放锁
        //  1.当前线程的同步方法、或者同步代码块执行结束
        //  2.当前线程在同步代码块或方法中遇到break、return
        //  3.当前线程在同步代码块/方法中遇到未处理的Error/Exception，导致异常结束
        //  4.当前线程在同步代码块/方法中执行了线程对象的wait()方法，当前线程暂停
        //  但线程执行同步代码块/方法时，调用了Thread.sleep或者Thread.yield方法
        //  暂停当前线程执行，不会释放锁
        //  线程执行同步代码块，其他线程调用了该线程的suspend方法将该线程挂起，不会释放锁

    }
}

class DeadLockDemo extends Thread {
    static final Object o1 = new Object();
    static final Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        //如果flag为真，A线程就会得到o1对象锁，然后尝试获取o2对象锁
        //如果A拿不到o2对象锁，就会进入BLOCKED状态，无法进行下一步操作
        //如果flag为假，线程B就会先得到o2对象锁，然后尝试获取o1对象锁
        //如果B拿不到o1对象，就会BLOCKED，无法进行下一步操作
        if (flag) {
            synchronized (o1) {//对象互斥锁，下面就是同步代码
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        } else {
            synchronized (o2) {//对象互斥锁，
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}
