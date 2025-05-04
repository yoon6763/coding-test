package baekjoon.gold.g4.JungleRoads

import java.util.StringTokenizer

data class Edge(val v1: Int, val v2: Int, val cost: Int)

lateinit var parent: IntArray

fun main() = generateSequence { readln().toInt().takeIf { it != 0 } }.forEach { n ->
    parent = IntArray(n) { it }
    val edges = ArrayList<Edge>()
    repeat(n - 1) {
        StringTokenizer(readln()).run {
            while (hasMoreTokens()) edges += Edge(it, nextToken()[0] - 'A', nextToken().toInt())
        }
    }
    println(edges.sortedBy { it.cost }.fold(0) { acc, next -> if (union(next.v1, next.v2)) acc + next.cost else acc })
}

fun find(x: Int): Int = if (parent[x] == x) x else find(parent[x]).also { parent[x] = it }
fun union(x: Int, y: Int) = find(x).let { px -> find(y).let { py -> (px != py).also { if (it) parent[px] = py } } }