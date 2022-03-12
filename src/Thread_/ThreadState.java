package Thread_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        // 线程七种状态
        // NEW尚未启动的线程
        // RUNNABLE在JVM中执行的线程处于该状态->包括就绪状态和运行状态
        // RUNNABLE状态只是说明线程可以运行，不代表运行中
        // BLOCKED被阻塞等待监视器锁定的线程
        // WAITING正在等待另外一个线程执行特定动作的线程
        // TIMED_WAITING正在等待另外一个线程执行动作达到指定等待时间的线程
        // TERMINATED已经退出的线程
        State state = new State();
        System.out.println(state.getName() + state.getState());
        state.start();
        while (Thread.State.TERMINATED != state.getState()) {
            System.out.println(state.getName() + "状态" + state.getState());
            Thread.sleep(1000);
        }
        System.out.println(state.getName() + "状态" + state.getState());
    }
}

class State extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}