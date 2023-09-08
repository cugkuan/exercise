package other;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

public class Main {

    public static void main(String[] args){
        Thread main = Thread.currentThread();

       Executor executor =  Executors.newSingleThreadExecutor();
       executor.execute(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       });
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
