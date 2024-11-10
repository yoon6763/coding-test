package baekjoon.platinum.p4.`MooTube (Gold)`

import java.util.*

class Edge(var from: Int, var to: Int, var weight: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int = other.weight - this.weight
}

class Query(var queryIdx: Int, var k: Int, var target: Int) : Comparable<Query> {
    override fun compareTo(other: Query) = other.k - this.k
}

var n = 0
var q = 0
lateinit var parents: IntArray
lateinit var count: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, q) = readLine().split(" ").map { it.toInt() }
    parents = IntArray(n) { -1 }
    count = IntArray(n) { 1 }

    val edges = Array(n - 1) {
        val st = StringTokenizer(readLine())
        Edge(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1, st.nextToken().toInt())
    }.sortedArray()

    val queries = Array(q) {
        val st = StringTokenizer(readLine())
        Query(it, st.nextToken().toInt(), st.nextToken().toInt() - 1)
    }.sortedArray()

    val result = IntArray(q)
    var queryPtr = 0

    queries.forEach { query ->
        while (queryPtr < edges.size && edges[queryPtr].weight >= query.k) {
            union(edges[queryPtr].from, edges[queryPtr].to)
            queryPtr++
        }

        result[query.queryIdx] = count[find(query.target)] - 1
    }

    println(result.joinToString("\n"))
}

fun find(x: Int): Int = if (parents[x] == -1) x else (find(parents[x]).also { parents[x] = it })

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)
    count[py] += count[px]
    parents[px] = py
}