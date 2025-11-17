package baekjoon.silver.s1

import java.util.StringTokenizer

fun main() {
    val start = readln().toInt()
    val graph = Array(101) { mutableListOf<Int>() }
    val visited = IntArray(101)

    while (true) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        if (a == -1) break
        while (st.hasMoreTokens()) graph[st.nextToken().toInt()] += a
    }

    var last = -1

    fun dfs(cur: Int) {
        if (graph[cur].isEmpty()) return
        graph[cur].forEach { next ->
            visited[next] = cur
            last = next
            dfs(next)
        }
    }


    dfs(start)

    val answer = ArrayList<Int>()
    fun trackingPath(cur: Int) {
        answer += cur
        if (visited[cur] == 0) return
        trackingPath(visited[cur])
    }

    var root = -1
    for (i in 1..100) {
        if (graph[i].isEmpty()) {
            root = i
            break
        }
    }

    trackingPath(last)
    println(answer.reversed().joinToString(" "))
}