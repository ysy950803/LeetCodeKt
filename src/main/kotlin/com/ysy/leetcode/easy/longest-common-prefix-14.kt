package com.ysy.leetcode.easy

class Solution14 {

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
