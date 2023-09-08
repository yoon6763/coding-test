package groomthonchallenge.p16_연합

lateinit var connect: Array<BooleanArray>
lateinit var visited: BooleanArray
var groupCnt = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map(String::toInt)

    connect = Array(n + 1) { BooleanArray(n + 1) }
    repeat(m) {
        val (a, b) = readLine().split(" ").map(String::toInt)
        connect[a][b] = true
    }

    visited = BooleanArray(n + 1)
    for (i in 1..n) {
        if (!visited[i]) {
            dfs(i)
            groupCnt++
        }
    }

    println(groupCnt)
}

fun dfs(cur: Int) {
    visited[cur] = true

    for (next in visited.indices) {
        if (connect[cur][next] && connect[next][cur] && !visited[next]) {
            dfs(next)
        }
    }
}