package baekjoon.silver.s2

fun main() {
    data class Node(val x: Int, val y: Int, val buffer: String)

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    val (n, m, l) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }

    val answer = ArrayList<String>()
    val notUse = "acm"

    val q = ArrayDeque<Node>()

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (map[i][j] !in notUse) q.add(Node(i, j, map[i][j].toString()))
        }
    }

    while (q.isNotEmpty()) {
        val (x, y, buffer) = q.removeFirst()

        if (buffer.length == l) {
            answer.add(buffer)
            continue
        }

        for (i in 0..<4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] in notUse) continue
            q.add(Node(nx, ny, buffer + map[nx][ny]))
        }
    }

    println(answer.size)
    println(answer.distinct().size)
}