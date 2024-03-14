package baekjoon.gold.g4.`퍼레이드`

import java.util.*
import kotlin.system.exitProcess

lateinit var edgeVisited: Array<BooleanArray>
lateinit var graph: Array<ArrayList<Int>>
var v = 0
var e = 0

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    v = st.nextToken().toInt()
    e = st.nextToken().toInt()
    graph = Array(v) { ArrayList() }
    edgeVisited = Array(v) { BooleanArray(v) }

    repeat(e) {
        st = StringTokenizer(readLine())
        val (from, to) = st.nextToken().toInt() - 1 to st.nextToken().toInt() - 1
        graph[from].add(to)
        graph[to].add(from)
    }

    for (i in 0..<v) {
        edgeVisited.forEach { it.fill(false) }
        dfs(i, i, 0)
    }

    println("NO")
}

private fun dfs(cur: Int, dfsIndex: Int, depth: Int) {
    if (depth == e) {
        println("YES")
        exitProcess(0)
    }

    graph[cur].forEach { next ->
        if (edgeVisited[cur][next] || edgeVisited[next][cur]) return@forEach
        edgeVisited[cur][next] = true
        edgeVisited[next][cur] = true
        dfs(next, dfsIndex, depth + 1)
    }
}