package baekjoon.gold.g2

import java.util.*

fun main() {
    val (n, t, g) = readln().split(" ").map { it.toInt() }
    val ans = bfs(n, g, t)
    println(if (ans == -1) "ANG" else ans)
}

fun bfs(n: Int, g: Int, t: Int): Int {
    val visited = BooleanArray(100000) { false }
    val q = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
    q.add(Pair(n, 0))

    while (q.isNotEmpty()) {
        val (cur, depth) = q.poll()

        if (depth > t) return -1
        if (cur == g) return depth

        if (cur + 1 <= 99999 && !visited[cur + 1]) {
            q.add(Pair(cur + 1, depth + 1))
            visited[cur + 1] = true
        }

        var next = cur * 2
        if (next !in 1..99999) continue

        next = next.toString().let { it[0].digitToInt().let { d -> (d - 1).digitToChar() + it.substring(1) } }.toInt()
        if (visited[next]) continue
        q.add(Pair(next, depth + 1))
        visited[next] = true
    }

    return -1
}