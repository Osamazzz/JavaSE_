package Learning.Thread;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        //线程常用方法
        Test test01 = new Test();

        test01.setName("Obama ");//设置线程名
        test01.setPriority(Thread.MIN_PRIORITY);
        test01.start();//启动线程

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + (i + 1));
        }
        System.out.println(test01.getName());//返回线程名
        //当运行到这里时，就会中断test01的休眠，不是终止该线程
        test01.interrupt();
    }
}

class Test extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "eat...");
            }
            try {
                System.out.println(Thread.currentThread().getName() + "sleep...");
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                //当该线程执行interrupt方法时就会catch一个异常，在这里可以加入自己的业务代码
                // InterruptedException是捕获一个中断异常
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
            }
        }
    }
}