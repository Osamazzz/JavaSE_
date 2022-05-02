package Learning.Thread;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
        Animal animal = new Animal();
        //这里使用了代理模式
        Thread thread = new Thread(animal);//把animal对象放入Thread对象
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}
//通过实现runnable接口来实现线程类
//更加适合多个线程共享一个资源的情况，避免了单继承的限制
class Animal implements Runnable {
    private int num = 0;
    @Override
    public void run() {
        while (num != 5) {
            ++num;
            System.out.println(123);
            try {
                Thread.sleep(1000);//1s

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}