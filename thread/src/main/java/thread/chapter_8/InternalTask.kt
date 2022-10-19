package thread.chapter_8

class InternalTask(val runnableQueue: RunnableQueue) : Runnable {


    @Volatile
    private var running = true

    override fun run() {

        while (running && Thread.currentThread().isInterrupted.not()) {
            try {
                val task = runnableQueue.take()
                task.run()
            } catch (e: InterruptedException) {
                running = false
                break

            }
        }
    }

    fun stop() {
        running = false
    }
}