package com.leetcode.graphsample.problems

fun longestSubarraySum(nums: IntArray, k: Int): Int {
    if (nums.isEmpty()) return 0
    var start = 0
    var maxCount = -1
    var totalSum = 0

    for (i in nums.indices) {
        totalSum += nums[i]
        val next = i
        if (totalSum > k) {
            totalSum -= nums[start]
            start += 1
        } else if (totalSum == k) {
                val count = next - start + 1
            if (count > maxCount) {
                maxCount = count
                totalSum = nums[i]
                start = next
            }
        }


    }
    return maxCount
}