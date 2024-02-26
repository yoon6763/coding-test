package baekjoon.silver.s2.`알고리즘 수업 - 깊이 우선 탐색 5`

import java.util.*
import kotlin.collections.ArrayList

lateinit var connect: Array<ArrayList<Int>>
lateinit var depth: Array<Int>
lateinit var sequence: Array<Int>
var sequenceIdx = 2
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    val (m, start) = Array(2) { st.nextToken().toInt() }

    connect = Array(n + 1) { ArrayList<Int>() }
    depth = Array(n + 1) { -1 }
    sequence = Array(n + 1) { 0 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = Array(2) { st.nextToken().toInt() }
        connect[v1].add(v2)
        connect[v2].add(v1)
    }
    connect.forEach { it.sort() }

    depth[start] = 0
    sequence[start] = 1
    dfs(start)
    var sum = 0L
    for(i in 1 .. n) sum += depth[i].toLong() * sequence[i].toLong()
    println(sum)
}

fun dfs(node: Int) {
    connect[node].forEach { next ->
        if (depth[next] == -1) {
            depth[next] = depth[node] + 1
            sequence[next] = sequenceIdx++
            dfs(next)
        }
    }
}