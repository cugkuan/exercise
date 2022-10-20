package thread.chapter_17.use


fun main() {
    val text = "abcdefghijklmnopqrstuvwxyz"
    val shareData = ShareData(50)
    repeat(2) {
        Thread {
            try {
                text.forEach { c ->
                    shareData.write(c)
                    println("${Thread.currentThread()} write $c")
                }
            } catch (e: InterruptedException) {

                e.printStackTrace()
            }
        }.start()
    }

    repeat(10) {
        Thread {
            while (true) {
                try {
                    println("${Thread.currentThread()} + read ${String(shareData.read())}")
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
            .start()
    }

}