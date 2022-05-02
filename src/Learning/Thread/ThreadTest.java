package Learning.Thread;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        // 线程有两种方法使用
        // 1.继承Thread类，重写run方法
        // 2.实现Runnable接口，实现run方法
        //创建cat对象
        Cat cat = new Cat();
        //  开辟一个新线程,会自动调用run方法
        //  start方法会调用start0方法（native方法，由JVM调用）
        cat.start();
//        cat.run();如果直接调用run，就相当于只是调用普通方法，并没有真正启动一个新线程
//        就会等到run执行完毕才会执行下面的for，而不是交替执行
        //当main线程启动子线程Thread-0，主线程不会阻塞，会继续执行->交替执行
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程" + i);
            Thread.sleep(1000);
        }
        //所有线程结束，进程才会结束
    }
}
//当一个类继承了thread类，该类就可以当做线程使用
//一般来说run方法会被重写
// 在thread类中实现了runnable接口的run方法
class Cat extends Thread {
    public int times = 0;
    @Override
    public void run() {//重写run方法写上自己的业务逻辑
        do {
            //每隔一秒输出helloWorld
            System.out.println("helloWorld");
            System.out.println("线程名=" + Thread.currentThread().getName());
            ++times;
            // 让该线程休眠一秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (times != 5);
    }
}