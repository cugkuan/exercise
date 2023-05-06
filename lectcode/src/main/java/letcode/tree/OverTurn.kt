package letcode.tree

import java.util.*


fun overTurn(node:TreeNode?){
    node?.let { node ->
        val left = node.left
        val right = node.right
        node.left = right
        node.right = left
        overTurn(left)
        overTurn(right)
    }
}

fun overTurn2(node: TreeNode){
    val stack = Stack<TreeNode>()
    stack.push(node)
    while (stack.isNotEmpty()){
        val n = stack.pop()
        val left = n.left
        val right = n.right
        n.right = left
        n.left = right
        left?.let {
            stack.push(it)
        }
        right?.let {
            stack.push(it)
        }
    }
}


fun main(){

    val node = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(7).apply {
            left = TreeNode(6)
            right = TreeNode(9)
        }
    }
    levelTraversal(node)
//    overTurn(node)
//    levelTraversal(node)
//
    overTurn2(node)
    levelTraversal(node)

}