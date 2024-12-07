package baekjoon.gold.g4.`Yes or yes`

import java.util.StringTokenizer
import kotlin.system.exitProcess

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var isGomgomPoint: BooleanArray
var n = 0
var m = 0
var s = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    graph = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)

    repeat(m) {
        val st = StringTokenizer(readLine())
        graph[st.nextToken().toInt()].add(st.nextToken().toInt())
    }

    s = readLine().toInt()
    isGomgomPoint = BooleanArray(n + 1)
    readLine().split(" ").map { it.toInt() }.forEach { isGomgomPoint[it] = true }

    if (isGomgomPoint[1]) {
        println("Yes")
        exitProcess(0)
    }

    if (graph[1].isEmpty()) {
        println("yes")
        exitProcess(0)
    }

    visited[1] = true
    dfs(1)

    println("Yes")
}

fun dfs(cur: Int) {
    graph[cur].forEach { next ->
        if (isGomgomPoint[next] || visited[next]) return@forEach

        if (graph[next].isEmpty()) {
            println("yes")
            exitProcess(0)
        }

        visited[next] = true
        dfs(next)
    }
}