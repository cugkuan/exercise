package thread.chapter_17;

public interface ReadWriteLock {

    Lock readLock();

    Lock writeLock();


    int getWritingWriters();

    int getWaitingWriters();

    int getReadingReaders();



    static ReadWriteLock readWriterLock(){
        return new ReadWriteLockImp();
    }

    static ReadWriteLock readWriterLock(boolean preferWriter){
        return new ReadWriteLockImp(preferWriter);
    }
}