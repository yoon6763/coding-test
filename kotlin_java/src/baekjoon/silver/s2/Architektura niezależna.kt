package baekjoon.silver.s2

fun main() {
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    var n = readln().toInt()
    var m = readln().toInt()


    val map = Array(n + 2) { Array(m + 2) { ' ' } }
    for (i in 1..n) {
        val input = readln().toCharArray()
        for (j in 1..m) {
            map[i][j] = input[j - 1]
        }
    }

    val visited = Array(n + 2) { BooleanArray(m + 2) }

    fun dfs(x: Int, y: Int) {
        visited[x][y] = true
        for (i in 0..<4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 1..n && ny in 1..m && !visited[nx][ny] && map[nx][ny] != '#') {
                dfs(nx, ny)
            }
        }
    }

    var count = 0
    dfs(0, 0)
    for (i in 1..n) {
        for (j in 1..m) {
            if (!visited[i][j] && map[i][j] != '#') {
                count++
            }
        }
    }

    println(count)
}