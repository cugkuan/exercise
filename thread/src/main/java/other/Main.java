package other;

import java.util.concurrent.locks.LockSupport;

public class Main {

    public static void main(String[] args){
        Thread main = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("x");
                LockSupport.unpark(main);
            }
        });
        thread.start();
        LockSupport.park(thread);
        System.out.println("xxxxxx");
    }
}
