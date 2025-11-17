package baekjoon.platinum.p3.`돌멩이 제거`

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var matched: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { ArrayList<Int>() }
    matched = IntArray(n + 1) { -1 }

    repeat(m) {
        val (r, c) = readLine().split(" ").map { it.toInt() }
        graph[r].add(c)
    }

    var answer = 0
    for (i in 1..n) {
        visited = BooleanArray(n + 1)
        if (dfs(i)) answer++
    }

    println(answer)
}

fun dfs(cur: Int): Boolean {
    if (visited[cur]) return false
    visited[cur] = true

    for(next in graph[cur]) {
        if(matched[next] == -1 || dfs(matched[next])) {
            matched[next] = cur
            return true
        }
    }

    return false
}