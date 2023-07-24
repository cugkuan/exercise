package letcode.backtrack
import java.util.function.Consumer

/**
 * 从 1-n 中选出k个数的排列组合
 */
class NK {
    private fun print(selected: List<Int>) {
        val builder = StringBuilder()
        builder.append('[')
        selected.forEach(Consumer { integer: Int? -> builder.append(integer).append(",") })
        builder.deleteCharAt(builder.length - 1)
        builder.append(']')
        println(builder)
    }
    fun nk(n: Int, k: Int) {
        backTrack(n, k, 1, ArrayList(k))
    }
    private fun backTrack(n: Int, k: Int, i: Int, selected: MutableList<Int>) {
        if (selected.size == k) {
            print(selected)
        } else {
            for (index in i..n) {
                if (!selected.contains(index)) {
                    selected.add(index)
                    backTrack(n, k, index, selected)
                    selected.remove(index)
                }
            }
        }
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            NK().nk(4, 2)
        }
    }
}
