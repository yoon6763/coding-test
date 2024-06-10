package goormlevel.lv2.`Game Jam`

lateinit var map: Array<Array<Pair<Int, Char>>>
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    val (gx, gy) = readLine().split(" ").map { it.toInt() - 1 }
    val (px, py) = readLine().split(" ").map { it.toInt() - 1 }

    map = Array(n) {
        val line = readLine().split(" ")
        Array(n) { Pair(line[it].substring(0, line[it].length - 1).toInt(), line[it].last()) }
    }

    val pCnt = game(px, py)
    val gCnt = game(gx, gy)

    print(if (pCnt > gCnt) "player $pCnt" else "goorm $gCnt")
}

fun game(x: Int, y: Int): Int {
    val visited = Array(n) { BooleanArray(n) }
    visited[x][y] = true
    var x = x
    var y = y
    var cnt = 1

    while (true) {
        val dx = arrayOf(-1, 0, 1, 0)
        val dy = arrayOf(0, 1, 0, -1)
        val direction = when (map[x][y].second) {
            'U' -> 0
            'D' -> 2
            'L' -> 3
            'R' -> 1
            else -> -1
        }

        for (i in 0 until map[x][y].first) {
            x += dx[direction]
            y += dy[direction]

            if (x == n) x = 0
            if (y == n) y = 0
            if (x == -1) x = n - 1
            if (y == -1) y = n - 1

            if (visited[x][y]) return cnt
            visited[x][y] = true
            cnt++
        }
    }
}