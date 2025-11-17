package baekjoon.silver.s1.`NM과 K (1)`

lateinit var map: Array<List<Int>>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)
var n = 0
var m = 0
var k = 0
var answer = Int.MIN_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val nmk = readLine().split(" ").map { it.toInt() }
    n = nmk[0]
    m = nmk[1]
    k = nmk[2]
    visited = Array(n) { BooleanArray(m) }
    map = Array(n) { readLine().split(" ").map { it.toInt() } }

    dfs(0, 0, 0)
    println(answer)
}

fun dfs(index: Int, depth: Int, sum: Int) {
    if (depth == k) {
        answer = maxOf(answer, sum)
        return
    }

    nextIndex@ for (i in index..<n * m) {
        val x = i / m
        val y = i % m
        if (visited[x][y]) continue

        for (j in 0..<4) {
            val nx = x + dx[j]
            val ny = y + dy[j]
            if (nx !in 0..<n || ny !in 0..<m) continue
            if (visited[nx][ny]) continue@nextIndex
        }

        visited[x][y] = true
        dfs(i, depth + 1, sum + map[x][y])
        visited[x][y] = false
    }
}