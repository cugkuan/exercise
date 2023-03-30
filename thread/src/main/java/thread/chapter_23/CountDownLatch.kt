package thread.chapter_23

import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit


abstract class Latch(open var limit:Int) {
    abstract fun await()
    abstract fun countDown()
    abstract fun getUnArrived():Int

    abstract fun await(timeUtils:TimeUnit,time:Long)
}

class CountDownLatch(override var limit: Int) :Latch(limit){
    private val lock = Object()
    override fun await() {
        synchronized(lock){
            while (limit> 0){
                lock.wait()
            }
        }
    }

    override fun await(timeUtils: TimeUnit, time: Long) {
        if (time <= 0){
            await()
        }else{
            var remain = timeUtils.toNanos(time)
            val end = System.nanoTime() + remain
            synchronized(lock){
                while (limit > 0){
                    if (TimeUnit.NANOSECONDS.toMillis(remain) <=0){
                        throw java.lang.RuntimeException("超时了.....")
                    }
                    lock.wait()
                    remain = end - System.nanoTime()
                }
            }
        }
    }

    override fun countDown() {
        synchronized(lock){
            if (limit <= 0){
            }
            limit --
            lock.notifyAll()
        }
    }

    override fun getUnArrived(): Int {
        return limit
    }
}

class ProgramerTravel(val latch: Latch,val programmer:String,val t:String) : Thread() {
    override fun run() {
        super.run()
        println("p--$programmer---$t")
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10).toLong())
        }catch (e:InterruptedException){
            e.printStackTrace()
        }

        println("$programmer----$t ----->end")
        latch.countDown()
    }
}

fun main(){

    val latch = CountDownLatch(4)

    ProgramerTravel(latch,"A","a").start()
    ProgramerTravel(latch,"B","b").start()
    ProgramerTravel(latch,"C","c").start()
    ProgramerTravel(latch,"D","d").start()

    try {
        latch.await(TimeUnit.SECONDS,2)
        println("所有的都到齐了啊......")
    }catch (e:java.lang.Exception){
        e.printStackTrace()
    }


}