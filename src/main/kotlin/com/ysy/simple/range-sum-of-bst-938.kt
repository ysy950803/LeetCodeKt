package com.ysy.simple

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution938 {

    private var low = 0
    private var high = 0
    private var sum = 0

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        this.low = low
        this.high = high
        traverse(root)
        return sum
    }

    private fun traverse(node: TreeNode?) {
        node ?: return
        if (node.`val` > low) traverse(node.left)
        if (node.`val` in low..high) sum += node.`val`
        if (node.`val` < high) traverse(node.right)
    }
}
