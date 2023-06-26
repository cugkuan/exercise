import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import java.util.concurrent.CancellationException

suspend  fun  main() = runBlocking{
    val channel = Channel<Int>(capacity = Channel.CONFLATED )
    channel.consumeAsFlow()
        .flatMapConcat {
            println("---->$it")
            send(it)
        }
        .flowOn(Dispatchers.IO)
        .catch {
            println(it.localizedMessage)
        }
        .stateIn(this, SharingStarted.Eagerly,0)

    channel.send(1)
    delay(500)
    launch {
        channel.trySend(2)
    }
    delay(500)
    launch {
        channel.trySend(4)
    }
    channel.send(3)
}

private fun send(v:Int) = flowOf(v).flowOn(Dispatchers.Default)
    .onEach {
        delay(3000)
    }
    .flowOn(Dispatchers.IO)
    .onEach {
        println(it)
    }
