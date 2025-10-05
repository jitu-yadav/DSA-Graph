package com.leetcode.graphsample.graph

import java.util.PriorityQueue

object DijesktraAlgorithm {

    fun shortestPathFromSource(weightedGraph: WeightedGraph, source:Int): IntArray {
        val distance = IntArray(weightedGraph.getVertices()) { Int.MAX_VALUE }

        val priorityQueue = PriorityQueue<GraphEdge>(compareBy { it.weight })

        distance[source] = 0
        priorityQueue.add(GraphEdge(source, source, 0))

        val result = mutableListOf<GraphEdge>()

        while (priorityQueue.isNotEmpty()) {
            val currentEdge = priorityQueue.poll()
            currentEdge?.let {
                for (edge in weightedGraph.getAdjacencyList()[it.destination]) {
                    val newDistance = distance[edge.destination] + edge.weight

                    if(newDistance < distance[edge.destination]) {
                        distance[edge.destination] = newDistance
                        priorityQueue.add(GraphEdge(edge.source, edge.destination, newDistance))
                    }
                }
            }
        }

        return distance
    }

}