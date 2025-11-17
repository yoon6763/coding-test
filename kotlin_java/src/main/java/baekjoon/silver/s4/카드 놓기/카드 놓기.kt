package baekjoon.silver.s4.`카드 놓기`

lateinit var visited: BooleanArray
lateinit var arr: Array<String>
val combination = HashSet<String>()
var n = 0
var k = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    k = readLine().toInt()

    visited = BooleanArray(n)
    arr = Array(n) { readLine() }
    backTracking(0, "")
    println(combination.size)
}

fun backTracking(depth: Int, str: String) {
    if (depth == k) {
        combination.add(str)
        return
    }

    for (i in 0 until n) {
        if (visited[i]) continue
        visited[i] = true
        backTracking(depth + 1, str + arr[i])
        visited[i] = false
    }
}