package letcode.backtrack

import letcode.print


/**
 *
 * 回溯算法就是穷举法，用 1，,2，,3 的全排序就很好理解了。
 *
 *  从1，,2，3 中选出 1，那么还能选择的 有 2，,3；选出 2，那么还能选择的就是 3，所以 有 1，,2，,3
 *
 * 下面就是一个非常原始，基础的穷举法，显然，性能不咋样
 */

class SimpleBackTrack {
    fun track(pickList: List<Int>, track: ArrayList<Int>) {
        if (pickList.isEmpty()) {
            track.print()
            return
        } else {
            pickList.forEach {
                track(ArrayList(pickList).apply {
                    remove(it)
                }, ArrayList(track).apply {
                    add(it)
                })
            }
        }
    }
}

/**
 * 回溯算法是对树枝进行遍历;
 * 这个的理解很重要
 * 回溯 就是走回头路的意思，当发现此路不通的时候，就退回来，重新走
 *
 *  下面的代码很简单，但是非常的重要,从已有的路径，推断 可选择的元素
 */
class OptimizeBackTrack {
    private val track = ArrayList<Int>();
    fun backTrack(pick: ArrayList<Int>) {
        if (track.size == pick.size) {
            track.print()
        } else {
            pick.forEach { item ->
                if (!track.contains(item)) {
                    track.add(item)
                    backTrack(pick)
                    track.remove(item)
                }
            }
        }
    }
}

fun main() {
    //SimpleBackTrack().track(arrayListOf(1, 2, 3), ArrayList())

    OptimizeBackTrack().backTrack(arrayListOf(1, 2, 3))
}

