package baekjoon.platinum.p4.노트북의_주인을_찾아서

import java.util.*
import kotlin.collections.ArrayList

lateinit var connected: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var d: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val nmMax = maxOf(n, m)

    connected = Array(nmMax + 1) { ArrayList<Int>() }
    visited = BooleanArray(nmMax + 1)
    d = IntArray(nmMax + 1) { -1 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = listOf(st.nextToken().toInt(), st.nextToken().toInt())
        connected[v1].add(v2)
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