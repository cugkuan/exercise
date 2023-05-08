package letcode.tree

import kotlin.math.min


/**
 * 二叉树的最小深度
 */


fun getMinDepth(node:TreeNode?):Int{
    if (node == null) return 0
    val leftDepth = getMinDepth(node.left)
    val rightDepth = getMinDepth(node.right)
    if (node.left != null && node.right != null){
        return min(leftDepth,rightDepth) +1
    }
    if (node.left != null){
        return leftDepth +1
    }
    return rightDepth +1
}



fun main(){
    val node = TreeNode(1).apply {
        right = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(3).apply {
                left = TreeNode(6)
                right = TreeNode(5);
            }

        }
    }
    print(getMinDepth(node))
}