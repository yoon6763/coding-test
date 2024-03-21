package baekjoon.gold.g4.`트리`

import java.util.*

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
var n = 0
var isTree = true

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    var testCaseIndex = 0

    while (true) {
        testCaseIndex++

        val (n, m) = readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }

        graph = Array(n + 1) { ArrayList() }
        visited = BooleanArray(n + 1)

        repeat(m) {
            val st = StringTokenizer(readLine())
            val (a, b) = Array(2) { st.nextToken().toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }

        var treeCnt = 0

        for (i in 1..n) {
            if (visited[i]) continue
            isTree = true
            visited[i] = true
            dfs(i, 0)
            if (isTree) {
                treeCnt++
            }
        }

        sb.append("Case ${testCaseIndex}: ").appendLine(
            when (treeCnt) {
                0 -> "No trees."
                1 -> "There is one tree."
                else -> "A forest of $treeCnt trees."
            }
        )
    }

    print(sb)
}

fun dfs(cur: Int, pre: Int) {
    graph[cur].forEach { next ->
        if (visited[next] && next != pre) isTree = false
        if (visited[next]) return@forEach
        visited[next] = true
        dfs(next, cur)
    }
}