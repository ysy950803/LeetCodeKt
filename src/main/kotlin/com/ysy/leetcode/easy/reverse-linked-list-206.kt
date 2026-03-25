package com.ysy.leetcode.easy

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution206 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        head ?: return null
        var pre: ListNode? = null
        var cur: ListNode? = head
        var next: ListNode?
        while (cur != null) {
            next = cur.next
            cur.next = pre
            // move forward
            pre = cur
            cur = next
        }
        return pre
    }
}

class Solution206_2 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        val newHead = reverseListI(head)
        head?.next = null
        return newHead
    }

    private fun reverseListI(head: ListNode?): ListNode? {
        val tail = head?.next ?: return head
        val newHead = reverseListI(tail)
        tail.next = head
        return newHead
    }
}
