package com.ysy.leetcode.easy

class Solution14 {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val first = strs[0]
        for (i in first.indices) {
            val chr = first[i]
            for (j in 1..<strs.size) {
                if (i >= strs[j].length || chr != strs[j][i]) {
                    return first.substring(0, i)
                }
            }
        }
        return first
    }
}

class Solution14_2 {

    fun longestCommonPrefix(strs: Array<String>): String {
        var result = ""
        var c: Char?
        var i = 0
        while (true) {
            c = null
            for (s in strs) {
                if (i >= s.length) return result
                if (c == null) {
                    c = s[i]
                } else {
                    if (c != s[i]) return result
                }
            }
            result += c
            i++
        }
    }
}
