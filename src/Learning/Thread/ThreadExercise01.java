package Learning.Thread;

import java.util.Scanner;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ThreadExercise01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}

class A extends Thread {
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag) {
            int i = (int) (Math.random() * 100 + 1);
            System.out.println(i);
            try {
                Thread.sleep(1000);//1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

class B extends Thread {
    //通过B控制A
    private A a;
    private Scanner in = new Scanner(System.in);

    public B(A a) {//传入A对象
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("输入Q来退出");
            char ch = in.next().toUpperCase().charAt(0);
            if (ch == 'Q') {
                //通知A线程退出
                a.setFlag(false);
                System.out.println("B退出");
                break;//b也退出
            }
        }
    }
}