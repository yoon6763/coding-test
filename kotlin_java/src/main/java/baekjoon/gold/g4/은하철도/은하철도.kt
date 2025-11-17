package baekjoon.gold.g4.은하철도

import kotlin.collections.toIntArray

lateinit var parent: IntArray
lateinit var sum: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    parent = IntArray(n + 1) { it }
    sum = (listOf(0) + List(n) { readln().toInt() }).toIntArray()

    repeat(m) {
        val (v1, v2) = readln().split(" ").map { it.toInt() }.sorted()
        union(v1, v2)
        println(sum[find(v1)])
    }
}

fun find(x: Int): Int {
    if (x == parent[x]) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)
    if (px == py) return
    parent[py] = px
    sum[px] += sum[py]
}