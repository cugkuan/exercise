package letcode.tree

import java.util.*
import kotlin.collections.ArrayList

/**
 * 非递归的遍历方法
 * 实际上，用栈去模拟递归
 */
fun preTraversal(node:TreeNode){
    val stack = Stack<TreeNode>()
    var p:TreeNode? = node
    while (p != null || stack.isNotEmpty()){
        if (p != null){
            print(p.data)
            print(',')
            stack.push(p)
            p  = p.left
        }else{
            p = stack.pop()
            p = p.right
        }
    }
}

fun midTraversal(node: TreeNode){
    val stack = Stack<TreeNode>()
    var p:TreeNode?= node
    while (p != null || stack.isNotEmpty()){
        if (p != null){
            stack.push(p)
            p = p.left
        }else{
            p = stack.pop()
            print(p?.data)
            print(',')
            p = p?.right
        }
    }
}

/**
 * 后序遍历,非递归写法
 */
fun frontTraversal(node: TreeNode){
    val stack = Stack<TreeNode>()
    val list = ArrayList<TreeNode>()
    stack.push(node)
    while (stack.isNotEmpty()){
        val p = stack.pop()
        list.add(p)
        if (p.left != null){
            stack.push(p.left)
        }
        if (p.right != null){
            stack.push(p.right)
        }
    }
    list.reverse()
    list.forEach{
        print(it.data)
        print(',')
    }
}

/**
 * 层序遍历
 */
fun levelTraversal(node: TreeNode){
    val queue = LinkedList<TreeNode>()
    queue.addLast(node)
    while (queue.isEmpty().not()){
        var len = queue.size
        while (len >0){
            val p = queue.removeFirst()
            print(p.data)
            print(',')
            p.left?.let {
                queue.addLast(it)
            }
            p.right?.let {
                queue.addLast(it)
            }
            len --
        }
        println()
    }
}

fun main(){
    val node  = createTestNode()
    // 5,4,1,2,6,7,8,
    preTraversal(node)
    println()
    //1;4;2;5;7;6;8;
    midTraversal(node)
    println()
    frontTraversal(node)
    println()
    levelTraversal(node)
}