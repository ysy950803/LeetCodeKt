package com.ysy.leetcode.hard

class Solution42 {

    fun trap(height: IntArray): Int {
        var lIdx = 0
        var rIdx = height.size - 1
        var lMaxH = 0
        var rMaxH = 0
        var result = 0
        while (lIdx < rIdx) {
            if (height[lIdx] < height[rIdx]) {
                if (height[lIdx] < lMaxH) {
                    result += lMaxH - height[lIdx]
                } else {
                    lMaxH = height[lIdx]
                }
                ++lIdx
            } else {
                 if (height[rIdx] < rMaxH) {
                     result += rMaxH - height[rIdx]
                 } else {
                     rMaxH = height[rIdx]
                 }
                --rIdx
            }
        }
        return result
    }
}
