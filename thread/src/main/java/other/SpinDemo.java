package other;

/**
 * java 自旋转
 */
public class SpinDemo {
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " acquired lock.");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("xxxxxxxxxxxx");
            }
        }, "Thread-1").start();

        new Thread(() -> {
            while (true) {
                System.out.println("--------->");
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock.");
                    break;
                }
            }
        }, "Thread-2").start();
    }
}
