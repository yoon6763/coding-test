package baekjoon.silver.s2.TreasureCave

import java.util.LinkedList
import java.util.Queue

lateinit var cave: Array<MutableList<Int>>
lateinit var pre: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, goal) = readLine().split(" ").map { it.toInt() }

    cave = Array(n + 1) { mutableListOf() }
    pre = IntArray(n + 1) { -1 }

    repeat(m) {
        val (number, v1, v2) = readLine().split(" ").map { it.toInt() }
        cave[number].add(v1)
        cave[number].add(v2)
    }

    dfs(1)

    val q = LinkedList<Int>() as Queue<Int>
    q.offer(goal)

    val path = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        val cur = q.poll()
        path.add(cur)
        if (cur == 1) break
        q.offer(pre[cur])
    }

    println(path.size)
    println(path.reversed().joinToString("\n"))
}

fun dfs(cur: Int) {
    cave[cur].forEach {
        if (pre[it] != -1) return@forEach
        pre[it] = cur
        dfs(it)
    }
}