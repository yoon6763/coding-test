package baekjoon.silver.s3


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val target = readLine().toInt()
    val map = Array(n) { Array(n) { 0 } }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var dir = 0
    var (ansX, ansY) = listOf(0, 0)

    var cnt = n * n
    var (x, y) = listOf(0, 0)

    while (cnt > 0) {
        map[x][y] = cnt
        cnt--

        val nx = x + dx[dir]
        val ny = y + dy[dir]

        if (nx in 0..<n && ny in 0..<n && map[nx][ny] == 0) {
            x = nx
            y = ny
        } else {
            dir = (dir + 1) % 4
            x += dx[dir]
            y += dy[dir]
        }

        if (target == cnt) {
            ansX = x
            ansY = y
        }
    }

    val sb = StringBuilder()
    repeat(n) { i ->
        repeat(n) { j ->
            sb.append(map[i][j]).append(" ")
        }
        sb.appendLine()
    }
    print(sb)
    print("${ansX + 1} ${ansY + 1}")
}