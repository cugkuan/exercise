package letcode

import java.util.*


fun count(input: IntArray?) {
    Arrays.stream(input).forEach { value: Int -> print("$value,") }
}

fun List<Int>.print(){
    forEach {
        print("$it,")
    }
    print("\n")
}