package baekjoon.gold.g3

fun main() {
    val (n, m, s) = readln().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val (px, py) = find(x) to find(y)
        if (px == py) return false
        parent[py] = px
        return true
    }

    println(List(m) { readln().split(" ").map { it.toInt() } }
        .sortedBy { it[2] }
        .filter { union(it[0], it[1]) }
        .sumOf { it[2] })
}