package baekjoon.silver.s3.`그녀를 찾아서`

import java.util.*

var graph = Array(4) { Array(4) { 0.0 } }
var table = Array(4) { 0.0 }
var maxDepth = 0

fun main() = with(System.`in`.bufferedReader()) {
    maxDepth = readLine().toInt()

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        graph[st.nextToken()[0] - 'A'][st.nextToken()[0] - 'A'] = st.nextToken().toDouble()
    }

    for (i in 0..<4) dfs(i, 0.25, 0)
    println(table.joinToString("\n") { (it * 100.0).toString() })
}

fun dfs(cur: Int, percent: Double, depth: Int) {
    if (depth == maxDepth) {
        table[cur] += percent
        return
    }

    for (next in 0..<4) {
        if (graph[cur][next] == 0.0) continue
        dfs(next, percent * graph[cur][next], depth + 1)
    }
}