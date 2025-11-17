package baekjoon.silver.s1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val maze = Array(n) { readln().toCharArray() }

    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(1, 0, -1, 0)

    var ans = 0
    var dotRemoved = false

    fun dfs(x: Int, y: Int) {
        if (maze[x][y] == '.') dotRemoved = true
        maze[x][y] = 'X'
        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in 0 until n || ny !in 0 until m || maze[nx][ny] in 'A'..'Z' || maze[nx][ny] == 'X') continue
            dfs(nx, ny)
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (maze[i][j] in 'A'..'W') {
                dotRemoved = false
                dfs(i, j)
                if (dotRemoved) ans++
            }
        }
    }

    println("$ans ${maze.sumOf { it.count { it == '.' } }}")
}