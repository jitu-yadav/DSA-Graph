package com.leetcode.graphsample

import java.util.PriorityQueue

/**
 * 1. start with any vertex here I started with startIndex = 0
 * 2. Add vertex to visited Set
 * 3. Add all the edges to priority Queue of current visited vertex
 * 4. Start a loop till priority Queue is not empty
 *    a. poll the edge from priority Queue
 *    b. check if destination vertex is already visited if yes continue to next iteration
 *    c. add destination vertex to visited set
 *    d. add edge to result list --> this will be minimum edge spanning tree
 *    e. add all the edges of destination vertex to priority Queue
 *    f. repeat step a to e till priority Queue is not empty
 *
 *  5. return result list
 * */

object PrismAlgorithm {
    fun minimumSpanningTree(graph: WeightedGraph) : List<GraphEdge> {
        val adjacencyList = graph.getAdjacencyList()
        val priorityQueue = PriorityQueue<GraphEdge>(compareBy { it.weight })
        val visited = mutableSetOf<Int>()
        val result = mutableListOf<GraphEdge>()

        val startIndex = 0
        visited.add(startIndex)
        priorityQueue.addAll(adjacencyList[startIndex])

        while (priorityQueue.isNotEmpty()) {
            val edge = priorityQueue.poll()

            println("edge.destination = ${edge.destination} edge.weight = ${edge.weight}")

            if(visited.contains(edge.destination)) continue

            println("edge.destination = ${edge.destination} edge.weight = ${edge.weight} add to result")

            visited.add(edge.destination)
            result.add(edge)

            priorityQueue.addAll(adjacencyList[edge.destination])
        }

        return result
    }
}