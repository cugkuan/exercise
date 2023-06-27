import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf

/**
 * withContext 是结构化的代码，非并发
 */
suspend fun main(){
    val job = GlobalScope.launch {
        println("协程开始")
        val a =  withContext(Dispatchers.IO){
            println("a:开始=>"+Thread.currentThread().name)
            delay(1000)
            println(3)
            println("a:结束")
            "a"
        }
        val  b = withContext (Dispatchers.IO){
            println("b:开始=>"+Thread.currentThread().name)
            delay(1000)
            println("b:结束")
            "b"
        }
        println(a + b )
    }
    println("--------")
    job.join()
}