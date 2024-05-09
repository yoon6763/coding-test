package baekjoon.silver.s2

fun main() {
    val n = readln().toInt()
    val arr = readln().trim().split(" ").map { it.toInt() }
    val visited = IntArray(n)
    val (start, end) = readln().trim().split(" ").map { it.toInt() - 1 }

    val q = ArrayDeque<Int>()
    q.add(start)
    visited[start] = 1

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (next in cur + arr[cur]..<n step arr[cur]) {
            if (visited[next] != 0) continue
            visited[next] = visited[cur] + 1
            q.add(next)

            if (next == end) {
                println(visited[cur])
                return
            }
        }

        for (next in cur - arr[cur] downTo 0 step arr[cur]) {
            if (visited[next] != 0) continue
            visited[next] = visited[cur] + 1
            q.add(next)

            if (next == end) {
                println(visited[cur])
                return
            }
        }
    }

    println(-1)
}