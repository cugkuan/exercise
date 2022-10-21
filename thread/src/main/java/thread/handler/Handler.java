package thread.handler;

public class Handler {


    private Looper looper;
    public Handler(){
        looper = Looper.getMainLooper();
    }


    public void dispatchMessage(Message message){

    }

    final public void sendMsg(Message message){
        message.handler = this;
        looper.getMainLooper().messageQueue.add(message);
    }
}