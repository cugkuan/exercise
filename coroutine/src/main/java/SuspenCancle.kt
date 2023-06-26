import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


fun main(){

    runBlocking {
        print(t())
    }
}

private suspend fun t() = suspendCoroutine<Int> {
    it.resume(1)
    it.resume(2)
}


private suspend fun task():Int = suspendCancellableCoroutine  { continuation ->
    if (continuation.isActive) {
        continuation.resume(1)
    }
    if (continuation.isActive) {
        continuation.resume(1)
    }

}
