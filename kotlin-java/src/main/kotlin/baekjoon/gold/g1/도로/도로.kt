package baekjoon.gold.g1.`도로`

import java.util.LinkedList
import java.util.Queue

data class Road(val from: Int, val to: Int)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n) { it }
    val q = LinkedList<Road>() as Queue<Road>

    repeat(n) { i ->
        val input = readLine().toCharArray()
        for (j in i + 1..<n) {
            if (input[j] == 'Y') q.add(Road(i, j))
        }
    }

    if (q.size < m) {
        println(-1)
        return
    }

    val count = Array(n) { 0 }
    var unionCount = 0
    val restQ = LinkedList<Road>() as Queue<Road>

    while (q.isNotEmpty()) {
        val (from, to) = q.poll()
        if (union(from, to)) {
            count[from]++
            count[to]++
            unionCount++
        } else {
            restQ.add(Road(from, to))
        }
    }

    if (unionCount < n - 1) {
        println(-1)
        return
    }

    repeat(m - unionCount) {
        val (from, to) = restQ.poll()
        count[from]++
        count[to]++
    }

    println(count.joinToString(" "))
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    if (px == py) return false
    if (px < py) parent[py] = px
    else parent[px] = py
    return true
}