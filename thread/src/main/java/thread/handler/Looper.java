package thread.handler;


public class Looper {



    private static Looper looper;

    public final MessageQueue messageQueue;

    private Looper(){
        messageQueue = new MessageQueue();
    }

    private void start(){
        while (true){
            Message msg = messageQueue.offer();
            msg.handler.dispatchMessage(msg);
        }

    }

    public static Looper getMainLooper(){
        return looper;
    }

    public static void prepare(){
        looper = new Looper();
    }

    public static void looper(){
        looper.start();
    }
}