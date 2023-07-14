package chanel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * channel 的示例代码
 */
suspend fun main(){
    val chanel = Channel<Int>()
     val job = GlobalScope.launch abc@{
        val product = this.launch {
            var i = 0;
            while ( i < 10){
                chanel.send(i++)
                delay(1000)
            }
            this@abc.cancel(null)
        }
       launch {
            chanel.consumeEach {
                println(it)
            }
        }
        product.join()
    }

    job?.join()
    println("xxxxxxxxx")
}