package groomthonchallenge.p20_연결요소제거하기

import java.util.StringTokenizer

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
var n = 0
var k = 0
val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)
var depth = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nkq = readLine().split(" ").map(String::toInt)
    n = nkq[0]
    k = nkq[1]
    val q = nkq[2]

    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(n) }

    repeat(q) {
        val st = StringTokenizer(readLine())
        val (x, y) = st.nextToken().toInt() - 1 to st.nextToken().toInt() - 1
        val word = st.nextToken()[0]
        visited.forEach { it.fill(false) }

        depth = 0
        map[x][y] = word
        dfs(x, y, word, false)
        visited.forEach { it.fill(false) }
        if (depth >= k) dfs(x, y, word, true)
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            print(map[i][j])
        }
        println()
    }
}


fun dfs(x: Int, y: Int, word: Char, removeMode: Boolean) {
    visited[x][y] = true
    depth++
    if (removeMode) map[x][y] = '.'

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until n || map[nx][ny] != word || visited[nx][ny]) continue

        dfs(nx, ny, word, removeMode)
    }
}