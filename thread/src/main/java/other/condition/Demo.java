package other.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/**
 * 多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 * <p>
 * AA打印5次，BB打印10次，CC打印15次
 * 重复10轮
 * <p>
 * <p>
 * 1.高聚低合前提下，线程操作资源类
 * 2.判断/干活/通知
 * 3.多线程交互中，必须要防止多线程的虚假唤醒，也即(判断只能用while，不能用if)
 * 4.注意标志位
 */
public class Demo {
    public static class  ShareResources {
        enum Type {
            A,B,C
        }
        private Type type = Type.A;

        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        private Condition conditionC = lock.newCondition();

        public void printA() {
            lock.lock();
            try {
                //1 判断
                while (type != Type.A) {
                    conditionA.await();
                }
                //2 干活
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                //3 通知
                type = Type.B;
                conditionB.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void printB() {
            lock.lock();
            try {
                //1 判断
                while (type != Type.B) {
                    conditionB.await();
                }
                //2 干活
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                //3 通知
                type = Type.C;
                conditionC.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void printC() {
            lock.lock();
            try {
                //1 判断
                while (type != Type.C) {
                    conditionC.await();
                }
                //2 干活
                for (int i = 1; i <= 15; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                //3 通知
                type = Type.A;
                conditionA.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
    public static void main(String[] args) {
        ShareResources resources = new ShareResources();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resources.printA();
            }
        }, "Thread-A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resources.printB();
            }
        }, "Thread-B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resources.printC();
            }
        }, "Thread-C").start();
    }
}
