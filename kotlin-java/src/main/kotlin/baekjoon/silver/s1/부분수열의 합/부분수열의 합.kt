package baekjoon.silver.s1.`부분수열의 합`

var n = 0
lateinit var arr: IntArray
lateinit var visited: BooleanArray

fun main() {
    n = readln().toInt()
    arr = readln().split(" ").map { it.toInt() }.toIntArray()
    visited = BooleanArray(100000 * 20 + 1)

    solve(0, 0)
    println(visited.indexOfFirst { !it })
}

fun solve(depth: Int, sum: Int) {
    visited[sum] = true
    if (depth == n) return
    solve(depth + 1, sum + arr[depth])
    solve(depth + 1, sum)
}