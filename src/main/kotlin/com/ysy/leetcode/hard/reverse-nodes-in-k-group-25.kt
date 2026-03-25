package com.ysy.leetcode.hard

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution25 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k < 1) return head
        val vNode = ListNode(0)
        vNode.next = head
        var pre : ListNode? = vNode
        var end : ListNode? = vNode

        while (end?.next != null) {
            repeat(k) {
                end = end?.next ?: return vNode.next
            }
            val nextGrp = end?.next
            end?.next = null

            val start = pre?.next
            pre?.next = reverseList(start)
            start?.next = nextGrp

            pre = start
            end = pre
        }
        return vNode.next
    }

    private fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur: ListNode? = head
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        return pre
    }
}