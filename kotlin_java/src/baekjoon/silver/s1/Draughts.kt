package baekjoon.silver.s1

fun main() {
    val dx = intArrayOf(-1, -1, 1, 1)
    val dy = intArrayOf(-1, 1, -1, 1)

    repeat(readln().toInt()) {
        readln()
        val board = Array(10) { readln().toCharArray() }
        var answer = 0

        fun dfs(x: Int, y: Int): Int {
            var maxCapture = 0

            for (d in 0 until 4) {
                val nx = x + dx[d] * 2
                val ny = y + dy[d] * 2
                val mx = x + dx[d]
                val my = y + dy[d]
                if (nx !in 0 until 10 || ny !in 0 until 10 || board[nx][ny] != '#' || board[mx][my] != 'B') continue
                board[x][y] = '#'
                board[mx][my] = '#'
                board[nx][ny] = 'W'
                maxCapture = maxOf(maxCapture, 1 + dfs(nx, ny))
                board[x][y] = 'W'
                board[mx][my] = 'B'
                board[nx][ny] = '#'
            }
            return maxCapture
        }

        for (i in 0 until 10) {
            for (j in 0 until 10) {
                if (board[i][j] == 'W') {
                    answer = maxOf(answer, dfs(i, j))
                }
            }
        }

        println(answer)
    }
}
