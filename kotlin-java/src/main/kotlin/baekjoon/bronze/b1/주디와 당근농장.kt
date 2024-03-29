package baekjoon.bronze.b1

import java.util.*

fun main() {
    val (n, x, y) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { BooleanArray(n) }
    val dx = intArrayOf(1, 1, -1, -1)
    val dy = intArrayOf(1, -1, 1, -1)
    val q = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
    q.add(x - 1 to y - 1)
    map[x - 1][y - 1] = true

    while (q.isNotEmpty()) {
        val (cx, cy) = q.poll()
        for (i in 0..<4) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]
            if (nx !in 0..<n || ny !in 0..<n || map[nx][ny]) continue
            map[nx][ny] = true
            q.add(nx to ny)
        }
    }
    val sb = StringBuilder()

    map.forEach {
        sb.appendLine(it.joinToString("") { if (it) "v" else "." })
    }
    print(sb)
}