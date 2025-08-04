package baekjoon.silver.s1

fun main() {
    val (k, n, m) = readln().split(" ").map { it.toInt() }

    val startPoints = Array(k) { readln().toInt() - 1 }
    val graph = Array(n) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() - 1 }
        graph[a] += b
    }

    val visitedCount = IntArray(n)
    val visited = BooleanArray(n)

    fun dfs(cur: Int) {
        visited[cur] = true
        visitedCount[cur]++
        graph[cur].forEach { next ->
            if (visited[next]) return@forEach
            dfs(next)
        }
    }

    startPoints.forEach { start ->
        visited.fill(false)
        dfs(start)
    }

    println(visitedCount.count { it == k })
}