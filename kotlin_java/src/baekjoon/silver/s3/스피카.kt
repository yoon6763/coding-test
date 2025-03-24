package baekjoon.silver.s3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val degree = IntArray(13)
    val graph = Array(13) { ArrayList<Int>() }

    for (i in 0..<12) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        degree[a]++
        degree[b]++
        graph[a].add(b)
        graph[b].add(a)
    }

    for (i in 1..12) {
        if (degree[i] == 3 && graph[i].sumOf { degree[it] } == 6) {
            println(i)
            return
        }
    }
}
