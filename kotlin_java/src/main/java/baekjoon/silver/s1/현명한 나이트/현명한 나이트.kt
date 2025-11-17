package baekjoon.silver.s1.`현명한 나이트`

data class Node(val x: Int, val y: Int) {
    constructor(xy: List<Int>) : this(xy[0], xy[1])
}

fun main() = with(System.`in`.bufferedReader()) {
    val dx = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
    val dy = intArrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val start = Node(readLine().split(" ").map { it.toInt() - 1 })
    val map = Array(n) { Array(n) { -1 } }
    val minDistanceEachEnemy = IntArray(m)

    repeat(m) {
        val enemy = Node(readLine().split(" ").map { it.toInt() - 1 })
        map[enemy.x][enemy.y] = it
    }

    val queue = ArrayDeque<Node>()
    queue.add(start)
    val visited = Array(n) { IntArray(n) { -1 } }
    visited[start.x][start.y] = 0

    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()

        for (i in 0..<8) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx !in 0..<n || ny !in 0..<n || visited[nx][ny] != -1) continue
            visited[nx][ny] = visited[cur.x][cur.y] + 1
            queue.add(Node(nx, ny))

            if (map[nx][ny] != -1) {
                minDistanceEachEnemy[map[nx][ny]] = visited[nx][ny]
            }
        }
    }

    println(minDistanceEachEnemy.joinToString(" "))
}