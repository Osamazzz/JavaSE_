package Thread_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        //如果希望main线程控制t1线程，可以修改loop
        // 让t1退出run的while循环，从而终止t1线程
        Thread.sleep(10 * 1000);//10s
        t1.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {

        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中" + count);
        }
    }
}