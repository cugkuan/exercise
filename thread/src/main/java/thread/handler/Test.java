package thread.handler;

public class Test {

    public static void main(String[] args) {
        Looper.prepare();
        Handler handler = new Handler() {
            @Override
            public void dispatchMessage(Message message) {
                super.dispatchMessage(message);
                System.out.println(Thread.currentThread().getName() + message.description);
            }
        };
        handler.sendMsg(new Message("1"));
        handler.sendMsg(new Message("2"));
        new Thread(() -> {

            handler.sendMsg(new Message("a"));
            handler.sendMsg(new Message("b"));

        }).start();
        Looper.looper();

    }

}