package com.ysy

/**
 * Definition for a binary tree node.
 * class com.ysy.TreeNode(var `val`: Int = 0) {
 *     var left: com.ysy.TreeNode? = null
 *     var right: com.ysy.TreeNode? = null
 * }
 */

class Solution236 {

    private val currentPath = ArrayDeque<TreeNode>()

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        findPath(root, p)
        val pathP = currentPath.toList()
        currentPath.clear()
        findPath(root, q)
        val pathQ = currentPath.toList()
        var ancestor: TreeNode? = null
        for (i in 0 until minOf(pathP.size, pathQ.size)) {
            if (pathP[i].isSame(pathQ[i])) {
                ancestor = pathP[i]
            } else {
                break
            }
        }
        return ancestor
    }

    private fun findPath(node: TreeNode?, target: TreeNode?): Boolean {
        node ?: return false
        currentPath.addLast(node)
        if (node.isSame(target)) return true
        if (findPath(node.left, target) || findPath(node.right, target)) return true
        currentPath.removeLast()
        return false
    }

    private fun TreeNode.isSame(node: TreeNode?) = `val` == node?.`val`
}

class Solution236_2 {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root.isSame(p) || root.isSame(q)) return root
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        if (left != null && right != null) return root
        return left ?: right
    }

    private fun TreeNode.isSame(node: TreeNode?) = `val` == node?.`val`
}
