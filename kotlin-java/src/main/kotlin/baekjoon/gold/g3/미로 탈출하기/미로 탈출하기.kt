package baekjoon.gold.g3.`미로 탈출하기`

val direction = hashMapOf(
    'U' to Pair(-1, 0),
    'D' to Pair(1, 0),
    'L' to Pair(0, -1),
    'R' to Pair(0, 1)
)
lateinit var map: Array<CharArray>
lateinit var visited: Array<IntArray>
val exitSet = hashSetOf<Int>()
var n = 0
var m = 0
var ans = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    map = Array(n) { readLine().toCharArray() }
    visited = Array(n) { IntArray(m) { -1 } }

    var mapIndex = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j] != -1) continue
            if (dfs(i, j, mapIndex++)) {
                ans++
            }
        }
    }

    println(ans)
}

fun dfs(x: Int, y: Int, mapIndex: Int): Boolean {
    visited[x][y] = mapIndex

    val dir = direction[map[x][y]]!!
    val nx = x + dir.first
    val ny = y + dir.second

    if (nx !in 0 until n || ny !in 0 until m) {
        exitSet.add(mapIndex)
        return true
    }

    if (visited[nx][ny] != -1) {
        if (visited[nx][ny] in exitSet) {
            exitSet.add(mapIndex)
            return true
        } else {
            return false
        }
    }

    if (dfs(nx, ny, mapIndex)) {
        ans++
        return true
    }

    return false
}