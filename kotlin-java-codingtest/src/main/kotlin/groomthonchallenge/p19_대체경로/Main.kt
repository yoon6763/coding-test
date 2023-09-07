package groomthonchallenge.p19_대체경로

import java.util.StringTokenizer

var n = 0
var m = 0
var s = 0
var e = 0
lateinit var connect: Array<Array<Boolean>>
lateinit var visited: BooleanArray
lateinit var minDistanceWhenCityDisable: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val nmse = StringTokenizer(readLine())
    n = nmse.nextToken().toInt()
    m = nmse.nextToken().toInt()
    s = nmse.nextToken().toInt()
    e = nmse.nextToken().toInt()

    connect = Array(n + 1) { Array(n + 1) { false } }
    minDistanceWhenCityDisable = IntArray(n + 1) { Int.MAX_VALUE }
    repeat(m) {
        val st = StringTokenizer(readLine())
        val (a, b) = st.nextToken().toInt() to st.nextToken().toInt()
        connect[a][b] = true
        connect[b][a] = true
    }

    visited = BooleanArray(n + 1) { false }
    visited[s] = true
    dfs(s, 1)


    val sb = StringBuilder()
    for (i in 1..n) {
        if (minDistanceWhenCityDisable[i] == Int.MAX_VALUE) sb.append(-1).append("\n")
        else sb.append(minDistanceWhenCityDisable[i]).append("\n")
    }

    print(sb)
}

fun dfs(cur: Int, depth: Int) {
    if (cur == e) {
        for (disableCity in 1..n) {
            if (visited[disableCity]) continue
            minDistanceWhenCityDisable[disableCity] = minDistanceWhenCityDisable[disableCity].coerceAtMost(depth)
        }

        return
    }

    for (next in 1..n) {
        if (visited[next] || !connect[cur][next]) continue
        visited[next] = true

        dfs(next, depth + 1)
        visited[next] = false
    }
}