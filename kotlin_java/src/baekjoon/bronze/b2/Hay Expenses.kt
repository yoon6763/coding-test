package baekjoon.bronze.b2

fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val hay = listOf(0) + List(n) { readln().toInt() }

    val acc = IntArray(n + 1)
    for (i in 1..n) {
        acc[i] = acc[i - 1] + hay[i]
    }

    repeat(q) {
        val (s, e) = readln().split(" ").map { it.toInt() }
        println(acc[e] - acc[s - 1])
    }
}
