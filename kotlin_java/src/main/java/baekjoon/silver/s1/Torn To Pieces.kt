package baekjoon.silver.s1

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val graph = mutableMapOf<String, MutableSet<String>>()

    repeat(n) {
        val st = StringTokenizer(readln())
        val from = st.nextToken()
        while (st.hasMoreTokens()) {
            val to = st.nextToken()
            graph.getOrPut(from) { mutableSetOf() }.add(to)
            graph.getOrPut(to) { mutableSetOf() }.add(from)
        }
    }

    val visited = mutableSetOf<String>()
    val (start, end) = readln().split(" ")

    fun dfs(cur: String, end: String): List<String>? {
        visited += cur
        if (cur == end) return listOf(cur)
        (graph[cur] ?: emptySet()).forEach { next ->
            if (next in visited) return@forEach
            dfs(next, end).let { if (it != null) return listOf(cur) + it }
        }
        return null
    }

    println(dfs(start, end)?.joinToString(" ") ?: "no route found")
}