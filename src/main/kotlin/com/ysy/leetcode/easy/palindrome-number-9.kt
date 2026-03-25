package com.ysy.leetcode.easy

class Solution9 {

    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || x % 10 == 0 && x != 0) return false
        var oriX = x
        var revX = 0
        while (oriX > revX) {
            revX = revX * 10 + oriX % 10
            oriX /= 10
        }
        return oriX == revX || oriX == revX / 10
    }
}

class Solution9_2 {

    fun isPalindrome(x: Int): Boolean {
        val xs = x.toString()
        for (i in 0..(xs.length / 2)) {
            if (xs[i] != xs[xs.length - i - 1]) return false
        }
        return true
    }
}
