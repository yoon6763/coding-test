package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, maxDepth) = readLine().split(" ").map { it.toInt() }
    val connect = Array(n) { mutableListOf<Int>() }
    repeat(n-1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        connect[a].add(b)
        connect[b].add(a)
    }

    val visited = IntArray(n)
    val queue = mutableListOf<Int>()
    queue.add(0)
    visited[0] = 1

    var answer = 0
    val apple = readLine().split(" ").map { it.toInt() }

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()
        if (apple[cur] == 1) answer++

        for (next in connect[cur]) {
            if (visited[next] != 0 || visited[cur] == maxDepth + 1) continue
            visited[next] = visited[cur] + 1
            queue.add(next)
        }
    }

    println(answer)
}