package baekjoon.bronze.b4

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    if (n >= 8) println(n - 7) else println(m + 7)
}