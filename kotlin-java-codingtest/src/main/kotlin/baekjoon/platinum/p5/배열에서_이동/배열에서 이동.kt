package baekjoon.platinum.p5.배열에서_이동

data class Node(val x: Int, val y: Int)

lateinit var map: Array<List<Int>>

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)

var n = 0
var max = 0
var min = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    map = Array(n) { readLine().split(" ").map { it.toInt() } }
    max = map.maxOf { it.maxOrNull()!! }
    min = map.minOf { it.minOrNull()!! }

    var left = 0
    var right = max - min

    while (left <= right) {
        val mid = (left + right) / 2

        if (bfs(mid)) right = mid - 1
        else left = mid + 1
    }

    println(left)
}

fun bfs(diff: Int): Boolean {
    for (i in min..max - diff) {
        val validRange = i..i + diff

        if (map[0][0] !in validRange || map[n - 1][n - 1] !in validRange) continue

        val visited = Array(n) { BooleanArray(n) }
        val queue = ArrayDeque<Node>()
        queue.addLast(Node(0, 0))
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()

            for (j in 0 until 4) {
                val nx = cur.x + dx[j]
                val ny = cur.y + dy[j]

                if (nx !in 0 until n ||
                    ny !in 0 until n ||
                    map[nx][ny] !in validRange ||
                    visited[nx][ny]
                ) continue

                if (nx == n - 1 && ny == n - 1) return true

                queue.addLast(Node(nx, ny))
                visited[nx][ny] = true
            }
        }
    }

    return false
}