package baekjoon.bronze.b3

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    println(if (readln().split(" ").map { it.toInt() }.sumOf { if (it % 2 == 0) it / 2 else it / 2 + 1 } >= n) "YES" else "NO")
}