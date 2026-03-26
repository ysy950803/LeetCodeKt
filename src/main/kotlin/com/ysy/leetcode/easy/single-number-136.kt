package com.ysy.leetcode.easy

class Solution136 {

    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (n in nums) {
            result = result xor n
        }
        return result
    }
}

class Solution136_2 {

    fun singleNumber(nums: IntArray): Int {
        if (nums.size <= 1) return nums[0]
        for (i in nums.indices) {
            var same = false
            for (j in nums.indices) {
                if (i != j && nums[i] xor nums[j] == 0) {
                    same = true
                    break
                }
            }
            if (!same) return nums[i]
        }
        return 0
    }
}
