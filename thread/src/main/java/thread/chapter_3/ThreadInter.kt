package thread.chapter_3

import java.util.concurrent.TimeUnit


fun main(){
    val thread = Thread{
        while (true){
            println(Thread.interrupted())
        }
    }
    thread.isDaemon = true
    thread.start()

    TimeUnit.MICROSECONDS.sleep(2)
    thread.interrupt()
}
