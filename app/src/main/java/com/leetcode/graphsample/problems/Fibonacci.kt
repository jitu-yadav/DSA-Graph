package com.leetcode.graphsample.problems

object Fibonacci {

    //using recursion time complexity O(2^n) space complexity O(n)
    fun fibonacci(n: Int): Int {
        if (n <= 1) return n

        val num = fibonacci(n - 1) + fibonacci(n - 2)

        println("n: $num")

        return num
    }

    //using for loop time complexity O(n) space complexity O(1)
    fun fibonacciUsingLoop(n: Int) {
        if (n <= 0) return

        var a = 0
        var b = 1

        println("F(0): $a")
        if (n >= 2) {
            println("F(1): $a")
        }

        for (i in 2 until n) {
            val next = a + b
            println("F($i): $next")
            a = b
            b = next
        }
    }

    //Using memoization time complexity O(n) space complexity O(n)
    private val memo = mutableMapOf<Int, Int>()
    fun fibonacciUsingMemoization(n: Int): Int {
        if (n <= 1) return n

        if (memo.containsKey(n)) {
            return memo[n]!!
        }

        val num = fibonacciUsingMemoization(n - 1) + fibonacciUsingMemoization(n - 2)
        memo[n] = num

        println("n: $num")

        return num
    }
}