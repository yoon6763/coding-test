package baekjoon.platinum.p4.열혈강호

import java.util.StringTokenizer

lateinit var connected: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var d: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    connected = Array(n + 1) { ArrayList<Int>() }
    visited = BooleanArray(m + 1)
    d = IntArray(m + 1) { -1 }

    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        repeat(st.nextToken().toInt()) {
            connected[i].add(st.nextToken().toInt())
        }
    }

    var count = 0
    for (i in 1..n) {
        visited.fill(false)
        if (dfs(i)) count++
    }

    println(count)
}

fun dfs(cur: Int): Boolean {
    connected[cur].forEach { next ->
        if (visited[next]) return@forEach
        visited[next] = true

        if (d[next] == -1 || dfs(d[next])) {
            d[next] = cur
            return true
        }
    }

    return false
}