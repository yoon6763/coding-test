package baekjoon.bronze.b3

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    println("${maxOf(0, n - (k * m))} ${n - (k - 1) * m - 1}")
}
