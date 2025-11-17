package baekjoon.silver.s1

fun main() {
    var count = readln().toInt()
    val n = readln().toInt()
    val m = readln().toInt()
    val map = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    val sizeList = mutableListOf<Int>()

    fun dfs(x: Int, y: Int): Int {
        if (x !in 0..<n || y !in 0..<m || visited[x][y] || map[x][y] == 'I') return 0
        visited[x][y] = true
        var size = 1
        for (i in 0..<4) size += dfs(x + dx[i], y + dy[i])
        return size
    }

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (!visited[i][j] && map[i][j] == '.') {
                val size = dfs(i, j)
                if (size > 0) sizeList += size
            }
        }
    }


    var roomCount = 0

    for (it in sizeList.sortedBy { -it }) {
        if (count - it >= 0) {
            count -= it
            roomCount++
        } else break
    }

    if (roomCount == 1) println("1 room, $count square metre(s) left over")
    else println("$roomCount rooms, $count square metre(s) left over")
}
