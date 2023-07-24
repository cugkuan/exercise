package tree

import java.util.Stack

data class Node(
    val value: Int,
    var left: Node? = null,
    var right: Node? = null
)
fun createTree() = Node(value = 5).apply {
    left = Node(4).apply {
        left = Node(1)
        right = Node(2)
    }
    right = Node(6).apply {
        left = Node(7)
        right = Node(8)
    }
}

fun preTraversal(node: Node) {
    val outPut = StringBuilder()
    val stack = Stack<Node>()
    stack.push(node)
    while (stack.isNotEmpty()) {
        val data = stack.pop()
        outPut.append(data.value).append(";")
        data.right?.let {
            stack.push(it)
        }
        data.left?.let {
            stack.push(it)
        }
    }
    println(outPut.toString())
}

fun middleTraversal(node: Node){
    val outPut = StringBuilder()
    val stack = Stack<Node>()
    var data:Node? = node
    while (data != null || stack.isNotEmpty()){
        if (data != null){
            stack.push(data)
            data  = data.left
        }else{
            data = stack.pop()
            outPut.append(data.value).append(";")
            data = data.right
        }
    }
    println(outPut)
}

fun fontTraversal(node: Node){

}

fun main(){
    preTraversal(createTree())
    middleTraversal(createTree())
}

