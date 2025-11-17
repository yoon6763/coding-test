package baekjoon.gold.g2.`책 나눠주기`

import java.util.StringTokenizer

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var matched: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        // 책 개수, 학생 수
        val (n, m) = readLine().split(" ").map { it.toInt() }
        graph = Array(m + 1) { ArrayList<Int>() }
        matched = IntArray(n + 1) { -1 }

        for (studentIndex in 1..m) {
            val st = StringTokenizer(readLine())
            val (a, b) = st.nextToken().toInt() to st.nextToken().toInt()
            for (bookIndex in a..b) {
                graph[studentIndex].add(bookIndex)
            }
        }

        var answer = 0

        for (i in 1..m) {
            visited = BooleanArray(m + 1)
            if (dfs(i)) {
                answer++
            }
        }

        sb.appendLine(answer)
    }

    print(sb.toString())
}

fun dfs(cur: Int): Boolean {
    if (visited[cur]) return false
    visited[cur] = true

    for(next in graph[cur]) {
        if(matched[next] == -1 || dfs(matched[next])) {
            matched[next] = cur
            return true
        }
    }

    return false
}
