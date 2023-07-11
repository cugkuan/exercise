import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

suspend  fun main() = runBlocking {

    flowOf(1,2,3)
        .scan(0) { old, change ->
            old + change
        }.onEach {
            println(it)
        }
        .launchIn(this)

    flowOf(1,2,3)
        .reduce { a, b ->
            a + b
        }


    Unit

}