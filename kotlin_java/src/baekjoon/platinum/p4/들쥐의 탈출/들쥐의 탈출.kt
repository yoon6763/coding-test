package baekjoon.platinum.p4.`들쥐의 탈출`

import java.util.StringTokenizer
import kotlin.math.pow

data class Node(val x: Double, val y: Double)

lateinit var hidden: Array<Int>
lateinit var visited: Array<Boolean>
lateinit var graph: Array<MutableList<Int>>

var n = 0
var m = 0
var s = 0
var v = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nmsv = readLine().split(" ").map { it.toInt() }
    n = nmsv[0]
    m = nmsv[1]
    s = nmsv[2]
    v = nmsv[3]

    hidden = Array(m) { -1 }
    visited = Array(n) { false }

    val mouse = Array(n) {
        val st = StringTokenizer(readLine())
        Node(st.nextToken().toDouble(), st.nextToken().toDouble())
    }

    val hole = Array(m) {
        val st = StringTokenizer(readLine())
        Node(st.nextToken().toDouble(), st.nextToken().toDouble())
    }

    graph = Array(n) { mutableListOf<Int>() }

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (getDistance(mouse[i], hole[j]) <= s * s * v * v) {
                graph[i].add(j)
            }
        }
    }

    var answer = 0
    for (i in 0..<n) {
        visited.fill(false)
        if (dfs(i)) answer++
    }

    println(n - answer)
}

fun dfs(cur: Int): Boolean {
    if (visited[cur]) return false
    visited[cur] = true

    for (next in graph[cur]) {
        if (hidden[next] == -1 || dfs(hidden[next])) {
            hidden[next] = cur
            return true
        }
    }

    return false
}

fun getDistance(node1: Node, node2: Node): Double {
    return (node1.x - node2.x).pow(2.0) + (node1.y - node2.y).pow(2.0)
}