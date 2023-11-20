package baekjoon.silver.s1.Red_And_Black

data class Node(val x: Int, val y: Int)

lateinit var visited: Array<BooleanArray>
lateinit var map: Array<CharArray>
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var cnt = 0
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val nm = readLine().split(" ").map { it.toInt() }
        n = nm[1]
        m = nm[0]
        if (n == 0 && m == 0) break

        var start = Node(0, 0)

        map = Array(n) { x ->
            val line = readLine().toCharArray()
            for (y in line.indices) if (line[y] == '@') start = Node(x, y)
            line
        }
        visited = Array(n) { BooleanArray(m) }

        cnt = 1
        visited[start.x][start.y] = true

        dfs(start.x, start.y)
        sb.append(cnt).append("\n")
    }

    print(sb)
}

fun dfs(x: Int, y: Int) {
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] || map[nx][ny] == '#') continue
        visited[nx][ny] = true
        cnt++
        dfs(nx, ny)
    }
}