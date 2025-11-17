package baekjoon.silver.s1.FencePlanning

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val positions = Array(n) { Pair(0, 0) }

    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        positions[it] = Pair(x, y)
    }

    val graph = Array(n) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() - 1 }
        graph[a].add(b)
        graph[b].add(a)
    }

    val visited = BooleanArray(n)
    var ans = Long.MAX_VALUE

    fun bfs(start: Int) {
        val q = LinkedList<Int>()
        val group = mutableListOf<Int>()
        q.add(start)
        visited[start] = true

        while (q.isNotEmpty()) {
            val cur = q.poll()
            group.add(cur)
            graph[cur].forEach { next ->
                if (!visited[next]) {
                    visited[next] = true
                    q.add(next)
                }
            }
        }

        var minX = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var minY = Int.MAX_VALUE
        var maxY = Int.MIN_VALUE

        group.forEach {
            val (x, y) = positions[it]
            minX = minOf(minX, x)
            maxX = maxOf(maxX, x)
            minY = minOf(minY, y)
            maxY = maxOf(maxY, y)
        }

        ans = minOf(ans, 2L * (maxX - minX + maxY - minY))
    }

    for (i in 0..<n) {
        if (!visited[i]) bfs(i)
    }

    println(ans)
}
