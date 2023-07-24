package letcode.tree

/**
 * 二叉树节点
 */
data class TreeNode(
    val data: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)
/**
 * 前序遍历方法
 */
fun preOrderTraversal(node: TreeNode?) {
    node?.let {
        print(it.data)
        print(';')
        preOrderTraversal(node.left)
        preOrderTraversal(node.right)
    }
}

/**
 * 中序遍历
 */
fun middleTraversal(node: TreeNode?) {
    node?.let {
        middleTraversal(node.left)
        print(it.data)
        print(';')
        middleTraversal(node.right)
    }
}

/**
 * 后序遍历
 */
fun afterTraversal(node: TreeNode?) {
    node?.let {
        afterTraversal(node.left)
        afterTraversal(node.right)
        print(it.data)
        print(';')
    }
}

fun createTestNode() = TreeNode(5).apply {
    left = TreeNode(4).apply {
        left = TreeNode(1)
        right = TreeNode(2)
    }
    right = TreeNode(6).apply {
        left = TreeNode(7)
        right = TreeNode(8)
    }
}

fun main() {
    val node = createTestNode()
    preOrderTraversal(node)
    println()
    middleTraversal(node)
    println()
    afterTraversal(node)
}