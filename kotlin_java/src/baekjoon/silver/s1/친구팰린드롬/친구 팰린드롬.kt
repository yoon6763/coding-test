package baekjoon.silver.s1.친구팰린드롬

fun main() {
    data class Node(var x: Int, var y: Int)

    val (n, m) = readln().split(" ").map { it.toInt() }
    var max = 0

    val graph = Array(m) {
        val input = readln().split(" ").map { it.toInt() }
        Node(input[0], input[1])
    }

    val visited = BooleanArray(n + 1)

    fun solve(depth: Int, cnt: Int) {
        if (depth == m) {
            max = maxOf(max, cnt)
            return
        }

        val (x, y) = graph[depth]

        if (visited[x] || visited[y]) {
            solve(depth + 1, cnt)
        } else {
            visited[y] = true
            visited[x] = visited[y]
            solve(depth + 1, cnt + 1)

            visited[y] = false
            visited[x] = visited[y]
            solve(depth + 1, cnt)
        }
    }

    solve(0, 0)

    println(if (max * 2 < n) max * 2 + 1 else max * 2)
}