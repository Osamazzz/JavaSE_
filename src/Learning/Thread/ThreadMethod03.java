package Learning.Thread;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        //用户线程与守护线程
        //用户线程也叫工作线程，当线程的任务执行完或以通知方式结束
        //守护线程是为工作线程服务的，当所有的用户线程结束时，守护线程自动结束
        //常见的守护线程有垃圾回收机制(gc)
        T3 t3 = new T3();

        t3.setDaemon(true);//将t3设为守护线程
        t3.start();
        for (int i = 1; i <= 10; i++) {//主线程
            System.out.println("hhh-main");
            Thread.sleep(1000);
        }
    }
}

//守护线程
class T3 extends Thread {
    @Override
    public void run() {
        for (; ; ) {//无限循环
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hhh-T3");
        }
    }
}
