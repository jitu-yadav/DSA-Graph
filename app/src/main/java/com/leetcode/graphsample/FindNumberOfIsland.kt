package com.leetcode.graphsample

object FindNumberOfIsland {

    fun clusterCount(matrix: Array<IntArray>) {
        if (matrix.isEmpty()) {
            return
        }

        var clusterCount = 0
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 1) {
                    clusterCount++
                    dfs(matrix, i, j)
                }
            }
        }
        println("Cluster Count $clusterCount ")

    }

    fun dfs(matrix: Array<IntArray>, i: Int, j: Int) {
        if (i < 0 || i >= matrix.size || j < 0 || j >= matrix[i].size || matrix[i][j] == 0) {
            return
        }
        matrix[i][j] = 0
        dfs(matrix, i + 1, j)
        dfs(matrix, i - 1, j)
        dfs(matrix, i, j + 1)
        dfs(matrix, i, j - 1)
    }

}