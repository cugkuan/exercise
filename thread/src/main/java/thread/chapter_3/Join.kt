package thread.chapter_3

import java.util.concurrent.TimeUnit


fun main(args: Array<String>) {
    val t1 = Thread {
        println("查询1")
        TimeUnit.SECONDS.sleep(5)
        println("查询1结束")
    }
    val t2 = Thread {
        println("查询2")
        TimeUnit.SECONDS.sleep(1)
        println("查询2结束")
    }
    val t3 = Thread{
        println("查询3")
        TimeUnit.SECONDS.sleep(2)
        println("查询3结束")
    }

    Thread(){
        t1.start()
        t2.start()
        t3.start()
        t1.join()
        t2.join()
        t3.join()
        println("整理完查询信息")
    }.start()
}

