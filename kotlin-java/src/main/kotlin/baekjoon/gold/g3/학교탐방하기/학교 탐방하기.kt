package baekjoon.gold.g3.학교탐방하기

import java.util.PriorityQueue
import java.util.StringTokenizer

data class Edge(val from: Int, val to: Int, val weight: Int)

lateinit var parent: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val upPq = PriorityQueue<Edge> { o1, o2 -> o2.weight - o1.weight }
    val downPq = PriorityQueue<Edge> { o1, o2 -> o1.weight - o2.weight }

    repeat(m + 1) {
        val st = StringTokenizer(readLine())
        var (from, to, weight) = Array(3) { st.nextToken().toInt() }
        weight = if (weight == 1) 0 else 1 // 입력으로 0이 주어지면 오르막길, 1이 주어지면 내리막길이다!!!!!!
        upPq.offer(Edge(from, to, weight))
        downPq.offer(Edge(from, to, weight))
    }

    parent = Array(n + 1) { it }

    var max = 0
    var min = 0

    while (upPq.isNotEmpty()) {
        val target = upPq.poll()
        if (union(target.to, target.from)) max += target.weight
    }

    parent = Array(n + 1) { it }

    while (downPq.isNotEmpty()) {
        val target = downPq.poll()
        if (union(target.to, target.from)) min += target.weight
    }

    println(max * max - min * min)
}


fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        return parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val nx = find(x)
    val ny = find(y)

    return if (nx != ny) {
        parent[nx] = ny
        true
    } else false
}