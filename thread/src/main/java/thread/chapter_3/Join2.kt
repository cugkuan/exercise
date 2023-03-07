package thread.chapter_3

import java.util.concurrent.TimeUnit


fun main(){
    val threadA = Thread{
        try {
            TimeUnit.SECONDS.sleep(2)
            println("线程A.......")

        }catch (e:InterruptedException){}
    }
    val threadB = Thread{
        try {
            println("线程B运行........")
            threadA.join()
            println("线程B")
        }catch (e:InterruptedException){}
    }
    threadA.start()
    threadB.start()
    TimeUnit.SECONDS.sleep(5)
}