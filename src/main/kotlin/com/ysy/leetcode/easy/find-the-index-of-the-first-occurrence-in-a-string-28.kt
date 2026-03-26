package com.ysy.leetcode.easy

class Solution28 {

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


class Solution28_2 {

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
