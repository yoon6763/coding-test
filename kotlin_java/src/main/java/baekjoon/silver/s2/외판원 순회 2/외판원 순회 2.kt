package baekjoon.silver.s2.`외판원 순회 2`

lateinit var visited: BooleanArray
lateinit var connect: Array<List<Int>>
var n = 0
var min = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    connect = Array(n) { readLine().split(" ").map { it.toInt() } }
    visited = BooleanArray(n)

    for (i in 0 until n) {
        visited[i] = true
        backTracking(1, i, i, 0)
        visited[i] = false
    }

    println(min)
}

fun backTracking(depth: Int, startTown: Int, town: Int, sum: Int) {
    if (depth == n) {
        if (connect[town][startTown] != 0) min = minOf(min, sum + connect[town][startTown])
        return
    }

    for (nextTown in 0 until n) {
        if (!visited[nextTown] && connect[town][nextTown] != 0) {
            visited[nextTown] = true
            backTracking(depth + 1, startTown, nextTown, sum + connect[town][nextTown])
            visited[nextTown] = false
        }
    }
}