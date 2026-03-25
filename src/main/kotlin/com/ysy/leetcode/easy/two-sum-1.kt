package com.ysy.leetcode.easy

class Solution1 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for ((i, num) in nums.withIndex()) {
            val j = map[target - num]
            if (j != null) {
                return intArrayOf(i, j)
            }
            map[num] = i
        }
        return intArrayOf()
    }
}

class Solution1_2 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        for ((i, ni) in nums.withIndex()) {
            for ((j, nj) in nums.withIndex()) {
                if (i == j) continue;
                if (ni + nj == target) return intArrayOf(i, j)
            }
        }
        return intArrayOf()
    }
}
