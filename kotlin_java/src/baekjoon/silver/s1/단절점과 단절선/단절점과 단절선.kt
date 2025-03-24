package baekjoon.silver.s1.`단절점과 단절선`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(n - 1) {
        val (v1, v2) = readLine().split(" ").map { it.toInt() }
        graph[v1].add(v2)
        graph[v2].add(v1)
    }

    repeat(readLine().toInt()) {
        readLine().split(" ").map { it.toInt() }.let { (t,k) ->  println((if (t == 1) if (graph[k].size != 1) "yes" else "no" else "yes")) }
    }
}