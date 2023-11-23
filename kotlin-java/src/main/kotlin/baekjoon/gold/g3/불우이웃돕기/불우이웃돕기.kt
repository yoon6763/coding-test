package baekjoon.gold.g3.불우이웃돕기

import java.util.PriorityQueue
import kotlin.system.exitProcess

data class Edge(val from: Int, val to: Int, val weight: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.weight - other.weight
    }
}

lateinit var parent: Array<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    parent = Array(n + 1) { it }

    // 0 -> 0, a ~ z -> 1 ~ 26, A ~ Z -> 27 ~ 52
    val map = Array(n) {
        val line = readLine()
        Array<Int>(n) {
            when {
                line[it].isDigit() -> 0
                line[it].isLowerCase() -> line[it] - 'a' + 1
                else -> line[it] - 'A' + 27
            }
        }
    }


    val pq = PriorityQueue<Edge>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] > 0) {
                pq.offer(Edge(i, j, map[i][j]))
            }
        }
    }

    var total = map.sumOf { it.sum() }

    while (pq.isNotEmpty()) {
        val target = pq.poll()
        if (union(target.to, target.from)) total -= target.weight
    }

    val firstParent = find(0)
    for (i in 1 until n) {
        if (firstParent != find(i)) {
            println(-1)
            exitProcess(0)
        }
    }

    println(total)
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val nx = find(x)
    val ny = find(y)

    return if (nx != ny) {
        parent[nx] = ny
        true
    } else false
}