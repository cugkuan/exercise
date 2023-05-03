package letcode.queue;

import java.util.Stack;

/**
 * 使用二个栈，模拟队列
 */
public class MyQueue {

    private Stack<Integer> in  = new Stack<>();
    private Stack<Integer> out  = new Stack<>();

    public void push(int value){
        in.push(value);
    }

    private void dumpStackIn(){
        while (!in.isEmpty()){
            out.push(in.pop());
        }
    }

    /**
     * 从队列首部移除元素
     * @return
     */
    public int pop(){
        if (out.isEmpty()){
            dumpStackIn();
        }
        return out.pop();
    }

    /**
     * 返回队列首部元素
     * @return
     */
    public int peek(){
        if (out.isEmpty()){
            dumpStackIn();
        }
        return out.peek();
    }

    public Boolean isEmpty(){
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.isEmpty());
    }
}
