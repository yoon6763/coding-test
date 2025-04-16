package baekjoon.silver.s2.`연결 요소의 개수`

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    println((1..n).sumOf { dfs(it, graph, visited) })
}

fun dfs(cur: Int, graph: Array<MutableList<Int>>, visited: BooleanArray): Int {
    return if (visited[cur]) 0 else {
        visited[cur] = true
        graph[cur]
            .filter { !visited[it] }
            .forEach { dfs(it, graph, visited) }
        1
    }
}