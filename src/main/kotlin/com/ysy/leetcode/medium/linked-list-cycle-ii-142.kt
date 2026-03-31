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

class Solution142 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun detectCycle(head: ListNode?): ListNode? {
        val set = HashSet<ListNode>()
        var cur = head
        while (cur != null) {
            if (set.contains(cur)) return cur
            set += cur
            cur = cur.next
        }
        return null
    }
}

class Solution142_2 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun detectCycle(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                var p1 = head
                var p2 = fast
                while (p1 != p2) {
                    p1 = p1?.next
                    p2 = p2?.next
                }
                return p1
            }
        }
        return null
    }
}
