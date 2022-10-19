package thread.chapter_12

import java.sql.Time
import java.util.concurrent.TimeUnit


val max = 5

/**
 * 对 init_value 添加 @Volatile 可以深刻的了解这个关键词的用处
 */
@Volatile var init_value = 0

fun main() {
    Thread({
        var localValue = init_value
        while (localValue < max) {
            if (init_value != localValue) {
                println("The init_value is updateed to $init_value")
            }
            localValue = init_value
        }
    }, "Reader").start()

    Thread({
        var localValue = init_value
        while (localValue < max) {
            println("The init_value will be changed to ${++localValue}")
            init_value = localValue
            try {
                TimeUnit.SECONDS.sleep(2)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }, "Updater").start()

}