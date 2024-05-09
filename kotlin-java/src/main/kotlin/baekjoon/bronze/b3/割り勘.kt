package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        println(readln().split(" ").sumOf { minOf(it.toInt(), m / n) })
    }
}