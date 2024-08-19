package baekjoon.silver.s3.`Daisy Chains in the Field`

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: BooleanArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { ArrayList() }
    visited = BooleanArray(n)

    repeat(m) {
        val (v1, v2) = readln().split(" ").map { it.toInt() - 1 }
        graph[v1].add(v2)
        graph[v2].add(v1)
    }

    dfs(0)
    print(if (visited.all { it }) 0
    else visited.mapIndexed { index, b -> if (!b) index + 1 else 0 }
        .filter { it != 0 }
        .joinToString("\n"))
}

fun dfs(cur: Int) {
    visited[cur] = true
    graph[cur].forEach { next ->
        if (visited[next]) return@forEach
        dfs(next)
    }
}