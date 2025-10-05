package com.leetcode.graphsample.problems

import kotlin.math.sqrt

object checkifNumberIsPrime {

    fun isPrime(n: Int): Boolean {
        if (n < 2) return false

        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if(n % i == 0) return false
        }

        return true
    }

}