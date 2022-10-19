package thread.chapter_8.imp

import thread.chapter_8.DenyPolicy
import thread.chapter_8.ThreadPool


class DiscardDenyPolicy :DenyPolicy{
    override fun reject(runnable: Runnable, threadPool: ThreadPool) {
      // 什么都不干
    }
}

class AbortDenyPolicy :DenyPolicy{
    override fun reject(runnable: Runnable, threadPool: ThreadPool) {
       throw java.lang.RuntimeException("线程池已经满了，拒绝该任务")
    }
}

/**
 * 线程在提交者所在的线程中直接运行
 */
class RunnerDenyPolicy :DenyPolicy{
    override fun reject(runnable: Runnable, threadPool: ThreadPool) {
        if (threadPool.isShutDown().not()){
            runnable.run()
        }
    }
}