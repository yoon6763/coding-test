package baekjoon.silver.s2

fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    val f = readln().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (i in 1..n) graph[f[i - 1]].add(i)

    println("Case #${it + 1}:")

    val visited = BooleanArray(n + 1)

    fun dfs(cur: Int) {
        visited[cur] = true
        graph[cur].forEach { next ->
            if (visited[next]) return@forEach
            dfs(next)
        }
    }

    for (i in 1..n) {
        visited.fill(false)
        dfs(i)
        println(visited.count { it })
    }
}
