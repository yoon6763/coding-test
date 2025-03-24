package baekjoon.gold.g5.트리_색칠하기

import java.util.*

lateinit var tree: Array<MutableList<Int>>
lateinit var colors: IntArray
lateinit var visited: BooleanArray
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    colors = "0 ${readLine()}".split(" ").map { it.toInt() }.toIntArray()
    tree = Array(n + 1) { mutableListOf() }

    repeat(n - 1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }

    visited = BooleanArray(n + 1) { false }

    var cnt = 0
    val q: Queue<Int> = LinkedList()
    q.add(1)
    visited[1] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()

        tree[cur].forEach { child ->
            if (visited[child]) return@forEach
            visited[child] = true
            q.add(child)
            if (colors[child] != colors[cur]) cnt++
        }
    }

    if (colors[1] != 0) cnt++
    println(cnt)
}