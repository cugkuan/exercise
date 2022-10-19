package thread.chapter_8.imp

import thread.chapter_8.ThreadFactory

class DefaultThreadFactory : ThreadFactory{
    override fun createThread(runnable: Runnable): Thread {

        return Thread(runnable)
    }
}