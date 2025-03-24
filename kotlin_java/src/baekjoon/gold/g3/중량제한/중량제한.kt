package baekjoon.gold.g3.중량제한

import java.util.LinkedList
import java.util.Queue

data class Edge(val to: Int, val weight: Int)

var n = 0
lateinit var connect: Array<ArrayList<Edge>>
var start = 0
var end = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map(String::toInt)
    n = nm[0]
    val m = nm[1]
    connect = Array(n + 1) { ArrayList() }

    var (left, right) = arrayOf(Int.MAX_VALUE, 0)
    repeat(m) {
        val (from, to, weight) = readLine().split(" ").map(String::toInt)
        connect[from].add(Edge(to, weight))
        connect[to].add(Edge(from, weight))
        left = minOf(left, weight)
        right = maxOf(right, weight)
    }

    val se = readLine().split(" ").map(String::toInt)
    start = se[0]
    end = se[1]

    var answer = 0

    while (left <= right) {
        val mid = (left + right) / 2

        if (bfs(mid)) {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    print(answer)
}

fun bfs(maxWeight: Int): Boolean {
    val queue = LinkedList<Int>() as Queue<Int>
    val visited = BooleanArray(n + 1) { false }

    queue.offer(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        connect[cur].forEach { next ->
            if (visited[next.to] || next.weight < maxWeight) return@forEach
            if (next.to == end) return true

            queue.offer(next.to)
            visited[next.to] = true
        }
    }

    return false
}