package thread.chapter_8

import thread.chapter_8.imp.BasicThreadPool
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit



fun main(){

    val threadPool = BasicThreadPool(2,4,3,1000)

    repeat(3){
        threadPool.execute(){
            try {
                TimeUnit.SECONDS.sleep(1)
                println("$it -- ${Thread.currentThread().name}")
            }catch (e:InterruptedException){
                e.printStackTrace()
            }
            threadPool.shutdown()
        }
    }

    Thread.currentThread().isDaemon = true

    println("任务结束")
}