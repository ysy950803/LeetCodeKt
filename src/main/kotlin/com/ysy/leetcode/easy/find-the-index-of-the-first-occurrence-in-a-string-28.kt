package com.ysy.leetcode.easy

class Solution28 {

    // Knuth-Morris-Pratt
    fun strStr(haystack: String, needle: String): Int {
        val n = haystack.length
        val m = needle.length
        if (m == 0) return 0
        if (n < m) return -1

        // 1. 构建模式串 needle 的 next 数组 (LPS)
        val next = IntArray(m)
        var j = 0 // j 表示前缀的长度，也表示当前要比较的字符的索引
        for (i in 1 until m) {
            // 当字符不匹配时，不断回溯 j 直到找到匹配的前缀或 j 变为 0
            while (j > 0 && needle[i] != needle[j]) {
                j = next[j - 1]
            }
            // 字符匹配，前缀长度加 1
            if (needle[i] == needle[j]) {
                j++
            }
            next[i] = j
        }

        // 2. 在 haystack 中进行匹配
        j = 0 // 此时 j 表示 needle 中已经匹配的字符数量
        for (i in 0 until n) {
            // 发生失配时，利用 next 数组回溯 needle 的指针 j
            while (j > 0 && haystack[i] != needle[j]) {
                j = next[j - 1]
            }
            // 字符匹配，模式串指针向前推进
            if (haystack[i] == needle[j]) {
                j++
            }
            // 当匹配长度等于模式串长度时，返回起始下标
            if (j == m) {
                return i - m + 1
            }
        }

        return -1
    }

    // Sunday
    fun strStr2(haystack: String, needle: String): Int {
        val n = haystack.length
        val m = needle.length
        if (m == 0) return 0
        if (n < m) return -1

        // 1. 预处理：记录 needle 中每个字符最后出现的位置
        // 用一个数组充当哈希表，默认值为 -1 表示字符不存在于 needle 中
        val shift = IntArray(256) { -1 }
        for (i in 0 until m) {
            shift[needle[i].code] = i
        }

        var i = 0 // 主串指针，代表当前对比窗口的起始位置
        while (i + m <= n) {
            // 2. 在当前窗口尝试挨个字符匹配
            var match = true
            for (j in 0 until m) {
                if (haystack[i + j] != needle[j]) {
                    match = false
                    break
                }
            }

            // 完全匹配，直接返回
            if (match) return i

            // 3. 发生失配，计算下一步跳跃的距离
            if (i + m >= n) return -1 // 窗口已经到底，无法继续跳跃

            // 找到紧跟在当前窗口后面的那一个字符
            val nextChar = haystack[i + m]

            // 核心跳跃逻辑：
            // 公式: 模式串长度 - 该字符在模式串中最右侧出现的位置
            // 如果字符不存在，shift 值为 -1，相当于 i += m + 1 (整体跳过)
            i += m - shift[nextChar.code]
        }

        return -1
    }
}

class Solution28_2 {

    fun strStr(haystack: String, needle: String): Int {
        if (haystack.isEmpty() || needle.isEmpty() || haystack.length < needle.length) return -1
        val fstC = needle[0]
        for (i in haystack.indices) {
            if (haystack[i] == fstC) {
                var j = 0
                for (nC in needle) {
                    if (i + j < haystack.length && nC == haystack[i + j]) ++j
                }
                if (j == needle.length) return i
            }
        }
        return -1
    }
}

class Solution28_3 {

    fun strStr(haystack: String, needle: String): Int {
        if (haystack.isEmpty() || needle.isEmpty() || haystack.length < needle.length) return -1
        val fstC = needle[0]
        for (i in haystack.indices) {
            val hC = haystack[i]
            if (hC == fstC && i + needle.length <= haystack.length
                && haystack.substring(i, i + needle.length) == needle
            ) {
                return i
            }
        }
        return -1
    }
}
