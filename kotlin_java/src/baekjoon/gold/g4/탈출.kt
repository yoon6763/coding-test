package baekjoon.gold.g4.탈출

data class Node(val x: Int, val y: Int)

val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(-1, 1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var start = Node(0, 0)

    val map = Array(n) { CharArray(m) }
    val waterQueue = ArrayDeque<Node>()
    val visited = Array(n) { IntArray(m) }
    val queue = ArrayDeque<Node>()

    repeat(n) { x ->
        val line = readLine()
        repeat(m) { y ->
            map[x][y] = line[y]
            when (map[x][y]) {
                'S' -> start = Node(x, y)
                '*' -> waterQueue.add(Node(x, y))
            }
        }
    }

    queue.add(start)
    visited[start.x][start.y] = 1

    while (true) {
        repeat(waterQueue.size) {
            val cur = waterQueue.removeFirst()

            for (i in 0..<4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == 'D' || map[nx][ny] == 'X' || map[nx][ny] == '*') continue
                map[nx][ny] = '*'
                waterQueue.add(Node(nx, ny))
            }
        }

        if (queue.isEmpty()) break

        repeat(queue.size) {
            val cur = queue.removeFirst()

            for (i in 0..<4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (nx !in 0..<n || ny !in 0..<m || map[nx][ny] == '*' || map[nx][ny] == 'X' || visited[nx][ny] != 0) continue
                if (map[nx][ny] == 'D') {
                    println(visited[cur.x][cur.y])
                    return
                }

                visited[nx][ny] = visited[cur.x][cur.y] + 1
                queue.add(Node(nx, ny))
            }
        }
    }

    println("KAKTUS")
}