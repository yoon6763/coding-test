package baekjoon.gold.g3.`성곽`

lateinit var map: Array<List<Int>>
lateinit var visited: Array<IntArray>
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var roomSize = 0
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val mn = readLine().split(" ").map { it.toInt() }
    n = mn[1]
    m = mn[0]

    visited = Array(n) { IntArray(m) }
    map = Array(n) { readLine().split(" ").map { it.toInt() } }

    var groupIndex = 1
    val groupSizes = ArrayList<Int>().apply { add(0) }

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (visited[i][j] != 0) continue
            roomSize = 0

            dfs(i, j, groupIndex)

            if (roomSize == 0) continue
            groupSizes.add(roomSize)
            groupIndex++
        }
    }

    var maxSizeOfWhenWallBroken = 0

    for (x in 0..<n) {
        for (y in 0..<m) {
            for (k in 0..<4) {
                val nx = x + dx[k]
                val ny = y + dy[k]
                if (nx !in 0..<n || ny !in 0..<m || visited[x][y] == visited[nx][ny]) continue
                maxSizeOfWhenWallBroken = maxOf(maxSizeOfWhenWallBroken, groupSizes[visited[x][y]] + groupSizes[visited[nx][ny]])
            }
        }
    }

    println(groupSizes.count() - 1)
    println(groupSizes.max())
    println(maxSizeOfWhenWallBroken)
}

fun dfs(x: Int, y: Int, groupIndex: Int) {
    if (x !in 0..<n || y !in 0..<m || visited[x][y] != 0) return
    visited[x][y] = groupIndex
    roomSize++

    if (map[x][y] or 8 != map[x][y]) dfs(x + 1, y, groupIndex)
    if (map[x][y] or 4 != map[x][y]) dfs(x, y + 1, groupIndex)
    if (map[x][y] or 2 != map[x][y]) dfs(x - 1, y, groupIndex)
    if (map[x][y] or 1 != map[x][y]) dfs(x, y - 1, groupIndex)
}