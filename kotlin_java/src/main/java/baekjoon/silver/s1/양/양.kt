package baekjoon.silver.s1.`양`

lateinit var visited: Array<BooleanArray>
lateinit var map: Array<CharArray>
var dx = intArrayOf(0, 0, -1, 1)
var dy = intArrayOf(-1, 1, 0, 0)
var wolfCount = 0
var sheepCount = 0
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) }

    var ansWolfCount = 0
    var ansSheepCount = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            wolfCount = 0
            sheepCount = 0
            dfs(i, j)

            if (wolfCount >= sheepCount) {
                ansWolfCount += wolfCount
            } else {
                ansSheepCount += sheepCount
            }
        }
    }

    println("$ansSheepCount $ansWolfCount")
}

fun dfs(x: Int, y: Int) {
    if (x !in 0..<n || y !in 0..<m || visited[x][y]) return

    when (map[x][y]) {
        'v' -> wolfCount++
        'o' -> sheepCount++
        '#' -> return
    }

    visited[x][y] = true

    for (i in 0..<4) {
        dfs(x + dx[i], y + dy[i])
    }
}