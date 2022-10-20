package thread.chapter_17

class WriteLock(private val readWriteLock: ReadWriteLockImp) : Lock {
    override fun lock() {
        synchronized(readWriteLock.MUTEX) {
            try {
                readWriteLock.incrementWaitingWriters()
                while (readWriteLock.readingReaders > 0 || readWriteLock.writingWriters > 0) {
                    readWriteLock.MUTEX.wait()
                }
                readWriteLock.incrementWritingWriters()
            } finally {
                readWriteLock.decrementWaitingWriters()
            }
            readWriteLock.decrementWritingWriters()
        }
    }

    override fun unlock() {
        synchronized(readWriteLock.MUTEX) {
            readWriteLock.decrementWritingWriters()
            readWriteLock.changePrefer(false)
            readWriteLock.MUTEX.notifyAll()
        }
    }
}