package thread.chapter_17

class ReadWriteLockImp(private var _preferWriter:Boolean = true) :ReadWriteLock{


    val MUTEX = Object()

    private var _writingWriters = 0
    private var _waitingWriters = 0
    private var _readingReaders = 0

    fun getPreferWriter():Boolean{
        return _preferWriter
    }

    fun changePrefer(preferWriter: Boolean){
        this._preferWriter = preferWriter
    }


    override fun readLock(): Lock {

        return ReadLock(this)
    }

    override fun writeLock(): Lock {
        return WriteLock(this)
    }

    override fun getWritingWriters(): Int {
        return _writingWriters
    }

    override fun getWaitingWriters(): Int {

        return _waitingWriters
    }

    override fun getReadingReaders(): Int {

        return _readingReaders
    }

    fun incrementWritingWriters(){
        this._writingWriters++
    }

    fun decrementWritingWriters(){
        this._writingWriters--
    }

    fun incrementWaitingWriters(){
        this._waitingWriters++
    }

    fun decrementWaitingWriters(){
        this._waitingWriters--
    }

    fun incrementReadingReaders(){
        this._readingReaders++
    }
    fun decrementReadingReaders(){
        this._readingReaders--
    }


}