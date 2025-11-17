package baekjoon.gold.g4.`무기 공학`

lateinit var map: Array<List<Int>>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, -1, 0, 1)
var n = 0
var m = 0
var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    map = Array(n) { readLine().split(" ").map { it.toInt() } }
    visited = Array(n) { BooleanArray(m) }
    makeBoomerang(0, 0)
    println(answer)
}

fun makeBoomerang(index: Int, score: Int) {
    answer = maxOf(answer, score)

    for (i in index..<n * m) {
        val x = i / m
        val y = i % m

        for (j in 0..<4) {
            val nx1 = x + dx[j]
            val ny1 = y + dy[j]
            val nx2 = x + dx[(j + 1) % 4]
            val ny2 = y + dy[(j + 1) % 4]

            if (nx1 !in 0..<n || nx2 !in 0..<n ||
                ny1 !in 0..<m || ny2 !in 0..<m ||
                visited[x][y] || visited[nx1][ny1] || visited[nx2][ny2]
            ) continue

            visited[x][y] = true
            visited[nx1][ny1] = true
            visited[nx2][ny2] = true
            makeBoomerang(i + 1, score + map[x][y] * 2 + map[nx1][ny1] + map[nx2][ny2])
            visited[x][y] = false
            visited[nx1][ny1] = false
            visited[nx2][ny2] = false
        }
    }
}