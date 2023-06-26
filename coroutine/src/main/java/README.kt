import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * 下面的代码输出结果是
 * 1，5,,2，,3，,4
 */
suspend fun test(){
    println("1")
    GlobalScope.launch {
        println(2)
        withContext(Dispatchers.Default) {
            delay(1*1000)
            println(3)
        }
        print(4)
    }
    println(5)
    delay(3000L)
}
fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // 假装我们异步等待了 100 毫秒
        emit(i) // 发射下一个值
    }
}

suspend fun  shareFlow() = runBlocking{
    val shareView = MutableSharedFlow<Int>()

    GlobalScope.launch(Dispatchers.IO) {
        var i = 0
        repeat(100){
            shareView.emit(i++)
            delay(100)
        }
    }
    shareView.collect() {

    }
    1


}


 suspend fun main(){

    simple()
        .conflate() // 合并发射项，不对每个值进行处理
        .collect { value ->
            delay(300) // 假装我们花费 300 毫秒来处理它
            println(value)
        }
}