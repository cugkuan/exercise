package thread.chapter_8

interface ThreadPool {

    fun execute(runnable: Runnable)

    fun shutdown()

    fun getInitSize():Int

    fun getMaxSize():Int

    fun getCoreSize():Int

    fun getQueueSize():Int

    fun getActiveCount():Int

    fun isShutDown():Boolean

}

interface RunnableQueue{

    fun offer(runnable:Runnable)
    fun take():Runnable

    fun size():Int
}

interface ThreadFactory{

    fun createThread(runnable: Runnable):Thread
}



interface DenyPolicy{

    fun reject(runnable: Runnable,threadPool:ThreadPool)
}