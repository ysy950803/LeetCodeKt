package com.ysy.simple

import com.ysy.TreeNode

/**
 * Example:
 * var ti = com.ysy.TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class com.ysy.TreeNode(var `val`: Int) {
 *     var left: com.ysy.TreeNode? = null
 *     var right: com.ysy.TreeNode? = null
 * }
 */
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
