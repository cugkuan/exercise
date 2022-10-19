package thread.chapter_8.imp

import thread.chapter_8.InternalTask
import thread.chapter_8.ThreadPool
import java.util.concurrent.TimeUnit


class BasicThreadPool(
    private val initSize: Int, private val maxSize: Int, private val coreSize: Int,
    private val queueSize: Int
) : Thread(), ThreadPool {
    private val runnableQueue = LinkedRunnableQueue(queueSize, AbortDenyPolicy(), this)
    private val threadFactory = DefaultThreadFactory()
    @Volatile
    private var activeCount = 0

    /**
     * 5秒进行一次线程维护
     */
    private val keepAliveTime = 5*1000L

    @Volatile private var isShutDown = false



    private val  threadQueue  = ArrayDeque<Pair<Thread,InternalTask>>()


    init {
        start()
        repeat(initSize) {
            newThread()
        }
    }


    override fun run() {
        super.run()
        while (isShutDown().not() && isInterrupted.not()) {
            try {
                TimeUnit.SECONDS.sleep(keepAliveTime)
            }catch (e:InterruptedException){
                isShutDown = true
                break
            }
            run breaking@{
                synchronized(this@BasicThreadPool){
                    if (isShutDown){
                        return@breaking
                    }
                    if (runnableQueue.size() > 0 && activeCount < coreSize){

                        for (i in coreSize until initSize){
                            newThread()
                        }
                        return@breaking
                    }
                    if (runnableQueue.size() > 0 && activeCount < maxSize){

                        for (i in coreSize until  coreSize){
                            newThread()
                        }
                    }
                    if (runnableQueue.size() == 0 && activeCount > coreSize){
                        for (i in coreSize until  activeCount){
                            removeThread()
                        }
                    }
                }
            }


        }

    }

    private fun newThread() {

        val innerTask = InternalTask(runnableQueue)
        val thread = threadFactory.createThread(innerTask)
        activeCount++
        threadQueue.add(thread to innerTask)
        thread.start()
    }
    private fun removeThread(){

        threadQueue.removeLastOrNull()?.let {
            it.second.stop()
            activeCount--
        }
    }

    override fun execute(runnable: Runnable) {
        if (isShutDown()) {
            throw java.lang.RuntimeException("线程池已经关闭")
        }
        runnableQueue.offer(runnable)

    }

    override fun shutdown() {
        synchronized(this){
            if (isShutDown){

            }else{
                isShutDown = true
                threadQueue.forEach {
                    it.second.stop()
                    it.first.interrupt()
                }
                interrupt()
                println("关闭线程")
            }
        }
    }

    override fun getInitSize() = initSize

    override fun getMaxSize() = maxSize

    override fun getCoreSize() = coreSize

    override fun getQueueSize() = queueSize
    override fun getActiveCount(): Int {

        return activeCount
    }

    override fun isShutDown() = isShutDown

    override fun toString(): String {
        return "activeCount:${getActiveCount()} -- getQueueSize:${getQueueSize()} -- getCoreSize:${getCoreSize()} --getMaxSize:${getMaxSize()}"
    }
}