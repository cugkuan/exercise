package thread.chapter_17.use;


import thread.chapter_17.Lock;
import thread.chapter_17.ReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShareData {

    private final List<Character> container = new ArrayList<>();
    private final ReadWriteLock readWriteLock = ReadWriteLock.readWriterLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writerLock = readWriteLock.writeLock();
    private final int length;

    public ShareData(int length){
        this.length = length;
        for (int i = 0;i < length;i++){
            container.add('c');
        }
    }

    private void slowly(){
        try {

            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public char[] read() throws InterruptedException{

        try {
            readLock.lock();
            char[] newBuffer = new char[length];
            for (int i = 0;i < length;i++) {
                newBuffer[i] = container.get(i);
            }
            slowly();
            return newBuffer;
        }finally {
            readLock.unlock();
        }
    }

    public void write(char c) throws InterruptedException{

        try {
            writerLock.lock();
            for (int i = 0;i < length;i++){
                this.container.add(i,c);
            }
            slowly();
        }finally {
            writerLock.unlock();
        }
    }






}