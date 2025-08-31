package baekjoon.silver.s1

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val graph = Array(n) { mutableListOf<Int>() }
    val visited = IntArray(n)

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() - 1 }
        graph[a].add(b)
        graph[b].add(a)
    }

    fun dfs(node: Int, color: Int) {
        visited[node] = color
        graph[node].forEach { next ->
            if (visited[next] != 0) return@forEach
            dfs(next, color)
        }
    }

    var color = 1

    for (i in 0..<n) {
        if (visited[i] != 0) continue
        dfs(i, color++)
    }

    println(color - 2)
}