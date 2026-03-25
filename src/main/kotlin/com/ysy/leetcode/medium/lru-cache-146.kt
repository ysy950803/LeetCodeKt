package com.ysy.leetcode.medium

class LRUCache(private val capacity: Int) {

    class Node(var key: Int = 0, var value: Int = 0) {
        var pre: Node? = null
        var next: Node? = null
    }

    private val map = HashMap<Int, Node>()
    private val head = Node()
    private val tail = Node()

    init {
        head.next = tail
        tail.pre = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            node.value = value
            moveToHead(node)
        } else {
            val node = Node(key, value)
            map[key] = node
            addToHead(node)

            if (map.size > capacity) {
                removeTail()?.also { map.remove(it.key) }
            }
        }
    }

    private fun addToHead(node: Node) {
        node.pre = head
        node.next = head.next
        head.next?.pre = node
        head.next = node
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }

    private fun removeNode(node: Node) {
        node.pre?.next = node.next
        node.next?.pre = node.pre
        node.pre = null
        node.next = null
    }

    private fun removeTail(): Node? = tail.pre?.also { removeNode(it) }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */