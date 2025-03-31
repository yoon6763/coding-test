package baekjoon.silver.s2.`Alien Attack 2`

lateinit var graph: Array<MutableList<Int>>
lateinit var visited: BooleanArray
var n = 0
var size = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }

    n = nm[0]
    graph = Array(n + 1) { mutableListOf() }
    visited = BooleanArray(n + 1)

    repeat(nm[1]) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    var ans = 0
    for (i in 1..n) {
        if (visited[i]) continue
        size = 0
        dfs(i)
        ans = maxOf(ans, size)
    }

    println(ans)
}

fun dfs(x: Int) {
    visited[x] = true
    size++
    for (i in graph[x]) {
        if (visited[i]) continue
        dfs(i)
    }
}