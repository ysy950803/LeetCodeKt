package com.ysy.leetcode.easy

class Solution283 {

    fun moveZeroes(nums: IntArray): Unit {
        if (nums.size < 2) return
        var i = 0
        var j = 1
        while (j < nums.size) {
            if (nums[i] == 0 && nums[j] == 0) {
                ++j
            } else if (nums[i] != 0 && nums[j] == 0) {
                ++i
            } else if (nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j]
                nums[j] = 0
                ++i
            } else if (nums[i] != 0 && nums[j] != 0) {
                ++i
                ++j
            }
        }
    }
}

class Solution283_2 {

    fun moveZeroes(nums: IntArray) {
        var insert = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                if (i != insert) {
                    nums[insert] = nums[i]
                    nums[i] = 0
                }
                insert++
            }
        }
    }
}
