package baekjoon.bronze.b4

fun main() {
    val (n, m, s) = readln().split(" ").map { it.toLong() }
    println(minOf((s * (100 - n) * (m + 1)) / 100, s * m))
}
