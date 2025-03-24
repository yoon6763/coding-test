package baekjoon.platinum.p5.`Strongly Connected Component`

import java.lang.StringBuilder
import java.util.Stack
import java.util.StringTokenizer
import java.util.TreeMap

lateinit var visited: Array<Boolean>
lateinit var stack: Stack<Int>
lateinit var graph: Array<ArrayList<Int>>
lateinit var reversedGraph: Array<ArrayList<Int>>
lateinit var result: Array<ArrayList<Int>>


fun main() = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    result = Array(v + 1) { ArrayList() }
    graph = Array(v + 1) { ArrayList() }
    reversedGraph = Array(v + 1) { ArrayList() }

    repeat(e) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = Array(2) { st.nextToken().toInt() }
        graph[v1].add(v2)
        reversedGraph[v2].add(v1)
    }

    stack = Stack()
    visited = Array(v + 1) { false }

    for (i in 1..v) {
        if (!visited[i]) dfs(i)
    }

    repeat(v + 1) { visited[it] = false }
    var groupIdx = 0

    while (stack.isNotEmpty()) {
        val target = stack.pop()
        if (visited[target]) continue
        reversedDfs(target, groupIdx++)
    }

    sb.append(groupIdx).append("\n")

    val map = TreeMap<Int, Int>()
    repeat(groupIdx) {
        result[it].sort()
        map[result[it][0]] = it
    }

    map.forEach { (t, u) ->

        result[u].forEach {
            sb.append(it).append(" ")
        }
        sb.append("-1\n")
    }

    print(sb)
}

fun dfs(start: Int) {
    visited[start] = true

    graph[start].forEach { now ->
        if (!visited[now]) dfs(now)
    }
    stack.push(start)
}

fun reversedDfs(start: Int, groupIdx: Int) {
    visited[start] = true
    result[groupIdx].add(start)

    reversedGraph[start].forEach { now ->
        if (!visited[now]) reversedDfs(now, groupIdx)
    }
}