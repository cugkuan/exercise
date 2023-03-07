package thread.chapter_3

import java.util.concurrent.TimeUnit

/**
 * 此例子，说明 isInterrupted 会复位；
 * sleep 捕获中断信号，于是将 isInterrupted 进行复位；
 * 输出的结果都是 false
 */
fun main() {

    val thread = object : Thread() {
        override fun run() {
            while (true) {
                try {
                    TimeUnit.MINUTES.sleep(1)
                } catch (e: InterruptedException) {
                    println("我被中断了？${isInterrupted}")
                }
            }
        }
    }
    thread.isDaemon = true
    thread.start()
    println("thread is interrupt ${thread.isInterrupted}")
    TimeUnit.MICROSECONDS.sleep(2)
    thread.interrupt()
    TimeUnit.MICROSECONDS.sleep(2)
    println("thread is interrupt ${thread.isInterrupted}")
}
