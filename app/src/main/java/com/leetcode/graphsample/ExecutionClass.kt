package com.leetcode.graphsample

fun main() {
    val weightedGraph = WeightedGraph(6)

    weightedGraph.addUndirectedEdge(0, 1, 10)
    weightedGraph.addUndirectedEdge(1, 2, 5)
    weightedGraph.addUndirectedEdge(1, 3, 10)
    weightedGraph.addUndirectedEdge(2, 4, 15)
    weightedGraph.addUndirectedEdge(3, 4, 20)
    weightedGraph.addUndirectedEdge(3, 5, 25)
    weightedGraph.addUndirectedEdge(4, 5, 30)
    weightedGraph.addUndirectedEdge(1, 5, 35)
    weightedGraph.addUndirectedEdge(2, 3, 40)
    weightedGraph.addUndirectedEdge(2, 5, 45)

    val adjacencyList = weightedGraph.getAdjacencyList()

    /*for (i in 0 until adjacencyList.size) {
        println("Adjacency list for vertex $i:")
        for (edge in adjacencyList[i]) {
            println("Destination: ${edge.destination}, Weight: ${edge.weight}")
        }
    }*/

    // Minimum Prism Spanning Tree
    val minimumSpanningTree = PrismAlgorithm.minimumSpanningTree(weightedGraph)

    // println("PrismAlgorithm Minimum Spanning Tree: $minimumSpanningTree")


    // Minimum KruskalsAlgorithm Spanning Tree
    val krushalSpanningTree = KruskalsAlgorithm.minimumSpanningTree(weightedGraph)

    // println("KruskalsAlgorithm Minimum Spanning Tree: $krushalSpanningTree")

    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    println("row: $n, column: $m")

    val matrix = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    println("matrix: $matrix")

    // Find the number of clusters
    findCluster(matrix)



}



fun findCluster(matrix: Array<IntArray>) {
    val n = matrix.size
    val visited = BooleanArray(n)
    var clusterCount = 0

    for (city in 0 until n) {
        println("visited[city] : ${visited[city]}")
        if (!visited[city]) {
            dfs(matrix, visited, city)
            clusterCount++
        }
    }

    println("Cluster Count $clusterCount ")
}
fun dfs(matrix: Array<IntArray>, visited: BooleanArray, city: Int) {
    visited[city] = true
    for (neighbour in matrix.indices) {
        println("city: $city, neighbour: $neighbour, visited[neighbour]: ${visited[neighbour]}")
        if (matrix[city][neighbour] == 1 && !visited[neighbour]) {
            dfs(matrix, visited, neighbour)
        }
    }
}

