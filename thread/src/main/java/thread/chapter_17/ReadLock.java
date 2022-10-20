package thread.chapter_17;



class ReadLock implements Lock{


    private final ReadWriteLockImp  readWriteLock;

    ReadLock(ReadWriteLockImp readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {

        synchronized (readWriteLock.getMUTEX()) {
            while ((readWriteLock.getWritingWriters() > 0 || readWriteLock.getPreferWriter()) && readWriteLock.getWaitingWriters() > 0) {
                readWriteLock.getMUTEX().wait();
            }
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX()) {
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMUTEX().notifyAll();
        }

    }
}