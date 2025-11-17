package baekjoon.silver.s3

fun main() = repeat(readln().toInt()) {
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    val (n, m) = readln().split(" ").map { it.toInt() }
    val maze = Array(n) { readln().toCharArray() }

    val visited = Array(n) { IntArray(m) }
    val q = ArrayDeque<Pair<Int, Int>>()

    for (i in 0..<n) for (j in 0..<m) {
        if (maze[i][j] != 'S') continue
        q.add(Pair(i, j))
        visited[i][j] = 1
    }

    var ans = -1

    bfs@ while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0..<n || ny !in 0..<m || maze[nx][ny] == 'X' || visited[nx][ny] > 0) continue
            if (maze[nx][ny] == 'G') {
                ans = visited[x][y]
                break@bfs
            }
            visited[nx][ny] = visited[x][y] + 1
            q.add(nx to ny)
        }
    }

    println(if (ans == -1) "No Exit" else "Shortest Path: $ans")
}