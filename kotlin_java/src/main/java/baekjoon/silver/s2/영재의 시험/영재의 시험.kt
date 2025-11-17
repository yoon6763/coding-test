package baekjoon.silver.s2.`영재의 시험`

lateinit var arr: List<Int>
lateinit var visited: IntArray
var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    arr = readLine().split(" ").map { it.toInt() }
    visited = IntArray(10)
    dfs(0, 0)
    println(answer)
}

fun dfs(depth: Int, sum: Int) {
    if (depth == 10) {
        if (sum >= 5) answer++
        return
    }

    for (i in 1..5) {
        if (depth >= 2 && visited[depth - 1] == i && visited[depth - 2] == i) continue
        visited[depth] = i
        dfs(depth + 1, sum + if (visited[depth] == arr[depth]) 1 else 0)
    }
}