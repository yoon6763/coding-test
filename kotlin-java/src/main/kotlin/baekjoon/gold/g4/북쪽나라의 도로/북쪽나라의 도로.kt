package baekjoon.gold.g4.`북쪽나라의 도로`

data class Edge(val to: Int, val weight: Int)

const val n = 10001
val graph = Array(n) { ArrayList<Edge>() }
val visited = IntArray(n)
var ans = 1

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        try {
            val line = readLine()
            val (u, v, w) = line.split(" ").map { it.toInt() }
            graph[u].add(Edge(v, w))
            graph[v].add(Edge(u, w))
        } catch (e: Exception) {
            break
        }
    }

    for (i in 1..<n) {
        if (graph[i].isEmpty()) continue
        visited.fill(0)
        visited[i] = 1
        dfs(i)
        ans = maxOf(ans, visited.max())
    }

    println(ans - 1)
}

fun dfs(cur: Int) {
    graph[cur].forEach { (next, weight) ->
        if (visited[next] != 0) return@forEach
        visited[next] = visited[cur] + weight
        dfs(next)
    }
}