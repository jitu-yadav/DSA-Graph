package com.leetcode.graphsample.graph

import java.util.PriorityQueue

/**
 * 1. start with priority Queue by adding all the edges
 * 2. start a loop till priority Queue is not empty
 *    a. poll the edge from priority Queue
 *    b. check if source and destination vertex is already visited if yes continue to next iteration
 *    c. add source and destination vertex to visited set
 *    d. add edge to result list --> this will be minimum edge spanning tree
 * */

object KruskalsAlgorithm {

    fun minimumSpanningTree(graph: WeightedGraph): List<GraphEdge> {
        val adjacencyList = graph.getAdjacencyList()
        val queue = PriorityQueue<GraphEdge>(compareBy { it.weight })

        for (graphEdgeList in adjacencyList) {
            queue.addAll(graphEdgeList)
        }

        val visited = mutableSetOf<Int>()
        val mstEdges = mutableListOf<GraphEdge>()

        while(queue.isNotEmpty()) {
            val edge = queue.poll()

            val source  = edge.source
            val destination = edge.destination

            if (visited.contains(source) && visited.contains(destination)) continue

            visited.add(source)
            visited.add(destination)

            mstEdges.add(edge)
        }

        return mstEdges
    }

}