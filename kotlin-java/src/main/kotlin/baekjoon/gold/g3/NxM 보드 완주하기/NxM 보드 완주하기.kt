package baekjoon.gold.g3.`NxM 보드 완주하기`

lateinit var board: Array<CharArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var n = 0
var m = 0
var ans = 0
var spaceCount = 0

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    for (case in 1..100) {
        val nm = (readLine() ?: break).split(" ").map { it.toInt() }
        n = nm[0]
        m = nm[1]

        spaceCount = n * m
        board = Array(n) { readLine().toCharArray().onEach { if (it == '*') spaceCount-- } }
        visited = Array(n) { BooleanArray(m) }
        ans = Int.MAX_VALUE

        for (i in 0..<n) {
            for (j in 0..<m) {
                if (board[i][j] != '.') continue
                visited[i][j] = true
                spaceCount--
                dfs(i, j, 0)
                visited[i][j] = false
                spaceCount++
            }
        }

        sb.appendLine("Case ${case}: ${if (ans == Int.MAX_VALUE) -1 else ans}")
    }

    print(sb)
}

fun dfs(x: Int, y: Int, depth: Int) {
    if (spaceCount == 0) {
        ans = minOf(ans, depth)
        return
    }

    for (dir in 0..<4) {
        var nx = -1
        var ny = -1

        var movedDistance = 0

        for (distance in 1..30) {
            nx = x + dx[dir] * distance
            ny = y + dy[dir] * distance

            if (nx !in 0..<n || ny !in 0..<m || board[nx][ny] == '*' || visited[nx][ny]) break

            visited[nx][ny] = true
            movedDistance++
        }

        nx -= dx[dir]
        ny -= dy[dir]

        if (movedDistance > 0) {
            spaceCount -= movedDistance
            dfs(nx, ny, depth + 1)
            spaceCount += movedDistance

            repeat(movedDistance) {
                visited[nx][ny] = false
                nx -= dx[dir]
                ny -= dy[dir]
            }
        }
    }
}