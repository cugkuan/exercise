package thread.chapter_3




fun main(){
    val lock = Object()
    val t0 = Thread {
        synchronized(lock) {
            try {
                lock.wait()
            } catch (e: InterruptedException) {
                println("线程被打断了")
            }
        }
    }
    val t1 = Thread(Runnable {
        Thread.sleep(2 * 1000)
        t0.interrupt()
    })
    t1.start()
    t0.start()

}