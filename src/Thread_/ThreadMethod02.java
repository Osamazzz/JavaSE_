package Thread_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程吃了" + i + "包子");
            if (i == 5) {
//                t2.join();//让子线程先运行（线程插队），运行完了再接着运行主线程
                Thread.yield();//主线程礼让，但不一定成功(此时cpu资源可能相对丰富)
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程吃了" + i + " 包子");
        }
    }
}