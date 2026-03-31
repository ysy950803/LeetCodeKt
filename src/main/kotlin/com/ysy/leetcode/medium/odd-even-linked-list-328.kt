package com.ysy.leetcode.medium

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution328 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var odd = head
        var even = head.next
        val evenH = even
        while (even?.next != null) {
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }
        odd?.next = evenH
        return head
    }
}
