import java.util.Collections
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.stream.IntStream
import kotlin.random.Random

public interface Lock{
    fun lock()
    @Throws(TimeoutException::class)
    fun lock(mills:Long)
    fun unLock()
    fun getBlockedThreads():List<Thread>
}
class BooleanLock :Lock{
    private val lock = Object()
    private var currentThread:Thread? = null
    private var locked = false
    private val blockedList = ArrayList<Thread>()
    private fun currentThread():Thread{
        return Thread.currentThread()
    }
    override fun lock() {
        synchronized(lock){
            while (locked){
                val t = currentThread()
                try {
                    if (blockedList.contains(t).not()){
                        blockedList.add(t)
                    }
                    lock.wait()
                }catch (e:InterruptedException){
                    blockedList.remove(t)
                }
            }
            blockedList.remove(currentThread())
            this.locked = true
            this.currentThread = currentThread()
        }
    }
    override fun lock(mills: Long)  {
        synchronized(lock) {
            if (mills <= 0) {
                lock.wait()
            } else {
                var remainingMills = mills
                val endMills = System.currentTimeMillis() + remainingMills
                while (locked){
                    if (remainingMills <=0){
                        throw  TimeoutException()
                    }
                    if (blockedList.contains(currentThread()).not()){
                        blockedList.add(currentThread())
                    }
                    lock.wait(remainingMills)
                    remainingMills = endMills  - System.currentTimeMillis()
                }
                blockedList.remove(currentThread())
                locked = true
                this.currentThread = currentThread()
            }
        }
    }
    override fun unLock() {
        synchronized(lock){
            if (currentThread == currentThread()){
                locked = false
                lock.notify()
            }
        }
    }
    override fun getBlockedThreads(): List<Thread> {
        return Collections.unmodifiableList(blockedList)
    }
}

class Test {
    private val lock = BooleanLock()

    private val randomInt = Random(10)

    public fun syncMethod(){
        try {
            lock.lock(1000L)
            val value   = randomInt.nextInt(10).toLong()
            println("${Thread.currentThread()} get the lock")
            println("time=> $value")
            TimeUnit.SECONDS.sleep(value)
        }catch (e:InterruptedException ){}
        catch (e:TimeoutException){
            println("超时")
        }
        finally {
            lock.unLock()
        }
    }
}
fun main(){
    val test = Test()

    IntStream.range(0,1)
        .mapToObj(){
            Thread(){
                test.syncMethod()
            }
        }
        .forEach {
            it.start()
        }
}