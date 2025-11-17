package baekjoon.gold.g2.Labyrinth

data class Node(val x: Int, val y: Int)

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

fun main() = repeat(readln().toInt()) {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln() }
    val startNode = (0..<n).asSequence().flatMap { i -> (0..<m).asSequence().map { j -> i to j } }
        .first { (i, j) -> map[i][j] == '.' }
        .let { (i, j) -> Node(i, j) }

    val bfs = { start: Node ->
        val queue = ArrayDeque<Node>()
        val visited = Array(n) { IntArray(m) { 0 } }
        queue.add(start)
        visited[start.x][start.y] = 1

        while (queue.isNotEmpty()) {
            val (x, y) = queue.removeFirst()

            for (i in 0..<4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] != '.' || visited[nx][ny] != 0) continue
                visited[nx][ny] = visited[x][y] + 1
                queue.add(Node(nx, ny))
            }
        }

        visited
    }

    val first = bfs(startNode)

    val maxNode = (0..<n).asSequence().flatMap { i ->
        (0..<m).asSequence().map { j -> Node(i, j) to first[i][j] }
    }.maxBy { it.second }.first

    val second = bfs(maxNode)

    println("Maximum rope length is ${second.maxOf { it.max() } - 1}.")
}