package com.leetcode.graphsample.graph

class WeightedGraph(private val vertices: Int) {
    private val adjacencyList : MutableList<MutableList<GraphEdge>> =
        MutableList(vertices) { mutableListOf() }

    fun addDirectedEdge(source: Int, desitination: Int, weight:Int) {
        val edge = GraphEdge(source, desitination, weight)
        adjacencyList[source].add(edge)
    }

    fun addUndirectedEdge(source: Int, desitination: Int, weight:Int) {
        addDirectedEdge(source, desitination, weight)
        addDirectedEdge(desitination, source, weight)
    }

    fun getAdjacencyList() : List<List<GraphEdge>> {
        return adjacencyList
    }

    fun getVertices() : Int {
        return vertices
    }

}