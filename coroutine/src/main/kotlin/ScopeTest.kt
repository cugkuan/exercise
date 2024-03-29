import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.system.measureTimeMillis


suspend fun massiveRun(action:suspend () ->Unit){
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n){
                launch {
                    repeat(k){
                        action()
                    }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}

var counter = 0
val  mutex  = Mutex()
suspend fun main()  = runBlocking{
    withContext(Dispatchers.Default){
        massiveRun {
            mutex.withLock {
                counter ++
            }
        }
    }
    println("Counter = $counter")
}
