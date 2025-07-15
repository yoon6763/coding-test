package baekjoon.silver.s1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val money = IntArray(n) { readln().toInt() }
    val parent = IntArray(n) { it }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val (px, py) = find(x) to find(y)
        if (px != py) parent[py] = px
    }

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        union(a, b)
    }

    val sum = IntArray(n)
    for (i in 0..<n) sum[find(i)] += money[i]

    println(if (sum.all { it == 0 }) "POSSIBLE" else "IMPOSSIBLE")
}