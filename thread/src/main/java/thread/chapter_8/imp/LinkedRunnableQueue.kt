package thread.chapter_8.imp

import thread.chapter_8.DenyPolicy
import thread.chapter_8.RunnableQueue
import thread.chapter_8.ThreadPool
import java.util.LinkedList

class LinkedRunnableQueue(val limit:Int,val denyPolicy:DenyPolicy,val threadPool: ThreadPool) :RunnableQueue{

    private val lock = Object()
    private val tasks = LinkedList<Runnable>()
    override fun offer(runnable: Runnable) {
        synchronized(lock){
            if (tasks.size >= limit){
                denyPolicy.reject(runnable,threadPool)
            }else{
                tasks.addLast(runnable)
                lock.notifyAll()
            }
        }
    }

    override fun take(): Runnable {
      synchronized(lock){
          while (tasks.isEmpty()){
              try {
                  lock.wait()
              }catch (e:InterruptedException){

              }
          }
          return tasks.removeFirst()
      }
    }

    override fun size(): Int {
        synchronized(lock){
            return tasks.size
        }
    }
}