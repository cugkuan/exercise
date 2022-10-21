package thread.handler;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MessageQueue {

    private Object lock = new Object();
    public final Queue<Message> messages = new LinkedList<>();
    public void add(Message message){
        messages.add(message);

        try {
            lock.notifyAll();
        }catch (IllegalMonitorStateException e){

        }
    }
    public Message offer(){
        Message message = messages.poll();
        while (message == null){
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                }
            }
            message = messages.poll();
        }
        return message;
    }


}