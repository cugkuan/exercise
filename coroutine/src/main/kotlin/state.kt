import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import java.util.concurrent.CancellationException

suspend  fun  main() = runBlocking{
    val intent = Channel<Int>()

    val stateFlow = MutableStateFlow(0)
    launch {
        stateFlow.collect {
            println("消费--->$it")
        }
    }
    val job = intent.consumeAsFlow()
        .onEach {
            println("发送==>$it")
        }
        .flatMapConcat {
            sendValue(it)
        }
        .onEach {

        }
        .launchIn(this)

//    launch {
//        intent.consumeAsFlow().collect {
//            println("发送==>$it")
//            sendValue(it)
//                .onEach {
//                    stateFlow.emit(it)
//                }
//                .launchIn(this)
//        }
//    }
    intent.send(1)
    delay(100)
    intent.cancel()
    intent.send(4)
    println("---->")
}

private fun sendValue(v:Int) = flowOf(v).flowOn(Dispatchers.Default)
    .onEach {
       delay(3000)
    }
    .flowOn(Dispatchers.IO)
